package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.EnvasadoControlNetoCorteDetalle;
import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoControlPesoNetoCabecera;
import com.nw.model.EnvasadoControlPesoNetoDetalle;
import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.EnvasadoProceso;
import com.nw.model.MaquinaCerradora;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoControlNetoCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoNetoCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoNetoDetalleDAO;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlNetoCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoNetoCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoNetoDetalleDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoFichaTecnicaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.MaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;

/**
 * 
 * @author Cls Mbaque
 * @since 18/04/2018
 */
public class EnvasadoDetalleControlPesoNetoMantenimientoWindow extends GenericForwardComposer {
//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoNetoMantenimientoWindow.class);
	/**
	 * 
	 */
	private static final int valorMaximoPesoFill = 10016;
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Label   lbFechaProduccion;
	Datebox dteFechaProduccion;
	
	Label   lbTurnoProduccion,  lbTurnoLabor,  lbItemOrdenCliente,  lbItemOrden,  lbMCerradora,  lbcvprot,  lbCorte;
	Listbox lbxTurnoProduccion, lbxTurnoLabor, lbxItemOrdenCliente, lbxItemOrden, lbxMCerradora, lbxcvprot, lbxCorte; 
	
	Label   lbVideoJet,  lbOrden,  lbProducto,  lbCliente,  lbTara,  lbPesoEnvase,  lbPLomos,  lbTrozos,  lbRallado,  lbAgua,  lbAceite,  lbCaldoVegetal,  lbConcentracion,  lbPesoneto,  lbObservacion;
	Textbox txtVideoJet,									txtTara, txtPesoEnvase, txtPLomos, txtTrozos, txtRallado, txtAgua, txtAceite, txtCaldoVegetal, txtConcentracion, txtObservacion;
	Label				 txtOrden, txtProducto, txtCliente;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	
	Checkbox cbxEliminar, cbxEliminarOrden;
	
	Rows rsCorte;
	
	private ProduccionDetalleOrden pdo;
	private EnvasadoProceso envasadoProceso;
	private Produccion produccion;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		
		cargaTurno();
		cargaLineaCerradora();
		cargaCVPROT();
		
