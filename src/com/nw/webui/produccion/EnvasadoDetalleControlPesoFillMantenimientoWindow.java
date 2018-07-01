package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoControlPesoFillDetalle;
import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.EnvasadoLineaCerradora;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Luthy;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillDetalleDAO;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.LuthyDAO;
import com.nw.model.dao.MaquinaCerradoraDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlFillCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillDetalleDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoFichaTecnicaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoLineaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
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
public class EnvasadoDetalleControlPesoFillMantenimientoWindow extends GenericForwardComposer {

//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoFillMantenimientoWindow.class);
	/**
	 * 
	 */
	private static final int valorMaximoPesoFill = 10016;
	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	Label   lbFechaProduccion;
	Datebox dteFechaProduccion;
	
	Label   lbTurnoProduccion,  lbTurnoLabor,  lbItemOrdenCliente,  lbItemOrden,  lbLuthy,  lbLineaCerradora,  lbcvprot,  lbCorte,  lbLista;
	Listbox lbxTurnoProduccion, lbxTurnoLabor, lbxItemOrdenCliente, lbxItemOrden, lbxLuthy, lbxLineaCerradora, lbxcvprot, lbxCorte; 
	
	Label   lbOrden,  lbProducto,  lbCliente,  lbPesoEnvase,  lbPLomos,  lbTrozos,  lbRallado,  lbAgua,  lbAceite,  lbCaldoVegetal,  lbConcentracion,  lbTaraEnvase,  lbObservacion;
	Textbox 								   txtPesoEnvase, txtPLomos, txtTrozos, txtRallado, txtAgua, txtAceite, txtCaldoVegetal, txtConcentracion, txtTaraEnvase, txtObservacion;
	Label   txtOrden, txtProducto, txtCliente;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	
	Checkbox cbxEliminar, cbxEliminarOrden;
	
	Rows rsCorte;
	
	private Produccion produccion;
	EnvasadoControlPesoFillCabecera ecpfc;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		cargaTurno();
		cargaLuthy();
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
		EnvasadoProceso ep = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		List<EnvasadoControlPesoFillCabecera> listaEcpfc = ecpfcDAO.getByProduccion(ep.getIdenvasadoproceso());
		ProduccionDetalleOrden pdo;
		lbxItemOrdenCliente.getItems().clear();
		
		Listitem li = new Listitem();
		li.setValue(new Compuesto(new EnvasadoControlPesoFillCabecera()));
		li.setParent(lbxItemOrdenCliente);
		
