package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;

import com.nw.model.Produccion;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;
import com.nw.webui.produccion.impresion.ProgamaProduccionImpresion;
public class ProduccionCargaOrdenesReporteWindow extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ProduccionCargaOrdenesReporteWindow.class);
	Datebox dteFecha1;
	public ProduccionCargaOrdenesReporteWindow() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	public void onClick$btnPdf(Event event) throws SuspendNotAllowedException, JRException, InterruptedException{
		if (dteFecha1.getValue()==null)
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
		
		new ProgamaProduccionImpresion().doImprimirProgramaProduccion("reportOrden.jasper","logo_real.gif", produccion.getIdproduccion());
	}
	
	public void onClick$btnExcel(Event event) throws Exception  {
		if (dteFecha1.getValue() ==null)
		{
			Sistema.mensaje("Seleccione la fecha Producción");
			dteFecha1.focus();
			return;
		}
		//Tomamos los parametros
		Produccion produccion = new Produccion();
		ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
		produccion = produccionDAOJpaImpl.getProduccionPorFecha(dteFecha1.getValue());
		
		if (produccion==null){
			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
			dteFecha1.focus();
			return;
		}
		//Ejecutamos el reporte
		doImprimir2("reportOrden.jasper", produccion.getIdproduccion(), "reportOrdenProduccion");
	}
	
	public void doImprimir2(String nombre_report, long id, String nombre_descarga_report) throws JRException, SuspendNotAllowedException, InterruptedException, FileNotFoundException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("IDPRODUCCION",id);
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