		binder.loadAll();
	}

	public void onChange$dteFechaProduccion() {
		produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		List<EnvasadoProceso> listEProceso = new ArrayList<EnvasadoProceso>();
		if (produccion==null) {
			Sistema.mensaje("No existe una produccion configurada para la fecha seleccionada.");
			return;
		}
		listEProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByIdProduccion(produccion.getIdproduccion());
		
		if(listEProceso.isEmpty()) {
			Sistema.mensaje("No existe configuracion para la fecha seleccionada.");
			return;
		}
			
		cargaTurno(listEProceso);
		
	}
	
	private void cargaTurno(List<EnvasadoProceso> listEProceso) {
		
		lbxTurnoProduccion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProceso());
		li.setParent(lbxTurnoProduccion);
		
		for (EnvasadoProceso eProceso : listEProceso) {
			li = new Listitem();
			li.setValue(eProceso);
			new Listcell(eProceso.getTurno().getNombre()).setParent(li);
			li.setParent(lbxTurnoProduccion);
		}
		
		lbxTurnoProduccion.setSelectedIndex(0);
		
	}
	
	/**
	 * carga la lista Item-Orden-Peso-FechaReg-Cliente
	 */
	public void onSelect$lbxTurnoProduccion() {
		envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		List<EnvasadoControlPesoNetoCabecera> listaEcpnc = ecpncDAO.getByEnvasadoproceso(envasadoProceso.getIdenvasadoproceso());
		ProduccionDetalleOrden pdo;
		lbxItemOrdenCliente.getItems().clear();
		
		Listitem li = new Listitem();
		li.setValue(new Compuesto(new EnvasadoControlPesoNetoCabecera()));
		li.setParent(lbxItemOrdenCliente);
		
		/**
		 * fragmento de codigo para ordenar la lista por orden
		 */
		Collections.sort(listaEcpnc, new Comparator<EnvasadoControlPesoNetoCabecera>() 		
				{
					@Override
					public int compare(EnvasadoControlPesoNetoCabecera o1, EnvasadoControlPesoNetoCabecera o2) {
						return new String(o1.getProduccionDetalleOrden().getOrden()).compareTo(o2.getProduccionDetalleOrden().getOrden());
					}
				});

		
		/**
		 * fragmento de codigo para ordenar la lista por item
		 */
		Collections.sort(listaEcpnc, new Comparator<EnvasadoControlPesoNetoCabecera>() 		
		{
			@Override
			public int compare(EnvasadoControlPesoNetoCabecera o1, EnvasadoControlPesoNetoCabecera o2) {
				return new Integer(o1.getProduccionDetalleOrden().getItem()).compareTo(o2.getProduccionDetalleOrden().getItem());
			}
		});
		
				
		for (EnvasadoControlPesoNetoCabecera ecpnc : listaEcpnc) {
			pdo = ecpnc.getProduccionDetalleOrden();
			
			/**
			 * fragmento de codigo para ordenar la lista por Peso
			 */
			Collections.sort(ecpnc.getEnvasadoControlPesoNetoDetalles(), new Comparator<EnvasadoControlPesoNetoDetalle>() 		
					{
						@Override
						public int compare(EnvasadoControlPesoNetoDetalle o1, EnvasadoControlPesoNetoDetalle o2) {
							return new Double(o1.getPesoneto()).compareTo(o2.getPesoneto());
						}
					});
			
			/**
			 * fragmento de codigo para ordenar la lista por Fecha
			 */
			Collections.sort(ecpnc.getEnvasadoControlPesoNetoDetalles(), new Comparator<EnvasadoControlPesoNetoDetalle>() 		
					{
						@Override
						public int compare(EnvasadoControlPesoNetoDetalle o1, EnvasadoControlPesoNetoDetalle o2) {
							return new Long(o1.getFechareg().getTime()).compareTo(o2.getFechareg().getTime());
						}
					});
			
			
//			for(EnvasadoControlPesoNetoDetalle ecpnd : ecpnc.getEnvasadoControlPesoNetoDetalles()) {
				li = new Listitem();
				li.setValue(new Compuesto(ecpnc));
				
				new Listcell(pdo.getItem()
						+"-"+pdo.getOrden()
						+"-"+pdo.getCliente())
				.setParent(li);
				
				li.setParent(lbxItemOrdenCliente);
//			}
		}
		
		lbxItemOrdenCliente.setSelectedIndex(0);
		
		cargaCorte();
	}
	
	private void cargaTurno(){
		lbxTurnoLabor.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoLabor);
		
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		for (Turno turno : listaTurnos) {
			 li = new Listitem();
			 li.setValue(turno);
			 new Listcell(turno.getNombre()).setParent(li);
			 li.setParent(lbxTurnoLabor);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	public void onSelect$lbxItemOrdenCliente() {
		EnvasadoControlPesoNetoCabecera ecpnc = ((Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue()).envasadoControlPesoNetoCabecera;
		if (ecpnc.getTurno()==null)
			lbxTurnoLabor.setSelectedIndex(0);
		else
			lbxTurnoLabor.setSelectedIndex(ecpnc.getTurno().getIdturno());
		
		cargaItemOrden();
		cargaInformacionFormulario() ;
		cargaCorte();
	}
	
	public void onSelect$lbxItemOrden() {
		pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		txtVideoJet.setValue(pdo.getVideo());
		
		cargaInformacionFormulario();
		
	}
	
	private void cargaItemOrden() {
		ProduccionDetalleOrden pdoSeleccionado = (((Compuesto) lbxItemOrdenCliente
				.getSelectedItem().getValue()).envasadoControlPesoNetoCabecera).getProduccionDetalleOrden();
		if (pdoSeleccionado==null)
			pdoSeleccionado = new ProduccionDetalleOrden();
		
		Turno turno = ((EnvasadoProceso) lbxTurnoProduccion.getSelectedItem()
				.getValue()).getTurno(); 
		ProduccionDetalleOrdenDAO pdoDAO = new ProduccionDetalleOrdenDAOJpaImpl();
		List<ProduccionDetalleOrden> listaPdo = pdoDAO
				.obtieneDetalleOrdenByProduccionTurno(turno.getIdturno(),
						produccion.getIdproduccion());
		
		lbxItemOrden.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrden);
		
		for (ProduccionDetalleOrden pdo : listaPdo) {
			 li = new Listitem();
			 li.setValue(pdo);
			 new Listcell(pdo.getItem()+" - "+pdo.getOrden()).setParent(li);
			 li.setParent(lbxItemOrden);
			 if (pdo.getIdproducciondetalleorden().equals(pdoSeleccionado.getIdproducciondetalleorden()))
				 lbxItemOrden.setSelectedItem(li);
		}
		
	}
	
	private int cont=1;
	public void onClick$btnAgregarItem() {
		Row row = new Row();
		Checkbox cbxCorteItem;
		Intbox tbxCorteItem;
		
		cbxCorteItem = new Checkbox();
		cbxCorteItem.setChecked(false);
		cbxCorteItem.setWidth("10px");
		cbxCorteItem.setParent(row);
		
		tbxCorteItem = new Intbox();
		tbxCorteItem.setTabindex(cont);
		tbxCorteItem.setParent(row);
		
		row.setValue(null);
		row.setParent(rsCorte);
		
		cont = cont+1;
	}
	
	@SuppressWarnings("unchecked")
	public void onClick$btnEliminarItem() {
		
		List<Row> rowsElimina = new ArrayList<Row>();
		
		if (rsCorte.getChildren().isEmpty()) {
			Sistema.mensaje("No existen elementos seleccionados para eliminar.");
			return;
		}
		
		if (!cbxEliminar.isChecked()) {
			Sistema.mensaje("Debe confirmar para eliminar los elementos seleccionados.");
			return;
		}
		
		EnvasadoControlPesoNetoDetalleDAO envasadoControlPesoNetoDetalle = new EnvasadoControlPesoNetoDetalleDAOJpaImpl();
		for (Row r :(List<Row>)rsCorte.getChildren()) {
			Checkbox cbx = (Checkbox)r.getChildren().get(0);
			
			if (cbx.isChecked()) {
				rowsElimina.add(r);
				if (r.getValue()==null)
					envasadoControlPesoNetoDetalle.eliminaEnvasadoControlPesoNetoDetalle((EnvasadoControlPesoNetoDetalle)r.getValue());
			}
		}
		
		cbxEliminar.setChecked(false);
		binder.loadComponent(rsCorte);

		int iItemOrdenCliente = lbxItemOrdenCliente.getSelectedIndex();
		int iCorte = lbxCorte.getSelectedIndex();
 		onSelect$lbxTurnoProduccion();
		lbxItemOrdenCliente.setSelectedIndex(iItemOrdenCliente);
		onSelect$lbxItemOrdenCliente();
		lbxCorte.setSelectedIndex(iCorte);
		onSelect$lbxCorte();
		
	}
	
	private void cargaCorte() {
		
		lbxCorte.getItems().clear();
		
		Compuesto compuesto = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		EnvasadoControlPesoNetoCabecera ecpnc = compuesto.envasadoControlPesoNetoCabecera; 
		EnvasadoControlNetoCorteCabeceraDAO ecfccDAO = new EnvasadoControlNetoCorteCabeceraDAOJpaImpl();
		
		EnvasadoProceso envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		List<EnvasadoControlNetoCorteDetalle> listaEcncd = ecfccDAO
				.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso())
				.getEnvasadoControlNetoCorteDetalles();
		
		if (listaEcncd != null) {
			if (listaEcncd.isEmpty()) {
				Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
				return;
			}
		} else if (listaEcncd == null) {
			Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
			return;
		}
		
		Listitem li = new Listitem();
		li.setValue(new EnvasadoControlNetoCorteDetalle());
		li.setParent(lbxCorte);
		
		
		Collections.sort(listaEcncd, new Comparator<EnvasadoControlNetoCorteDetalle>() 		
		{
			@Override
			public int compare(EnvasadoControlNetoCorteDetalle o1, EnvasadoControlNetoCorteDetalle o2) {
				return new Integer(o1.getCorte()).compareTo(o2.getCorte());
			}
		});
		
		List<EnvasadoControlPesoNetoDetalle> listaEcpnd;
		String hora, minuto;
		for (EnvasadoControlNetoCorteDetalle liEcncd : listaEcncd) {
			li = new Listitem();
			li.setValue(liEcncd);

			hora = liEcncd.getHora()<=9?"0"+liEcncd.getHora():liEcncd.getHora().toString();
			minuto = liEcncd.getMinuto()<=9?"0"+liEcncd.getMinuto():liEcncd.getMinuto().toString();
			
			listaEcpnd = new ArrayList<>();
			
			if(ecpnc!=null)
				if (ecpnc.getEnvasadoControlPesoNetoDetalles()!=null)
					for (EnvasadoControlPesoNetoDetalle ecpfd : ecpnc.getEnvasadoControlPesoNetoDetalles())
						if (liEcncd.getIdenvasadocontrolnetocortedetalle().equals(ecpfd.getEnvasadoControlNetoCorteDetalle().getIdenvasadocontrolnetocortedetalle())) {
							listaEcpnd.add(ecpfd);
						}
			System.out.println(listaEcpnd.size());
			new Listcell(liEcncd.getCorte()+" ("+listaEcpnd.size()+")"+" -> "+hora+":"+minuto)
				.setParent(li);
			li.setParent(lbxCorte);
			
		}
		if (lbxCorte.getSelectedIndex()<0)
			lbxCorte.setSelectedIndex(0);
	}
	
	private void cargaListaCorte(int numeroCortes) {
		double numero = new ParametroDAOJpaImpl().findById(valorMaximoPesoFill).getValor();
		for (int i=0; i<numero-numeroCortes ; i++)
			onClick$btnAgregarItem();
	}
	
	public void onSelect$lbxCorte() {
		
		rsCorte.getChildren().clear();
		EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera = ((Compuesto) lbxItemOrdenCliente
				.getSelectedItem().getValue()).envasadoControlPesoNetoCabecera;
		
		List<EnvasadoControlPesoNetoDetalle> listaEcpnd = new ArrayList<EnvasadoControlPesoNetoDetalle>();
		EnvasadoControlPesoNetoDetalleDAO ecpndDAO = new EnvasadoControlPesoNetoDetalleDAOJpaImpl();
		EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle = (EnvasadoControlNetoCorteDetalle)lbxCorte.getSelectedItem().getValue();
		listaEcpnd = ecpndDAO.obtieneByEnvasadoControlPesoNetoDetalleByCorte(
				envasadoControlNetoCorteDetalle.getIdenvasadocontrolnetocortedetalle(), envasadoControlPesoNetoCabecera.getIdenvasadocontrolpesonetocabecera());

		Row row;
		
		for (EnvasadoControlPesoNetoDetalle ecpfd : listaEcpnd) {
			row = new Row();
				Checkbox chx = new Checkbox();
				chx.setParent(row);
				
				Intbox ibx = new Intbox();
				ibx.setValue( (int) ecpfd.getPesoneto() );
				ibx.setTabindex(cont);
				ibx.setReadonly(false);
				ibx.setParent(row);
			row.setValue(ecpfd);
			row.setParent(rsCorte);

			cont=cont+1;
		}
		
		if (listaEcpnd.isEmpty())
			cargaListaCorte(0);
		else
			cargaListaCorte(listaEcpnd.size());
		
		
	}
	
	private void cargaLineaCerradora() {
		List<MaquinaCerradora> listELC = (List<MaquinaCerradora>)new MaquinaCerradoraDAOJpaImpl().getAll();
		
		if (listELC.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para Linea Cerradora.");
			return;
		}
		
		lbxMCerradora.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new MaquinaCerradora());
		li.setParent(lbxMCerradora);
		
		for (MaquinaCerradora elc : listELC) {
			li = new Listitem();
			li.setValue(elc);
			new Listcell(elc.getDescripcion()).setParent(li);
			li.setParent(lbxMCerradora);
		}
		
		lbxMCerradora.setSelectedIndex(0);
		
	}
	
	private void cargaCVPROT(){
		EnvasadoCaldoVegetalProteinaDAO ecvpDAO = new EnvasadoCaldoVegetalProteinaDAOJpaImpl();
		List<EnvasadoCaldoVegetalProteina> listECVP = ecvpDAO.getEnvasadoCaldoVegetalProteina();
		
		if (listECVP.isEmpty()) {
			Sistema.mensaje("No se encuentra configurado informacion para Caldo-Vegetal-Proteina.");
			return;
		}
		
		lbxcvprot.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoCaldoVegetalProteina());
		li.setParent(lbxcvprot);
		
		for (EnvasadoCaldoVegetalProteina ecvp : listECVP) {
			li = new Listitem();
			li.setValue(ecvp);
			new Listcell(ecvp.getDescripcion()).setParent(li);
			li.setParent(lbxcvprot);
		}
		
		lbxcvprot.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unchecked")
	private void cargaInformacionFormulario() {
		Compuesto compuesto = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		EnvasadoControlPesoNetoCabecera ecpnc = compuesto.envasadoControlPesoNetoCabecera;
		if (ecpnc.getProduccionDetalleOrden()!=null)
			pdo = ecpnc.getProduccionDetalleOrden();
		else {
			if (lbxItemOrden.getSelectedItem()!=null)
				pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
			else
				pdo = new ProduccionDetalleOrden();
		}
//		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
//		ecpfc = ecpfcDAO.getByProduccionTurnoOrden(envasadoProceso.getIdenvasadoproceso(), pdo.getIdproducciondetalleorden());
		if (pdo==null)
			pdo = new ProduccionDetalleOrden();
		
		if (ecpnc.getMaquinaCerradora()==null)
			ecpnc.setMaquinaCerradora(new MaquinaCerradora());
		
		
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		txtVideoJet.setValue(pdo.getVideo());
		
		
		
		for (Listitem li : (List<Listitem>)lbxMCerradora.getItems())
			if (ecpnc.getMaquinaCerradora().getIdmaquinacerradora()==null) {
				lbxMCerradora.setSelectedIndex(0);
				break;
			} else if ( ecpnc.getMaquinaCerradora().getIdmaquinacerradora() 
						.equals(((MaquinaCerradora) li.getValue()).getIdmaquinacerradora()) ) {
				lbxMCerradora.setSelectedItem(li);
				break;
			}
					
		if (ecpnc.getIdenvasadocontrolpesonetocabecera()==null) {
			txtTara.setValue(null);
			txtObservacion.setValue(null);
		} else {
			txtTara.setValue(String.valueOf(ecpnc.getTara()));
			txtObservacion.setValue(ecpnc.getObservacion());
		}
		if(pdo!=null) {
			EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
			EnvasadoFichaTecnica eft = eftDAO.getByOrden(pdo.getIdproducciondetalleorden());
			
			for(Listitem li : (List<Listitem>)lbxcvprot.getItems())
				if (eft.getEnvasadoCaldoVegetalProteina()==null) {
					lbxcvprot.setSelectedIndex(0);
					break;
				} else if (eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
							.equals(((EnvasadoCaldoVegetalProteina) li.getValue()).getIdenvasadocaldovegetalproteina())) {
					lbxcvprot.setSelectedItem(li);
					break;
				}
			txtPesoEnvase.setValue(String.valueOf(eft.getPesoNetoFormulado()));
			txtPLomos.setValue(String.valueOf(eft.getLomo()));
			txtTrozos.setValue(String.valueOf(eft.getTrozos()));
			txtRallado.setValue(String .valueOf(eft.getRallado()));
			txtAgua.setValue(String.valueOf(eft.getAgua()));
			txtAceite.setValue(String.valueOf(eft.getAceite()));
			txtCaldoVegetal.setValue(String.valueOf(eft.getCaldoVegetal()));
			txtConcentracion.setValue(String.valueOf(eft.getConcentracion()));
		} else {
		
			lbxcvprot.setSelectedIndex(0);
			txtPesoEnvase.setValue(null);
			txtPLomos.setValue(null);
			txtTrozos.setValue(null);
			txtRallado.setValue(null);
			txtAgua.setValue(null);
			txtAceite.setValue(null);
			txtCaldoVegetal.setValue(null);
			txtConcentracion.setValue(null);
			
		}
		
		lbxCorte.setSelectedIndex(0);
		if (!rsCorte.getChildren().isEmpty())
			rsCorte.getChildren().clear();
	}
	
	/**
	 * carga los dias que contiene el mes seleccionado.
	 */
	public void onSelect$lbxMes(){
		cargaDiasMesSeleccionado();
	}
	
	private static int obtieneFechaCambio(Timestamp fechaCambio, int typeCalendar){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(fechaCambio.getTime()));
		return c.get(typeCalendar);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaDia(int dia) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxDias.getItems()) {
			if ( (Integer)listitem.getValue() == dia )
				break;
			index++;
		}
		lbxDias.setSelectedIndex(index);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaMes(int mes) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxMes.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == mes )
					break;
			index++;
		}
		lbxMes.setSelectedIndex(index);
		
		cargaDiasMesSeleccionado();
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaHora(int hora) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxHoras.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == hora )
					break;
			index++;
		}
		lbxHoras.setSelectedIndex(index);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaMinuto(int minuto) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxMinutos.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == minuto )
					break;
			index++;
		}
		lbxMinutos.setSelectedIndex(index);
	}
	
	private void cargaDiasMesSeleccionado(){
		int anio = Calendar.getInstance().get(Calendar.YEAR) - 1900;
		String mes="";
		lbxDias.getItems().clear();
		if (lbxMes.getSelectedItem().getValue()==null)
			return;
		mes = lbxMes.getSelectedItem().getValue().toString();
		Calendar c = new GregorianCalendar(anio, Integer.parseInt(mes)-1, 1);
		int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		Listitem li = new Listitem();
		li.setValue(new Integer("0"));
		li.setParent(lbxDias);
		
		for (int i=1 ; dias>=i ; i++) {
			li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxDias);
		}
		
		lbxDias.setSelectedIndex(0);
	}
	
	public void onClick$btnGrabarBot() {
		onClick$btnGrabar();
	}
	
	public void onClick$btnGrabar() {
		Compuesto compuesto = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		
		EnvasadoControlPesoNetoCabecera ecpnc = compuesto.envasadoControlPesoNetoCabecera;
		
		if(!validaCampos())
			return;
//		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();

		ecpnc.setEnvasadoProceso((EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue());
		ecpnc.setTurno(((Turno)lbxTurnoLabor.getSelectedItem().getValue()));
		ecpnc.setProduccionDetalleOrden(pdo);
		ecpnc.setMaquinaCerradora((MaquinaCerradora)lbxMCerradora.getSelectedItem().getValue());
		ecpnc.setTara(parseDouble(txtTara.getValue()));
//		ecpnc.setPesoenvase(parseDouble(txtPesoEnvase.getValue()));
//		ecpnc.setProcentajelomos(parseDouble(txtPLomos.getValue()));
//		ecpnc.setProcentajetrozos(parseDouble(txtTrozos.getValue()));
//		ecpnc.setProcentajerallado(parseDouble(txtRallado.getValue()));
//		ecpnc.setAgua(parseDouble(txtAgua.getValue()));
//		ecpnc.setAceite(parseDouble(txtAceite.getValue()));
//		ecpnc.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
//		ecpnc.setProteina(parseDouble(txtprot.getValue()));
//		ecpnc.setCaldovegetal(parseDouble(txtcv.getValue()));

		ecpnc.setFechareg(new Timestamp(System.currentTimeMillis()));
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		ecpnc.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		
		/***detalle***/
		List<EnvasadoControlPesoNetoDetalle> listaEcpnd = obtieneDetallesPesoNeto(ecpnc, idUsuario);
		
		if (listaEcpnd==null) {
			Sistema.mensaje("Error al guardar el detalle de la informacion.");
			return;
		} else if (listaEcpnd.isEmpty()) {
			Sistema.mensaje("Debe Agregar valores para Peso Fill.");
			return;
		}
			
		ecpnc.setEnvasadoControlPesoNetoDetalles(listaEcpnd);
		/************/
		
		ecpnc.setObservacion(txtObservacion.getValue());
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		
		if(ecpncDAO.updateEnvasadoControlPesoNetoCabecera(ecpnc)==null) {
			Sistema.mensaje("Error al guardar la informacion.");
			return;
		}
		
		Sistema.mensaje("Cambios guardados exitosamente.");
		
		int iItemOrdenCliente = lbxItemOrdenCliente.getSelectedIndex();
		int iCorte = lbxCorte.getSelectedIndex();
 		onSelect$lbxTurnoProduccion();
		lbxItemOrdenCliente.setSelectedIndex(iItemOrdenCliente);
		onSelect$lbxItemOrdenCliente();
		lbxCorte.setSelectedIndex(iCorte);
		onSelect$lbxCorte();
		

	}
	
	private List<EnvasadoControlPesoNetoDetalle> obtieneDetallesPesoNeto(EnvasadoControlPesoNetoCabecera ecpnc, String idUsuario) {
		try {
			List<EnvasadoControlPesoNetoDetalle> listaCpnd = new ArrayList<EnvasadoControlPesoNetoDetalle>();
			EnvasadoControlPesoNetoDetalle cpnd; 
			
			@SuppressWarnings("unchecked")
			List<Row> listaLbxPesoNeto = (List<Row>)rsCorte.getChildren();
			
			for (Row listitem : listaLbxPesoNeto) {
				
				Intbox txtPesoNeto = (Intbox)listitem.getChildren().get(1);
				
				if (txtPesoNeto.getValue()==null) {
					continue;
				}
				
				if (listitem.getValue()==null) {
					cpnd = new EnvasadoControlPesoNetoDetalle();
					cpnd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
				} else {
					cpnd = (EnvasadoControlPesoNetoDetalle)listitem.getValue();
					if(!new Double(txtPesoNeto.getValue()).equals(cpnd.getPesoneto())) {
						cpnd.setPesoneto(txtPesoNeto.getValue());
						cpnd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
					}
				}
				cpnd.setFechareg(new Timestamp(System.currentTimeMillis()));
				cpnd.setEnvasadoControlPesoNetoCabecera(ecpnc);
				cpnd.setEnvasadoControlNetoCorteDetalle((EnvasadoControlNetoCorteDetalle)lbxCorte.getSelectedItem().getValue());
				cpnd.setPesoneto(txtPesoNeto.getValue());
				
				
				
				listaCpnd.add(cpnd);
			}
		
			return listaCpnd;
		} catch( Exception e) {
			return null;
		}
	}
	
	public void onClick$btnEliminar(){
		if (!cbxEliminarOrden.isChecked()) {
			Sistema.mensaje("Debe confirmar para eliminar los elementos seleccionados.");
			return;
		}
		
		Compuesto c = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		
		if(c.envasadoControlPesoNetoCabecera.getIdenvasadocontrolpesonetocabecera()==null) {
			Sistema.mensaje("Debe seleccionar un valor "+lbItemOrdenCliente.getValue()+" para eliminar.");
			return;
		}
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		
		EnvasadoControlPesoNetoDetalleDAO ecpndDAO = new  EnvasadoControlPesoNetoDetalleDAOJpaImpl();
		
		for (EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle : c.envasadoControlPesoNetoCabecera.getEnvasadoControlPesoNetoDetalles()) {
			if (!ecpndDAO.eliminaEnvasadoControlPesoNetoDetalle(envasadoControlPesoNetoDetalle)){
				Sistema.mensaje("Registro en uso");
				return;
			}
		}
		
		List<EnvasadoControlPesoNetoDetalle> obtieneByIdEnvasadoControlPesoNetoDetalle = ecpndDAO.obtieneByIdEnvasadoControlPesoNetoDetalle
				(c.envasadoControlPesoNetoCabecera.getIdenvasadocontrolpesonetocabecera());
		if (obtieneByIdEnvasadoControlPesoNetoDetalle.size()==0 || obtieneByIdEnvasadoControlPesoNetoDetalle.isEmpty()) {
			c.envasadoControlPesoNetoCabecera.setEnvasadoControlPesoNetoDetalles(obtieneByIdEnvasadoControlPesoNetoDetalle);
			if (ecpncDAO.eliminaEnvasadoControlPesoNetoCabecera(c.envasadoControlPesoNetoCabecera)) {
				Sistema.mensaje("Formato Eliminado");
	//			limpiarFormulario();
			} else {
				Sistema.mensaje("Registro en uso");
				return;
			}
		}
		limpiarFormulario();
	}
	
	private void limpiarFormulario() {
		
		cargaTurno();
		onSelect$lbxTurnoProduccion();
		cargaLineaCerradora();
		lbxItemOrden.setSelectedIndex(0);
		onSelect$lbxItemOrden();
		txtTara.setValue(null);
		txtPesoEnvase.setValue(null);
		txtPLomos.setValue(null);
		txtTrozos.setValue(null);
		txtRallado.setValue(null);
		txtAgua.setValue(null);
		txtAceite.setValue(null);
		cargaCVPROT();
		txtCaldoVegetal.setValue(null);
		txtConcentracion.setValue(null);
		lbxCorte.getItems().clear();
		txtObservacion.setValue(null);
		lbxMes.setSelectedIndex(0);
		lbxDias.getItems().clear();
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);
		cbxEliminar.setChecked(false);
		
	}
	
	private Timestamp obtieneFechaRegistro() {
		String dia ="";
		String mes ="";
		String hora ="";
		String min ="";
		String mensaje = new String();
		
		if (lbxMinutos.getSelectedItem().getValue()!=null)
			min = lbxMinutos.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Minuto.";
		
		if(lbxHoras.getSelectedItem().getValue()!=null)
			hora = lbxHoras.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Hora.";
		
		if (lbxDias.getSelectedItem()!=null && lbxDias.getSelectedItem().getValue()!=null) {
			if (!"0".equals(lbxDias.getSelectedItem().getValue().toString()))
				dia = lbxDias.getSelectedItem().getValue().toString();
			else
				mensaje="Por favor seleccione un valor para Dia.";
		} else
			mensaje="Por favor seleccione un valor para Dia.";
		
		if (lbxMes.getSelectedItem().getValue()!=null)
			mes = lbxMes.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Mes.";
		
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		
		int second = Calendar.getInstance().get(Calendar.SECOND);

		String fechaCambio = anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+second;
		if (!mensaje.isEmpty()) {
			Sistema.mensaje(mensaje);
			return null;
		} else 
			return Timestamp.valueOf(fechaCambio);
	}
	

	private boolean validaCampos() {
		List<Object> listaEtiquetas = new ArrayList<Object>();
		List<Object> camposNumericos = new ArrayList<Object>();
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTurnoProduccion);
		listaEtiquetas.add(lbxTurnoProduccion);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbItemOrdenCliente);
		listaEtiquetas.add(lbxItemOrdenCliente);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTurnoLabor);
		listaEtiquetas.add(lbxTurnoLabor);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbItemOrden);
		listaEtiquetas.add(lbxItemOrden);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbMCerradora);
		listaEtiquetas.add(lbxMCerradora);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTara);
		listaEtiquetas.add(txtTara);
		camposNumericos.add(listaEtiquetas);
		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbPesoEnvase);
