package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;
import com.nw.model.dao.impl.EnvasadoControlPesoFillCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;
import com.nw.webui.produccion.impresion.ProgamaProduccionImpresion;

import net.sf.jasperreports.engine.JRException;

public class EnvasadoDetalleControlPesoFillNetoReporteWindow extends GenericForwardComposer{

	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoFillNetoReporteWindow.class);
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Datebox dteFecha1;
	Listbox lbxTurno, lbxItemOrdenCliente;

	Produccion produccion;
	EnvasadoProceso envasadoProceso;
	
	public EnvasadoDetalleControlPesoFillNetoReporteWindow() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		cargaTurno();
		binder.loadAll();
	}
	
	private void cargaTurno() {
		lbxTurno.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);
		
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		for (Turno turno : listaTurnos) {
			 li = new Listitem();
			 li.setValue(turno);
			 new Listcell(turno.getNombre()).setParent(li);
			 li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);
	}
	
	public void onSelect$lbxTurno() {

		envasadoProceso = new EnvasadoProceso();
		
		if (dteFecha1.getValue()==null){
			Sistema.mensaje("Seleccione la fecha Producción");
			lbxTurno.setSelectedIndex(0);
			dteFecha1.focus();
			return;
		}
		
		produccion = new Produccion();
		ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
		produccion = produccionDAOJpaImpl.getProduccionPorFecha(dteFecha1.getValue());
		
		if (produccion==null){
			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
			dteFecha1.focus();
			return;
		}
		
		List<EnvasadoProceso> listaEvDAO = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByIdProduccion(produccion.getIdproduccion());
		
		Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
		for (EnvasadoProceso ep : listaEvDAO) {
			if (ep.getTurno().getIdturno().equals(turno.getIdturno())) {
				envasadoProceso = ep;
				break;
			}
		}
		
		Listitem li;
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		
		lbxItemOrdenCliente.getItems().clear();
		
		li = new Listitem();
		li.setValue(new EnvasadoControlPesoFillCabecera());
		li.setParent(lbxItemOrdenCliente);
		
		List<EnvasadoControlPesoFillCabecera> listaEcpfc = ecpfcDAO.getByProduccion(envasadoProceso.getIdenvasadoproceso());
		Collections.sort(listaEcpfc, new Comparator<EnvasadoControlPesoFillCabecera>() 		
		{
			@Override
			public int compare(EnvasadoControlPesoFillCabecera o1, EnvasadoControlPesoFillCabecera o2) {
				return new Integer(o1.getProduccionDetalleOrden().getItem()).compareTo(o2.getProduccionDetalleOrden().getItem());
			}
		});
		
		for (EnvasadoControlPesoFillCabecera ecpfc : listaEcpfc ) {
			li = new Listitem();
			li.setValue(ecpfc);
			new Listcell(ecpfc.getProduccionDetalleOrden().getItem()+"- "+ecpfc.getProduccionDetalleOrden().getOrden()).setParent(li);
			li.setParent(lbxItemOrdenCliente);
		}
		
		lbxItemOrdenCliente.setSelectedIndex(0);
	}
	
	public void onClick$btnPdf(Event event) throws SuspendNotAllowedException, JRException, InterruptedException{
		if (!validar())
			return;
		EnvasadoControlPesoFillCabecera ecpfc = (EnvasadoControlPesoFillCabecera)lbxItemOrdenCliente.getSelectedItem().getValue();

		new ProgamaProduccionImpresion().doImprimirProgramaPesoFillNeto("EnvasadoDetalleControlPesoFillReporte.jasper",
				"logo_real.gif", ecpfc.getIdenvasadocontrolpesofillcabecera());
	}
	
	public void onClick$btnExcel(Event event) throws Exception  {
		if (!validar())
			return;
		EnvasadoControlPesoFillCabecera ecpfc = (EnvasadoControlPesoFillCabecera)lbxItemOrdenCliente.getSelectedItem().getValue();

		//Ejecutamos el reporte
		doImprimir2("EnvasadoDetalleControlPesoFillReporte.jasper", "EnvasadoDetalleControlPesoFillReporte", ecpfc.getIdenvasadocontrolpesofillcabecera());
	}
	
	public void doImprimir2(String nombre_report, String nombre_descarga_report, Long idenvasadocontrolpesofillcabecera) throws JRException, SuspendNotAllowedException, InterruptedException, FileNotFoundException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		parameters.put("idenvasadocontrolpesofillcabecera", idenvasadocontrolpesofillcabecera);
		
		new ReporteExcel().generarExcelJasper(nombre_descarga_report, nombre_report, logo, parameters);
	}
	
	private boolean validar() {
		if (dteFecha1.getValue()==null){
			Sistema.mensaje("Seleccione la fecha Producción");
			dteFecha1.focus();
			return false;
		}
		
		if (produccion.getIdproduccion()==null){
			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
			dteFecha1.focus();
			return false;
		}
		
		Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
		if (turno.getIdturno() == null) {
			Sistema.mensaje("Debe elegir un turno.");
			lbxTurno.focus();
			return false;
		}
		EnvasadoControlPesoFillCabecera ecpfc = (EnvasadoControlPesoFillCabecera)lbxItemOrdenCliente.getSelectedItem().getValue();
		if (ecpfc.getIdenvasadocontrolpesofillcabecera()==null) {
			Sistema.mensaje("Debe elegir un valor para Item - Orden.");
			lbxTurno.focus();
			return false;
		}
		
		return true;
	}

}