		/**
		 * fragmento de codigo para ordenar la lista por orden
		 */
		Collections.sort(listaEcpfc, new Comparator<EnvasadoControlPesoFillCabecera>() 		
				{
					@Override
					public int compare(EnvasadoControlPesoFillCabecera o1, EnvasadoControlPesoFillCabecera o2) {
						return new String(o1.getProduccionDetalleOrden().getOrden()).compareTo(o2.getProduccionDetalleOrden().getOrden());
					}
				});

		
		/**
		 * fragmento de codigo para ordenar la lista por item
		 */
		Collections.sort(listaEcpfc, new Comparator<EnvasadoControlPesoFillCabecera>() 		
		{
			@Override
			public int compare(EnvasadoControlPesoFillCabecera o1, EnvasadoControlPesoFillCabecera o2) {
				return new Integer(o1.getProduccionDetalleOrden().getItem()).compareTo(o2.getProduccionDetalleOrden().getItem());
			}
		});
		
				
		for (EnvasadoControlPesoFillCabecera ecpfc : listaEcpfc) {
			pdo = ecpfc.getProduccionDetalleOrden();
			
			/**
			 * fragmento de codigo para ordenar la lista por Peso
			 */
			Collections.sort(ecpfc.getEnvasadoControlPesoFillDetalles(), new Comparator<EnvasadoControlPesoFillDetalle>() 		
					{
						@Override
						public int compare(EnvasadoControlPesoFillDetalle o1, EnvasadoControlPesoFillDetalle o2) {
							return new Double(o1.getPesofill()).compareTo(o2.getPesofill());
						}
					});
			
			/**
			 * fragmento de codigo para ordenar la lista por Fecha
			 */
			Collections.sort(ecpfc.getEnvasadoControlPesoFillDetalles(), new Comparator<EnvasadoControlPesoFillDetalle>() 		
					{
						@Override
						public int compare(EnvasadoControlPesoFillDetalle o1, EnvasadoControlPesoFillDetalle o2) {
							return new Long(o1.getFechareg().getTime()).compareTo(o2.getFechareg().getTime());
						}
					});
			
			
//			for(EnvasadoControlPesoFillDetalle ecpfd : ecpfc.getEnvasadoControlPesoFillDetalles()) {
				li = new Listitem();
				li.setValue(new Compuesto(ecpfc));
				
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
		ecpfc = ((Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue()).envasadoControlPesoFillCabecera;
		if (ecpfc.getTurno()==null)
			lbxTurnoLabor.setSelectedIndex(0);
		else
			lbxTurnoLabor.setSelectedIndex(ecpfc.getTurno().getIdturno());
		
		cargaItemOrden();
		cargaCorte();
		cargaInformacionFormulario() ;
		
	}
	
	public void onSelect$lbxItemOrden() {
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		
	}
	
	private void cargaItemOrden() {
		ProduccionDetalleOrden pdoSeleccionado = (((Compuesto) lbxItemOrdenCliente
				.getSelectedItem().getValue()).envasadoControlPesoFillCabecera).getProduccionDetalleOrden();
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
		
		for (Row r :(List<Row>)rsCorte.getChildren()) {
			Checkbox cbx = (Checkbox)r.getChildren().get(0);
			
			if (cbx.isChecked())
				rowsElimina.add(r);
		}

		
		EnvasadoControlPesoFillDetalleDAO envasadoControlPesoFillDetalle = new EnvasadoControlPesoFillDetalleDAOJpaImpl();
		for (Row r : rowsElimina) {
			rsCorte.removeChild(r);
			if (r.getValue()!=null)
				envasadoControlPesoFillDetalle.eliminaEnvasadoControlPesoFillDetalle((EnvasadoControlPesoFillDetalle)r.getValue());
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
	
	private Listbox cargaCorte() {
		
		lbxCorte.getItems().clear();
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new EnvasadoControlFillCorteCabeceraDAOJpaImpl();
		EnvasadoProceso envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		List<EnvasadoControlFillCorteDetalle> listaEcfcd = ecfccDAO
				.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso())
				.getEnvasadoControlFillCorteDetalles();
		
		if (listaEcfcd != null) {
			if (listaEcfcd.isEmpty()) {
//				Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
				return new Listbox();
			}
		} else if (listaEcfcd == null) {
//			Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
			return new Listbox();
		}
		
//		Listbox listbox = new Listbox(); 
//		listbox.setMold(SELECT);
		Listitem li = new Listitem();
		li.setValue(new EnvasadoControlFillCorteDetalle());
		li.setParent(lbxCorte);
		
		Collections.sort(listaEcfcd, new Comparator<EnvasadoControlFillCorteDetalle>() 		
		{
			@Override
			public int compare(EnvasadoControlFillCorteDetalle o1, EnvasadoControlFillCorteDetalle o2) {
				return new Integer(o1.getCorte()).compareTo(o2.getCorte());
			}
		});
		
		List<EnvasadoControlPesoFillDetalle> listaEcpfd;
		String hora, minuto;
		for (EnvasadoControlFillCorteDetalle ecfcd : listaEcfcd) {
			li = new Listitem();
			li.setValue(ecfcd);
			
			hora = ecfcd.getHora()<=9?"0"+ecfcd.getHora():ecfcd.getHora().toString();
			minuto = ecfcd.getMinuto()<=9?"0"+ecfcd.getMinuto():ecfcd.getMinuto().toString();
			
			listaEcpfd = new ArrayList<>();
			
			if(ecpfc!=null)
				if (ecpfc.getEnvasadoControlPesoFillDetalles()!=null)
					for (EnvasadoControlPesoFillDetalle ecpfd : ecpfc.getEnvasadoControlPesoFillDetalles())
						if (ecfcd.getIdenvasadocontrolfillcortedetalle().equals(ecpfd.getEnvasadoControlFillCorteDetalle().getIdenvasadocontrolfillcortedetalle())) {
							listaEcpfd.add(ecpfd);
						}
			
			new Listcell(ecfcd.getCorte()+" ("+listaEcpfd.size()+")"+" -> "+hora+":"+minuto)
				.setParent(li);
			li.setParent(lbxCorte);
		}
		
		lbxCorte.setSelectedIndex(0);
		return lbxCorte;
	}
	
	private void cargaListaCorte(int numeroCortes) {
		double numero = new ParametroDAOJpaImpl().findById(valorMaximoPesoFill).getValor();
		for (int i=0; i<numero-numeroCortes ; i++)
			onClick$btnAgregarItem();
	}
	
	public void onSelect$lbxCorte() {
		
		rsCorte.getChildren().clear();
		
		EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera = ((Compuesto) lbxItemOrdenCliente
				.getSelectedItem().getValue()).envasadoControlPesoFillCabecera;
		
		List<EnvasadoControlPesoFillDetalle> listaEcpfd = new ArrayList<EnvasadoControlPesoFillDetalle>();
		EnvasadoControlPesoFillDetalleDAO ecpfdDAO = new EnvasadoControlPesoFillDetalleDAOJpaImpl();
		EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle = (EnvasadoControlFillCorteDetalle)lbxCorte.getSelectedItem().getValue();
		listaEcpfd = ecpfdDAO.obtieneByEnvasadoControlPesoFillDetalleByCorte(
				envasadoControlFillCorteDetalle.getIdenvasadocontrolfillcortedetalle(), envasadoControlPesoFillCabecera.getIdenvasadocontrolpesofillcabecera());
		Row row;
		
		for (EnvasadoControlPesoFillDetalle ecpfd : listaEcpfd) {
			row = new Row();
				Checkbox chx = new Checkbox();
				chx.setParent(row);
				
				Intbox ibx = new Intbox();
				ibx.setValue( (int) ecpfd.getPesofill() );
				ibx.setTabindex(cont);
				ibx.setReadonly(false);
				ibx.setParent(row);
			row.setValue(ecpfd);
			row.setParent(rsCorte);

			cont=cont+1;
		}
		
		if (listaEcpfd.isEmpty()) {
			cargaListaCorte(0);
		}else {
			cargaListaCorte(listaEcpfd.size());
		}
		
		
	}
	
	private void cargaLuthy() {
		LuthyDAO elcDAO = new LuthyDAOJpaImpl();
		List<Luthy> listLuthy = elcDAO.getAll();
		
		if (listLuthy.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para Luthy.");
			return;
		}
		
		lbxLuthy.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Luthy());
		li.setParent(lbxLuthy);
		
		for (Luthy luthy : listLuthy) {
			li = new Listitem();
			li.setValue(luthy);
			new Listcell(luthy.getNumeroluthy().toString()).setParent(li);
			li.setParent(lbxLuthy);
		}
		
		lbxLuthy.setSelectedIndex(0);
	}
	
	private void cargaLineaCerradora() {
		MaquinaCerradoraDAO elcDAO = new EnvasadoLineaCerradoraDAOJpaImpl();
		List<EnvasadoLineaCerradora> listELC = elcDAO.getEnvasadoLineaCerradoraAll();
		
		if (listELC.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para Linea Cerradora.");
			return;
		}
		
		lbxLineaCerradora.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoLineaCerradora());
		li.setParent(lbxLineaCerradora);
		
		for (EnvasadoLineaCerradora elc : listELC) {
			li = new Listitem();
			li.setValue(elc);
			new Listcell(elc.getNumeroenvasadolineacerradora().toString()).setParent(li);
			li.setParent(lbxLineaCerradora);
		}
		
		lbxLineaCerradora.setSelectedIndex(0);
		
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
		EnvasadoControlPesoFillCabecera ecpfc = compuesto.envasadoControlPesoFillCabecera;
		ProduccionDetalleOrden pdo = ecpfc.getProduccionDetalleOrden();
		
		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
		EnvasadoFichaTecnica eft = ecpfc.getProduccionDetalleOrden()==null?
					new EnvasadoFichaTecnica():
					eftDAO.getByOrden(ecpfc.getProduccionDetalleOrden().getIdproducciondetalleorden());
		
		if (pdo==null)
			pdo = new ProduccionDetalleOrden();
		
		if (ecpfc.getEnvasadoLineaCerradora()==null)
			ecpfc.setEnvasadoLineaCerradora(new EnvasadoLineaCerradora());
		
		if (ecpfc.getEnvasadoCaldoVegetalProteina()==null)
			ecpfc.setEnvasadoCaldoVegetalProteina(new EnvasadoCaldoVegetalProteina());
		
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		
		for (Listitem li : (List<Listitem>)lbxLuthy.getItems())
			if (ecpfc.getLuthy()==null) {
				lbxLuthy.setSelectedIndex(0);
				break;
			} else if ( ecpfc.getLuthy().getIdluthy() 
						.equals(((Luthy) li.getValue()).getIdluthy()) ) {
				lbxLuthy.setSelectedItem(li);
				break;
			}
		
		for (Listitem li : (List<Listitem>)lbxLineaCerradora.getItems())
			if (ecpfc.getEnvasadoLineaCerradora().getIdenvasadolineacerradora()==null) {
				lbxLineaCerradora.setSelectedIndex(0);
				break;
			} else if ( ecpfc.getEnvasadoLineaCerradora().getIdenvasadolineacerradora() 
						.equals(((EnvasadoLineaCerradora) li.getValue()).getIdenvasadolineacerradora()) ) {
				lbxLineaCerradora.setSelectedItem(li);
				break;
			}
					
		for(Listitem li : (List<Listitem>)lbxcvprot.getItems())
			if (eft.getEnvasadoCaldoVegetalProteina()!=null)
				if (eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()==null) {
					lbxcvprot.setSelectedIndex(0);
					break;
				} else if (eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
							.equals(((EnvasadoCaldoVegetalProteina) li.getValue()).getIdenvasadocaldovegetalproteina())) {
					lbxcvprot.setSelectedItem(li);
					break;
				}
		if (ecpfc.getIdenvasadocontrolpesofillcabecera()==null) {
			txtPesoEnvase.setValue(null);
			txtPLomos.setValue(null);
			txtTrozos.setValue(null);
			txtRallado.setValue(null);
			txtAgua.setValue(null);
			txtAceite.setValue(null);
			txtCaldoVegetal.setValue(null);
			txtConcentracion.setValue(null);
			txtTaraEnvase.setValue(null);
			txtObservacion.setValue(null);
			
		} else {
			
			txtPesoEnvase.setValue(String.valueOf(eft.getPesoNetoFormulado()));
			txtPLomos.setValue(String.valueOf(eft.getLomo()));
			txtTrozos.setValue(String.valueOf(eft.getTrozos()));
			txtRallado.setValue(String .valueOf(eft.getRallado()));
			txtAgua.setValue(String.valueOf(eft.getAgua()));
			txtAceite.setValue(String.valueOf(eft.getAceite()));
			txtCaldoVegetal.setValue(String.valueOf(eft.getCaldoVegetal()));
			txtConcentracion.setValue(String.valueOf(eft.getConcentracion()));
			txtTaraEnvase.setValue(String.valueOf(ecpfc.getTara()));
			txtObservacion.setValue(ecpfc.getObservacion());
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
		
		EnvasadoControlPesoFillCabecera ecpfc = compuesto.envasadoControlPesoFillCabecera;
		
		if(!validaCampos())
			return;
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();

		ecpfc.setEnvasadoProceso((EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue());
		ecpfc.setTurno(((Turno)lbxTurnoLabor.getSelectedItem().getValue()));
		ecpfc.setProduccionDetalleOrden(pdo);
		ecpfc.setLuthy((Luthy)lbxLuthy.getSelectedItem().getValue());
		ecpfc.setEnvasadoLineaCerradora((EnvasadoLineaCerradora)lbxLineaCerradora.getSelectedItem().getValue());
//		ecpfc.setPesoenvase(parseDouble(txtPesoEnvase.getValue()));
//		ecpfc.setProcentajelomos(parseDouble(txtPLomos.getValue()));
//		ecpfc.setProcentajetrozos(parseDouble(txtTrozos.getValue()));
//		ecpfc.setProcentajerallado(parseDouble(txtRallado.getValue()));
//		ecpfc.setAgua(parseDouble(txtAgua.getValue()));
//		ecpfc.setAceite(parseDouble(txtAceite.getValue()));
//		ecpfc.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
//		ecpfc.setProteina(parseDouble(txtCaldoVegetal.getValue()));
//		ecpfc.setCaldovegetal(parseDouble(txtConcentracion.getValue()));
		
		ecpfc.setFechareg(new Timestamp(System.currentTimeMillis()));
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		ecpfc.setUsuario(usuario);
		
		/***detalle***/
		List<EnvasadoControlPesoFillDetalle> listaEcpfd = obtieneDetallesPesoFill(ecpfc, idUsuario);
		
		if (listaEcpfd==null) {
			Sistema.mensaje("Error al guardar el detalle de la informacion.");
			return;
		} else if (listaEcpfd.isEmpty()) {
			Sistema.mensaje("Debe Agregar valores para Peso Fill.");
			return;
		}
			
		ecpfc.setEnvasadoControlPesoFillDetalles(listaEcpfd);
		/************/
		ecpfc.setTara(parseDouble(txtTaraEnvase.getValue()));
		ecpfc.setObservacion(txtObservacion.getValue());
		ecpfc.setEnvasadoCaldoVegetalProteina(null);
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		
		this.ecpfc = ecpfcDAO.updateEnvasadoControlPesoFillCabecera(ecpfc);
		
		if(this.ecpfc==null) {
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
	
	private List<EnvasadoControlPesoFillDetalle> obtieneDetallesPesoFill(EnvasadoControlPesoFillCabecera ecpfc, String idUsuario) {
		try {
			List<EnvasadoControlPesoFillDetalle> listaCpfd = new ArrayList<EnvasadoControlPesoFillDetalle>();
			EnvasadoControlPesoFillDetalle cpfd; 
			
			@SuppressWarnings("unchecked")
			List<Row> listaLbxPesoFill = (List<Row>)rsCorte.getChildren();
			
			for (Row listitem : listaLbxPesoFill) {
				
				Intbox txtPesoFill = (Intbox)listitem.getChildren().get(1);
				
				if (txtPesoFill.getValue()==null) {
					continue;
				}
				
				if (listitem.getValue()==null) {
					cpfd = new EnvasadoControlPesoFillDetalle();
					cpfd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
				} else {
					cpfd = (EnvasadoControlPesoFillDetalle)listitem.getValue();
					if(!new Double(txtPesoFill.getValue()).equals(cpfd.getPesofill())) {
						cpfd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
					}
				}
				cpfd.setFechareg(new Timestamp(System.currentTimeMillis()));
				cpfd.setEnvasadoControlPesoFillCabecera(ecpfc);
				cpfd.setEnvasadoControlFillCorteDetalle((EnvasadoControlFillCorteDetalle)lbxCorte.getSelectedItem().getValue());
				cpfd.setPesofill(txtPesoFill.getValue());
				
				
				
				listaCpfd.add(cpfd);
			}
		
			return listaCpfd;
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
		
		if(c.envasadoControlPesoFillCabecera.getIdenvasadocontrolpesofillcabecera()==null) {
			Sistema.mensaje("Debe seleccionar un valor "+lbItemOrdenCliente.getValue()+" para eliminar.");
			return;
		}
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		
		EnvasadoControlPesoFillDetalleDAO ecpfdDAO = new  EnvasadoControlPesoFillDetalleDAOJpaImpl();
		
		for (EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle : c.envasadoControlPesoFillCabecera.getEnvasadoControlPesoFillDetalles()) {
			if (!ecpfdDAO.eliminaEnvasadoControlPesoFillDetalle(envasadoControlPesoFillDetalle)){
				Sistema.mensaje("Registro en uso");
				return;
			}
		}
		
		List<EnvasadoControlPesoFillDetalle> obtieneByIdEnvasadoControlPesoFillDetalle = ecpfdDAO.obtieneByIdEnvasadoControlPesoFillDetalle
				(c.envasadoControlPesoFillCabecera.getIdenvasadocontrolpesofillcabecera());
		if (obtieneByIdEnvasadoControlPesoFillDetalle.size()==0 || obtieneByIdEnvasadoControlPesoFillDetalle.isEmpty()) {
			c.envasadoControlPesoFillCabecera.setEnvasadoControlPesoFillDetalles(obtieneByIdEnvasadoControlPesoFillDetalle);
			if (ecpfcDAO.eliminaEnvasadoControlPesoFillCabecera(c.envasadoControlPesoFillCabecera)) {
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
		cargaLuthy();
		cargaLineaCerradora();
		lbxItemOrden.setSelectedIndex(0);
		onSelect$lbxItemOrden();
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
		rsCorte.getChildren().clear();
		txtTaraEnvase.setValue(null);
		txtObservacion.setValue(null);
		lbxMes.setSelectedIndex(0);
		lbxDias.getItems().clear();
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);
		cbxEliminar.setChecked(false);
		
	}
	
//	private Timestamp obtieneFechaRegistro() {
//		String dia ="";
//		String mes ="";
//		String hora ="";
//		String min ="";
//		String mensaje = new String();
//		
//		if (lbxMinutos.getSelectedItem().getValue()!=null)
//			min = lbxMinutos.getSelectedItem().getValue().toString();
//		else
//			mensaje="Por favor seleccione un valor para Minuto.";
//		
//		if(lbxHoras.getSelectedItem().getValue()!=null)
//			hora = lbxHoras.getSelectedItem().getValue().toString();
//		else
//			mensaje="Por favor seleccione un valor para Hora.";
//		
//		if (lbxDias.getSelectedItem()!=null && lbxDias.getSelectedItem().getValue()!=null) {
//			if (!"0".equals(lbxDias.getSelectedItem().getValue().toString()))
//				dia = lbxDias.getSelectedItem().getValue().toString();
//			else
//				mensaje="Por favor seleccione un valor para Dia.";
//		} else
//			mensaje="Por favor seleccione un valor para Dia.";
//		
//		if (lbxMes.getSelectedItem().getValue()!=null)
//			mes = lbxMes.getSelectedItem().getValue().toString();
//		else
//			mensaje="Por favor seleccione un valor para Mes.";
//		
//		int anio = Calendar.getInstance().get(Calendar.YEAR);
//		
//		int second = Calendar.getInstance().get(Calendar.SECOND);
//
//		String fechaCambio = anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+second;
//		if (!mensaje.isEmpty()) {
//			Sistema.mensaje(mensaje);
//			return null;
//		} else 
//			return Timestamp.valueOf(fechaCambio);
//	}
	

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
		listaEtiquetas.add(lbLuthy);
		listaEtiquetas.add(lbxLuthy);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbLineaCerradora);
		listaEtiquetas.add(lbxLineaCerradora);
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
		
		public EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera;
		
		public Compuesto(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
			this.envasadoControlPesoFillCabecera = envasadoControlPesoFillCabecera;
		}
		
	}
}

