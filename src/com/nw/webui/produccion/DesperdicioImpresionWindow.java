package com.nw.webui.produccion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
//import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.nw.model.Turno;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.AreaMarco;
import com.nw.util.Fecha;
import com.nw.util.Sistema;
import com.nw.webui.DescargarArchivoExcel;

public class DesperdicioImpresionWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(DesperdicioImpresionWindow.class);

	public AreaMarco area;
//	private Window winDesperdicioImprimir; // autowired
//	private Vbox vbxMain;
	
	private Datebox dteFecha;
	private Listbox lbxTurno; 
	private Textbox txtDiaJuliano;

	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		//cargarBarcosDescarga();
		/**
		 *Inicializacion y formateo controles datebox 		
		 */
		dteFecha.setValue(new Date());
		dteFecha.setFormat(Sistema.FORMATO_FECHA_DMY);	

		cargarTurnos();

		String x = Integer.toString(new Fecha().getDiasTranscurridos(dteFecha.getValue()));
		txtDiaJuliano.setValue(x);
		
		dteFecha.addEventListener("onChange", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				String x = Integer.toString(new Fecha().getDiasTranscurridos(dteFecha.getValue()));
				txtDiaJuliano.setValue(x);
			}
		});
	}


	private void cargarTurnos()
	{
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);
		
		List <Turno> turno = new TurnoDAOJpaImpl().getTurnos();

		for (Turno o: turno){
			li = new Listitem();
			li.setValue(o);
			new Listcell( o.getIdturno().toString()+" "+o.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);
	}


	private void imprimir() throws WrongValueException, SuspendNotAllowedException, JRException, InterruptedException{
		doImprimir("Desperdicio.jasper", "logo_nirsa.gif",  ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno(), dteFecha.getValue());				
	}	
		
	private void imprimirG() throws WrongValueException, SuspendNotAllowedException, JRException, InterruptedException{
		doImprimir("DesperdicioAgrupado.jasper", "logo_nirsa.gif",  ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno(), dteFecha.getValue());				
	}

	private void imprimirGP() throws WrongValueException, SuspendNotAllowedException, JRException, InterruptedException{
		doImprimir("DesperdicioProduccion.jasper", "logo_nirsa.gif",  ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno(), dteFecha.getValue());				
	}	
	
	public void doImprimir(String nombre_report, String logo, Integer idturno, Date fecha) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
				
		Map parameters = new HashMap();
		parameters.put("PIDTURNO",idturno);
		parameters.put("PFECHA",fecha);
		parameters.put("LOGO",ruta_logo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	

	//Funcion Generica para visulizar los reportes
	public void EjecutarReporte(Map parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		
		parameters.put("USUARIO",usuario);
		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
		//Obtenemos el reporte ejecutado en PDF en esta variable
		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);

		//Creamos un obj. window donde estara el zul que se llamara
		Window win = (Window) Executions.createComponents("/produccion/VisorReporte.zul", null,null);
		
		//Enviamos los parametros al zul
		win.setAttribute("reporteejecutado", reporteejecutado);
		
		//Ejecutamos el objeto winsdows con con el zul (esta enbebido)
		win.doModal(); // It shows subwindow.zul window.
	}	
	
	public void onClick$btnImprimir() throws Exception{
		if (lbxTurno.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione el turno");
			lbxTurno.focus();
			return;
		}
		imprimir();
	}


	public void onClick$btnImprimirG() throws Exception{
		if (lbxTurno.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione el turno");
			lbxTurno.focus();
			return;
		}
		imprimirG();
	}

	public void onClick$btnImprimirGP() throws Exception{
		if (lbxTurno.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione el turno");
			lbxTurno.focus();
			return;
		}
		imprimirGP();
	}	

	/**
	 * autor carper
	 * Descargar reporte en Excel
	 * 2014-02-06 Ajuste para aumentar la velocidad de descarga de archivos Excel
	 */
	public void onClick$btnExcel() throws Exception{
		if (lbxTurno.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione el turno");
			lbxTurno.focus();
			return;
		}
		new DescargarArchivoExcel().getDesperdicio(dteFecha.getText(), ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno());
	}	
}