package com.nw.webui.produccion;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.nw.util.ReporteExcel;

@SuppressWarnings("serial")
public class OeePeriodosBasesReporteWindow extends GenericForwardComposer {

	@SuppressWarnings("unused")
	private Toolbarbutton btnImprimirPdf, btnImprimirExcel;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$btnImprimirExcel(Event event) throws JRException,
			SuspendNotAllowedException, InterruptedException, Throwable {

		String nombrejasper = "OeeProcesosExcel.jasper";
		String logo = "logo_nirsa.gif";

		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/img").toString()
				+ System.getProperty("file.separator") + logo;

		Map parameters = new HashMap();
		parameters.put("LOGO", ruta_logo);

		new ReporteExcel().generarExcelJasper("OeeProcesos", nombrejasper,
				logo, parameters);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onClick$btnImprimirPdf(Event event)
			throws SuspendNotAllowedException, JRException,
			InterruptedException {
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		String logo = "logo_nirsa.gif";
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/img").toString()
				+ System.getProperty("file.separator") + logo;
		String nombre_report = "OeeProcesosExcel.jasper";
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/reportes").toString()
				+ System.getProperty("file.separator") + nombre_report;

		Map parameters = new HashMap();
		parameters.put("LOGO", ruta_logo);
		parameters.put("USUARIO", usuario);

		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl()
				.ReportesDAOJpaImpl(parameters, ruta_report);

		Window win = (Window) Executions.createComponents(
				"/produccion/VisorReporte.zul", null, null);
		win.setAttribute("reporteejecutado", reporteejecutado);
		win.doModal();
	}
}