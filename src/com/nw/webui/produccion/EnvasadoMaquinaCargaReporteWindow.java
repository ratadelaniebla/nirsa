package com.nw.webui.produccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;
import com.nw.webui.produccion.impresion.ProgamaProduccionImpresion;

import net.sf.jasperreports.engine.JRException;

public class EnvasadoMaquinaCargaReporteWindow extends GenericForwardComposer{

	private static Log logger = LogFactory.getLog(EnvasadoMaquinaCargaReporteWindow.class);
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Datebox dteFecha1;
	Listbox  lbxReporte, lbxTurno;
	Produccion produccion;
	Turno turno;
	EnvasadoProceso envasadoProceso;
	
	public EnvasadoMaquinaCargaReporteWindow() {
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
	
	public void onClick$btnPdf(Event event) throws SuspendNotAllowedException, JRException, InterruptedException{
		if (!validar())
			return;

		String reporte = lbxReporte.getSelectedItem().getId();
		switch (reporte) {
		case "rpe": 
			new ProgamaProduccionImpresion().doImprimirReporteProductosEnvasado("reporteProductosEnvasados.jasper",
					"logo_real.gif", produccion.getIdproduccion(), turno.getIdturno());
			break;
		case "rmpa":
			new ProgamaProduccionImpresion().doImprimirReporteMaquinaPlantaAtunera("reporteMaquinaPlantaAtunera.jasper",
					"logo_real.gif", produccion.getIdproduccion(), turno.getIdturno());
			break;
		default:
			break;
		}
	}
	
	public void onClick$btnExcel(Event event) throws Exception  {
		if (!validar())
			return;
		
		//Obtenemos la ruta del reporte .jrxml
		String logo = "logo_real.gif";
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		parameters.put("USUARIO",(String)Sessions.getCurrent().getAttribute("usuario"));
		
		//Ejecutamos el reporte
		String reporte = lbxReporte.getSelectedItem().getId();

		switch (reporte) {
		case "rpe":
			parameters.put("idproduccion",produccion.getIdproduccion());
			parameters.put("idturno", turno.getIdturno());
			new ReporteExcel().generarExcelJasper("reporteProductosEnvasados", "reporteProductosEnvasados.jasper", logo, parameters);
			break;
		case "rmpa":
			parameters.put("idproduccion",produccion.getIdproduccion());
			parameters.put("idturno", turno.getIdturno());
			new ReporteExcel().generarExcelJasper("reporteMaquinaPlantaAtunera", "reporteMaquinaPlantaAtunera.jasper", logo, parameters);
			break;

		default:
			break;
		}
	}
	
	private boolean validar() {
		if (lbxReporte.getSelectedItem().getId()==null) {
			Sistema.mensaje("Seleccione el tipo de reporte.");
			lbxReporte.focus();
			return false;
		}
		
		if (dteFecha1.getValue()==null){
			Sistema.mensaje("Seleccione la fecha Producción");
			dteFecha1.focus();
			return false;
		}
		
		ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
		produccion = produccionDAOJpaImpl.getProduccionPorFecha(dteFecha1.getValue());
		
		if (produccion==null){
			Sistema.mensaje("La fecha de producción no se encuentra configurada en el sistema.");
			dteFecha1.focus();
			return false;
		}
		
		turno = (Turno)lbxTurno.getSelectedItem().getValue();
		if (turno.getIdturno() == null) {
			Sistema.mensaje("Debe elegir un turno.");
			lbxTurno.focus();
			return false;
		}
		
		return true;
	}

}