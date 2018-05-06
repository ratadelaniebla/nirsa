package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoControlPesoFillDetalle;
import com.nw.model.EnvasadoLineaCerradora;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillDetalleDAO;
import com.nw.model.dao.MaquinaCerradoraDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlFillCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillDetalleDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoLineaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
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
private static final String NUEVO = "- NUEVO -";
//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoFillMantenimientoWindow.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Label   lbFechaProduccion;
	Datebox dteFechaProduccion;
	
	Label   lbTurnoProduccion,  lbTurnoLabor,  lbItemOrdenCliente,  lbItemOrden,  lbLineaCerradora,  lbcvprot,  lbCorte;
	Listbox lbxTurnoProduccion, lbxTurnoLabor, lbxItemOrdenCliente, lbxItemOrden, lbxLineaCerradora, lbxcvprot, lbxCorte; 
	
	Label   lbOrden,  lbProducto,  lbCliente,  lbPesoEnvase,  lbPLomos,  lbTrozos,  lbRallado,  lbAgua,  lbAceite,  lbprot,  lbcv,  lbPesofill,  lbObservacion;
	Textbox txtOrden, txtProducto, txtCliente, txtPesoEnvase, txtPLomos, txtTrozos, txtRallado, txtAgua, txtAceite, txtprot, txtcv, txtPesofill, txtObservacion;
	
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	
	Checkbox ChkEliminar;
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
		EnvasadoProceso ep = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		List<EnvasadoControlPesoFillCabecera> listaEcpfc = ecpfcDAO.getByProduccion(ep.getIdenvasadoproceso());
		ProduccionDetalleOrden pdo;
		lbxItemOrdenCliente.getItems().clear();
		
		Listitem li = new Listitem();
		li.setValue(new Compuesto(new EnvasadoControlPesoFillCabecera(), new EnvasadoControlPesoFillDetalle()));
		li.setParent(lbxItemOrdenCliente);
		
		li = new Listitem(NUEVO);
		li.setValue(new Compuesto(new EnvasadoControlPesoFillCabecera(), new EnvasadoControlPesoFillDetalle()));
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
			
			
			for(EnvasadoControlPesoFillDetalle ecpfd : ecpfc.getEnvasadoControlPesoFillDetalles()) {
				li = new Listitem();
				li.setValue(new Compuesto(ecpfc, ecpfd));
				
				new Listcell(pdo.getItem()
						+"-"+pdo.getOrden()
						+"-"+ecpfd.getPesofill()
						+"-"+new SimpleDateFormat("dd/MM/yyyy").format(ecpfd.getFechareg())
						+"-"+pdo.getCliente())
				.setParent(li);
				
				li.setParent(lbxItemOrdenCliente);
			}
		}
		
		lbxItemOrdenCliente.setSelectedIndex(0);
		
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
		EnvasadoControlPesoFillCabecera ecpfc = ((Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue()).envasadoControlPesoFillCabecera;
		if (ecpfc.getTurno()==null)
			lbxTurnoLabor.setSelectedIndex(0);
		else
			lbxTurnoLabor.setSelectedIndex(ecpfc.getTurno().getIdturno());
		
		cargaItemOrden();
		cargaInformacionFormulario() ;
		cargaCorte();
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
	
	private void cargaCorte() {
		
		Compuesto compuesto = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new EnvasadoControlFillCorteCabeceraDAOJpaImpl();
		
		EnvasadoProceso envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		List<EnvasadoControlFillCorteDetalle> listaEcfcd = ecfccDAO
				.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso())
				.getEnvasadoControlFillCorteDetalles();
		
		if (listaEcfcd != null)
			if (listaEcfcd.isEmpty()) {
				Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
				return;
			}
		
		lbxCorte.getItems().clear();
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
		
		
		String hora, minuto;
		for (EnvasadoControlFillCorteDetalle ecfcd : listaEcfcd) {
			li = new Listitem();
			li.setValue(ecfcd);

			hora = ecfcd.getHora()<=9?"0"+ecfcd.getHora():ecfcd.getHora().toString();
			minuto = ecfcd.getMinuto()<=9?"0"+ecfcd.getMinuto():ecfcd.getMinuto().toString();
			
			new Listcell(ecfcd.getCorte()+" -> "+hora+":"+minuto)
				.setParent(li);
			li.setParent(lbxCorte);
			
			if (compuesto.envasadoControlPesoFillDetalle.getIdenvasadocontrolpesofilldetalle()!=null)
				if (compuesto.envasadoControlPesoFillDetalle.getEnvasadoControlFillCorteDetalle().getIdenvasadocontrolfillcortedetalle()!=null)
					if (ecfcd.getIdenvasadocontrolfillcortedetalle().equals(compuesto.envasadoControlPesoFillDetalle
							.getEnvasadoControlFillCorteDetalle().getIdenvasadocontrolfillcortedetalle())) 
						lbxCorte.setSelectedItem(li);
		}
		if (lbxCorte.getSelectedIndex()<0)
			lbxCorte.setSelectedIndex(0);
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
		EnvasadoControlPesoFillDetalle ecpfd = compuesto.envasadoControlPesoFillDetalle;
		ProduccionDetalleOrden pdo = ecpfc.getProduccionDetalleOrden();
		if (pdo==null)
			pdo = new ProduccionDetalleOrden();
		
		if (ecpfc.getEnvasadoLineaCerradora()==null)
			ecpfc.setEnvasadoLineaCerradora(new EnvasadoLineaCerradora());
		
		if (ecpfc.getEnvasadoCaldoVegetalProteina()==null)
			ecpfc.setEnvasadoCaldoVegetalProteina(new EnvasadoCaldoVegetalProteina());
		
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		
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
			if (ecpfc.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()==null) {
				lbxcvprot.setSelectedIndex(0);
				break;
			} else if (ecpfc.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
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
			txtprot.setValue(null);
			txtcv.setValue(null);
			txtPesofill.setValue(null);
			txtObservacion.setValue(null);
		} else {
			txtPesoEnvase.setValue(String.valueOf(ecpfc.getPesoenvase()));
			txtPLomos.setValue(String.valueOf(ecpfc.getProcentajelomos()));
			txtTrozos.setValue(String.valueOf(ecpfc.getProcentajetrozos()));
			txtRallado.setValue(String .valueOf(ecpfc.getProcentajerallado()));
			txtAgua.setValue(String.valueOf(ecpfc.getAgua()));
			txtAceite.setValue(String.valueOf(ecpfc.getAceite()));
			txtprot.setValue(String.valueOf(ecpfc.getProteina()));
			txtcv.setValue(String.valueOf(ecpfc.getCaldovegetal()));
			txtPesofill.setValue(String.valueOf(ecpfd.getPesofill()));
			txtObservacion.setValue(ecpfc.getObservacion());
		}
		
		if (ecpfd.getFecharegusuario()==null) {
			lbxMes.setSelectedIndex(0);;
			lbxDias.getItems().clear();
			lbxHoras.setSelectedIndex(0);
			lbxMinutos.setSelectedIndex(0);
		} else {
			seleccionaMes(obtieneFechaCambio(ecpfd.getFecharegusuario(), Calendar.MONTH)+1);
			seleccionaDia(obtieneFechaCambio(ecpfd.getFecharegusuario(), Calendar.DAY_OF_MONTH));
			seleccionaHora(obtieneFechaCambio(ecpfd.getFecharegusuario(), Calendar.HOUR_OF_DAY));
			seleccionaMinuto(obtieneFechaCambio(ecpfd.getFecharegusuario(), Calendar.MINUTE));
		}
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
	
	@SuppressWarnings("unchecked")
	public void onClick$btnGrabar() {
		Compuesto compuesto = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		
		EnvasadoControlPesoFillCabecera ecpfc = compuesto.envasadoControlPesoFillCabecera;
		EnvasadoControlPesoFillDetalle ecpfd = compuesto.envasadoControlPesoFillDetalle;
		
		if (NUEVO.equals(lbxItemOrdenCliente.getSelectedItem().getLabel())) {
			ecpfc.setEnvasadoControlPesoFillDetalles(new ArrayList<EnvasadoControlPesoFillDetalle>());
		}
			
		
		if(!validaCampos())
			return;
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();

		ecpfc.setEnvasadoProceso((EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue());
		ecpfc.setEnvasadoControlPesoFillDetalles(Arrays.asList(ecpfd));
		ecpfc.setTurno(((Turno)lbxTurnoLabor.getSelectedItem().getValue()));
		ecpfc.setProduccionDetalleOrden(pdo);
		ecpfc.setEnvasadoLineaCerradora((EnvasadoLineaCerradora)lbxLineaCerradora.getSelectedItem().getValue());
		ecpfc.setPesoenvase(parseDouble(txtPesoEnvase.getValue()));
		ecpfc.setProcentajelomos(parseDouble(txtPLomos.getValue()));
		ecpfc.setProcentajetrozos(parseDouble(txtTrozos.getValue()));
		ecpfc.setProcentajerallado(parseDouble(txtRallado.getValue()));
		ecpfc.setAgua(parseDouble(txtAgua.getValue()));
		ecpfc.setAceite(parseDouble(txtAceite.getValue()));
		ecpfc.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
		ecpfc.setProteina(parseDouble(txtprot.getValue()));
		ecpfc.setCaldovegetal(parseDouble(txtcv.getValue()));
		
		ecpfd.setPesofill(parseDouble(txtPesofill.getValue()));
		
		Timestamp fechaRegistro = obtieneFechaRegistro();
		if (fechaRegistro==null)
			return;
		
		ecpfc.setFechareg(new Timestamp(System.currentTimeMillis()));
		ecpfd.setFecharegusuario(fechaRegistro);
		ecpfd.setFechareg(new Timestamp(System.currentTimeMillis()));
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		ecpfc.setUsuario(usuario);
		ecpfc.getEnvasadoControlPesoFillDetalles().get(0).setUsuario(usuario);
		
		EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle = (EnvasadoControlFillCorteDetalle)lbxCorte.getSelectedItem().getValue();
		ecpfc.getEnvasadoControlPesoFillDetalles().get(0).setEnvasadoControlFillCorteDetalle(envasadoControlFillCorteDetalle);
		
		ecpfc.setObservacion(txtObservacion.getValue());
		ecpfd.setEnvasadoControlPesoFillCabecera(ecpfc);
		ecpfc.setEnvasadoControlPesoFillDetalles(Arrays.asList(ecpfd));
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		
		if(ecpfcDAO.updateEnvasadoControlPesoFillCabecera(ecpfc)==null) {
			Sistema.mensaje("Error al guardar la informacion.");
			return;
		}
		
		EnvasadoControlPesoFillDetalleDAO ecpfdDAO = new EnvasadoControlPesoFillDetalleDAOJpaImpl();
		if (!NUEVO.equalsIgnoreCase(lbxItemOrdenCliente.getSelectedItem().getLabel()))
			if(ecpfdDAO.updateEnvasadoControlPesoFillDetalle(ecpfd)==null) {
				Sistema.mensaje("Error al guardar el detalle de la informacion.");
				return;
			}
		Sistema.mensaje("Cambios guardados exitosamente.");
		
		onSelect$lbxTurnoProduccion();
		
		for (Listitem li : (List<Listitem>)lbxItemOrdenCliente.getItems())
			if(((Compuesto)li.getValue()).envasadoControlPesoFillCabecera.getProduccionDetalleOrden()!=null)
			if(ecpfc.getProduccionDetalleOrden().getIdproducciondetalleorden().equals(
			((Compuesto)li.getValue()).envasadoControlPesoFillCabecera.getProduccionDetalleOrden().getIdproducciondetalleorden()))
				lbxItemOrdenCliente.setSelectedItem(li);			
	}
	
	public void onClick$btnEliminar(){
		if(!ChkEliminar.isChecked()) {
			Sistema.mensaje("Debe confirmar para poder eliminar.");
			return;
		}
		
		Compuesto c = (Compuesto)lbxItemOrdenCliente.getSelectedItem().getValue();
		
		if(c.envasadoControlPesoFillCabecera.getIdenvasadocontrolpesofillcabecera()==null) {
			Sistema.mensaje("Debe seleccionar un valor "+lbItemOrdenCliente.getValue()+" para eliminar.");
			return;
		}
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		
		EnvasadoControlPesoFillDetalleDAO ecpfdDAO = new  EnvasadoControlPesoFillDetalleDAOJpaImpl();
		
		if (!ecpfdDAO.eliminaEnvasadoControlPesoFillDetalle(c.envasadoControlPesoFillDetalle)){
			
			Sistema.mensaje("Registro en uso");
			return;
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
		txtprot.setValue(null);
		txtcv.setValue(null);
		lbxCorte.getItems().clear();
		txtPesofill.setValue(null);
		txtObservacion.setValue(null);
		lbxMes.setSelectedIndex(0);
		lbxDias.getItems().clear();
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);
		ChkEliminar.setChecked(false);
		
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
		listaEtiquetas.add(lbLineaCerradora);
		listaEtiquetas.add(lbxLineaCerradora);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPesoEnvase);
		listaEtiquetas.add(txtPesoEnvase);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPLomos);
		listaEtiquetas.add(txtPLomos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTrozos);
		listaEtiquetas.add(txtTrozos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbRallado);
		listaEtiquetas.add(txtRallado);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbAgua);
		listaEtiquetas.add(txtAgua);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbAceite);
		listaEtiquetas.add(txtAceite);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbcvprot);
		listaEtiquetas.add(lbxcvprot);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbprot);
		listaEtiquetas.add(txtprot);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPLomos);
		listaEtiquetas.add(txtPLomos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbcv);
		listaEtiquetas.add(txtcv);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbCorte);
		listaEtiquetas.add(lbxCorte);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPesofill);
		listaEtiquetas.add(txtPesofill);
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
		
		public EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle;
		
		public Compuesto(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera, EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
			this.envasadoControlPesoFillCabecera = envasadoControlPesoFillCabecera;
			this.envasadoControlPesoFillDetalle = envasadoControlPesoFillDetalle;
		}
		
	}
}