//		listaEtiquetas.add(txtPesoEnvase);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbPLomos);
//		listaEtiquetas.add(txtPLomos);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbTrozos);
//		listaEtiquetas.add(txtTrozos);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbRallado);
//		listaEtiquetas.add(txtRallado);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbAgua);
//		listaEtiquetas.add(txtAgua);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbAceite);
//		listaEtiquetas.add(txtAceite);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbcvprot);
//		listaEtiquetas.add(lbxcvprot);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbCaldoVegetal);
//		listaEtiquetas.add(txtCaldoVegetal);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbPLomos);
//		listaEtiquetas.add(txtPLomos);
//		camposNumericos.add(listaEtiquetas);
//		
//		listaEtiquetas = new ArrayList<Object>(); 
//		listaEtiquetas.add(lbConcentracion);
//		listaEtiquetas.add(txtConcentracion);
//		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbCorte);
		listaEtiquetas.add(lbxCorte);
		camposNumericos.add(listaEtiquetas);
		
		Label etiqueta;
		for (Object object : camposNumericos) {
			@SuppressWarnings("unchecked")
			List<Object> valores = (List<Object>) object;
			etiqueta = (Label) valores.get(0);
			if (valores.get(1) instanceof Textbox) {
				if (!validaCamposNumericos(etiqueta, (Textbox) valores.get(1)))
					return false;
			} else if (valores.get(1) instanceof Listbox) {
				if(!validaCamposLista(etiqueta, (Listbox) valores.get(1)))
					return false;
			}
		}
		return true;
	}

	private static boolean validaCamposNumericos(Label etiqueta, Textbox valor) {
		try {
			if (valor.getValue() == null ? true : valor.getValue().isEmpty() ? true : false) {
				Sistema.mensaje("Se debe agrega un valor para el campo "+ etiqueta.getValue());
				valor.setFocus(true);
				return false;
			} else if (parseDouble(valor.getValue()) < 0) {
				Sistema.mensaje("El campo " + etiqueta.getValue() + " no permite numeros negativos.");
				valor.setValue(null);
				valor.setFocus(true);
				return false;
			}
		} catch (Exception e) {
			Sistema.mensaje("El campo " + etiqueta.getValue() + " solo acepta numeros.");
			valor.setValue(null);
			valor.setFocus(true);
			return false;
		}
		return true;
	}
	
	private static boolean validaCamposLista(Label etiqueta, Listbox valor) {
		if (valor.getSelectedIndex() == 0) {
			Sistema.mensaje("Debe seleccionar un valor para el campo "+etiqueta.getValue()+".");
			return false;
		}
		return true;
	}
	
	
	/**
	 * valida el valor del punto o la coma para el tipo de dato Double
	 * @param valor
	 * @return
	 */
	private static Double parseDouble(String valor) {
		try {
			//retorna el valor recibido
			return Double.valueOf(valor);
		} catch(Exception e){
			try {
				//retorna el valor reemplazando el punto por la coma.
				if (valor !=null)
					if (!valor.isEmpty())
						return new Double(valor.replaceAll("\\.", ","));
				return Double.valueOf(valor);
			}catch(Exception e1) {
				try {
					if (valor !=null)
						if (!valor.isEmpty())
							return new Double(valor.replaceAll(",", "\\."));
					return Double.valueOf(valor);
				}catch(Exception e2) {
//					e.printStackTrace();
					return new Double("");
				}
			}
		}
	}

	class Compuesto {
		
		public EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera;
		
		
		public Compuesto(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
			this.envasadoControlPesoNetoCabecera = envasadoControlPesoNetoCabecera;
		}
		
	}
}

