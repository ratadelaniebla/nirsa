package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

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
import org.zkoss.zul.Row;

import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;
import com.nw.webui.produccion.impresion.ProgamaProduccionImpresion;

public class AutoclaveParadaDatosReporteWindow extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AutoclaveParadaDatosReporteWindow.class);
	Datebox dteFecha1;
	Listbox lbxTurno, lbxReporte;
	AnnotateDataBinder binder;
	private Produccion produccion;
	public Row rRowTurno;
	
	private String valorSeleccionado = "0";
	private String nombreReporte;
	public AutoclaveParadaDatosReporteWindow() {
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
	
	public void onSelect$lbxReporte() {
		valorSeleccionado = lbxReporte.getSelectedItem().getId();
		
		rRowTurno.setVisible(false);
		lbxTurno.setSelectedIndex(0);
		if (lbxReporte.getSelectedItem()==null) {
			nombreReporte = null;
			return;
		}
		
		switch (valorSeleccionado) {
		case "1":
			nombreReporte = "autoClaveParadaControl";
			break;
		case "2":
			nombreReporte = "controlcoches";
			break;
		case "3":
			nombreReporte = "controlAutoclaveAreaEsterilizado";
			break;
		case "4":
			nombreReporte = "muestraControlCalidad";
			rRowTurno.setVisible(true);
			break;

		default:
			break;
		}
			
	}
	
//	public void onChange$dteFecha1() {
//		produccion = new Produccion();
//		ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
//		produccion = produccionDAOJpaImpl.getProduccionPorFecha(dteFecha1.getValue());
//		
//		if (produccion==null){
//			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
//			dteFecha1.focus();
//			return;
//		}
//		
//		List<EnvasadoProceso> listaEnvasadoProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByIdProduccion(produccion.getIdproduccion());
//		if (listaEnvasadoProceso.isEmpty()) {
//			Sistema.mensaje("No existen turno disponibles.");
//			return;
//		}
//			
//		lbxTurno.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new Turno());
//		li.setParent(lbxTurno);
//		
//		for (EnvasadoProceso ePTurno : listaEnvasadoProceso) {
//			 li = new Listitem();
//			 li.setValue(ePTurno.getTurno());
//			 new Listcell(ePTurno.getTurno().getNombre()).setParent(li);
//			 li.setParent(lbxTurno);
//		}
//		lbxTurno.setSelectedIndex(0);
//	}
	
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
	public void onClick$btnPdf(Event event) throws SuspendNotAllowedException, JRException, InterruptedException{
		if (dteFecha1.getValue()==null)
		{
			Sistema.mensaje("Seleccione la fecha Producción");
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

		if (nombreReporte==null){
			Sistema.mensaje("Debe selccionar un reporte.");
			dteFecha1.focus();
			return;
		}
		
		Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
		if (turno.getIdturno() == null && "muestraControlCalidad".equals(nombreReporte)) {
			Sistema.mensaje("Debe elegir un turno.");
			lbxTurno.focus();
			return;
		}
		new ProgamaProduccionImpresion().doImprimirProgramaAutoClaveControl(nombreReporte+".jasper","logo_real.gif", produccion.getIdproduccion(), turno.getIdturno());
	}
	
	public void onClick$btnExcel(Event event) throws Exception  {
		if (dteFecha1.getValue() ==null)
		{
			Sistema.mensaje("Seleccione la fecha Producción");
			dteFecha1.focus();
			return;
		}
		Produccion produccion = new Produccion();
		ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
		produccion = produccionDAOJpaImpl.getProduccionPorFecha(dteFecha1.getValue());
		
		if (produccion==null){
			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
			dteFecha1.focus();
			return;
		}
		if (nombreReporte==null){
			Sistema.mensaje("Debe selccionar un reporte.");
			dteFecha1.focus();
			return;
		}
		Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
		if (turno.getIdturno() == null && "muestraControlCalidad".equals(nombreReporte)) {
			Sistema.mensaje("Debe elegir un turno.");
			lbxTurno.focus();
			return;
		}		
		
		//Ejecutamos el reporte
		doImprimir2(nombreReporte+".jasper", nombreReporte, produccion.getIdproduccion(), turno.getIdturno());
	}
	
	public void doImprimir2(String nombre_report, String nombre_descarga_report, long id, Integer idTurno) throws JRException, SuspendNotAllowedException, InterruptedException, FileNotFoundException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("IDPRODUCCION",id);
		parameters.put("IDTURNO", idTurno);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte 
		//EjecutarReporte(parameters, ruta_report);
		 //String logo = "logo_nirsa.gif";
		new ReporteExcel().generarExcelJasper(nombre_descarga_report, nombre_report, logo, parameters);
	}	

	public Datebox getDteFecha1() {
		return dteFecha1;
	}

	public void setDteFecha1(Datebox dteFecha1) {
		this.dteFecha1 = dteFecha1;
	}
	
	
}
