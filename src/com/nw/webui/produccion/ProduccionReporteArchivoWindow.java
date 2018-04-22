package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaLote;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class ProduccionReporteArchivoWindow extends GenericForwardComposer {

	private Listbox lbxCargas, lbxTurno;
	private Checkbox chbRevisado;
	private Toolbarbutton btnImprimir;
	private Datebox dteFecReg;	
	private ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	private Produccion produccion = new Produccion();	
	private Turno glo_turno = new Turno();
	private TurnoDAOJpaImpl turnoDao = new TurnoDAOJpaImpl();
	//lista para lotes una de limpieza otra de pochplote
	private List<ProduccionArchivoCargaLote> listaPACL = new ArrayList<ProduccionArchivoCargaLote>();
	private ProduccionArchivoCargaLote gloPACL = new ProduccionArchivoCargaLote();
	private Date fecha;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();		
		obtenerturnos();
		
		dteFecReg.setValue(new Date());
		dteFecReg.setFormat(Sistema.FORMATO_FECHA_DMY);	
		
		dteFecReg.setText(null);
	}

	public void obtenerturnos() {
		lbxCargas.getItems().clear();
		try {

			lbxTurno.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Turno());
			li.setParent(lbxTurno);

			List<Turno> listaTurno = turnoDao.getTurnos();

			for (Turno itenturno : listaTurno) {
				li = new Listitem();
				li.setValue(itenturno);

				new Listcell(String.valueOf(itenturno.getNombre()))
						.setParent(li);
				li.setParent(lbxTurno);

				// glo_turno.setIdproduccion(itenturno.getIdproduccion());
			}
			lbxTurno.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void obtenerArchivos() {
		try {

			lbxCargas.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Turno());
			li.setParent(lbxCargas);

			listaPACL = produccionImpl.listaProduccionArchivoLotexFecha(dteFecReg.getValue(),glo_turno.getIdturno());
			Integer pos = 0;
			for (ProduccionArchivoCargaLote itenpacl : listaPACL) {
				li = new Listitem();
				li.setValue(itenpacl);
				pos = pos + 1;				
				new Listcell(pos.toString()+" - "+ String.valueOf(itenpacl.getNombrearchivo())).setParent(li);
				//new Listcell(String.valueOf(itenpacl.getNombrearchivo()))
				//.setParent(li);
				li.setParent(lbxCargas);
//				if (listaPACL.size() == pos)
//				{
//					new Listcell(String.valueOf(itenpacl.getNombrearchivo())).setParent(li);
//					li.setParent(lbxCargas);
//				}

				// glo_turno.setIdproduccion(itenturno.getIdproduccion());
			}
			lbxCargas.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	
	public void onChange$dteFecReg() {
		obtenerturnos();
		lbxTurno.setSelectedIndex(0);
	}	
	
	public void onSelect$dteFecReg() {
		obtenerturnos();
		lbxTurno.setSelectedIndex(0);
	}	
	
	
	public void onClick$btnActulizar() throws InterruptedException
	{
		if (dteFecReg.getText().isEmpty() ) 
		{
			Sistema.mensaje("Seleciones fecha de producción");
			dteFecReg.setFocus(true);
			return;
		}
		
		if (lbxTurno.getSelectedIndex() <= 0) 
		{
			Sistema.mensaje("Seleccione Turno de Producción");
			lbxTurno.setFocus(true);
			return;
		}
		
		onSelect$lbxTurno();
		
		lbxCargas.setFocus(true);
	}
	
	
	
	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			glo_turno = new Turno();
			glo_turno = (Turno) lbxTurno.getSelectedItem().getValue();// asigno
			
			obtenerArchivos(); 
			
		} else {
			lbxCargas.getItems().clear();
			glo_turno = null;
		}
	}
	
	public void onSelect$lbxCargas() throws InterruptedException {
		if (lbxCargas.getSelectedIndex() > 0) {
			gloPACL = new ProduccionArchivoCargaLote();
			gloPACL = (ProduccionArchivoCargaLote) lbxCargas.getSelectedItem().getValue();// asigno
			
			System.out.println("Subida : "+String.valueOf(lbxCargas.getSelectedIndex())+" - "+gloPACL.getNombrearchivo());
		} else {
			gloPACL = null;
		}
	}
	
	void limpiarDatos() {

		if(lbxTurno.getSelectedIndex() >= 0){
			lbxTurno.setSelectedIndex(0);		
		}
		gloPACL = new ProduccionArchivoCargaLote();
		lbxCargas.getItems().clear();
		glo_turno = new Turno();
		produccion = new Produccion();

	}
	
	public void onClick$btnImprimir() throws InterruptedException, Exception, SuspendNotAllowedException, JRException {
		if (lbxCargas.getSelectedIndex() <= 0) {
			Sistema.mensaje("No se ha escogido el archivo de cargas..");
			return;
		}

		if (lbxTurno.getSelectedIndex() <= 0) {
			Sistema.mensaje("No se ha escogido el Turno ");
			return;
		}
		
		imprimir();
	}
	private void imprimir() throws WrongValueException, SuspendNotAllowedException, JRException, InterruptedException{
		doImprimir("ReporteCargadeArchivo.jasper", "logo_nirsa.gif",  ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno(), gloPACL.getIdproduccionarchivocargalote());				
	}	
	
	public void doImprimir(String nombre_report, String logo, Integer idturno, Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
				
		Map parameters = new HashMap();
		parameters.put("turno",idturno);
		parameters.put("idproduccion",idProduccion);
		parameters.put("LOGO",ruta_logo);
		
		//parameters.put("IPCL",gloPACL.getIdproduccionarchivocargalote());
		
		parameters.put("CARGA","Subida : "+String.valueOf(lbxCargas.getSelectedIndex())+" - "+gloPACL.getNombrearchivo());
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	

		
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$btnImprimirDesgloseExcel() throws SuspendNotAllowedException, JRException, InterruptedException, FileNotFoundException{

		if (dteFecReg.getText().isEmpty() ) 
		{
			Sistema.mensaje("Seleciones fecha de producción");
			dteFecReg.setFocus(true);
			return;
		}

		if (lbxTurno.getSelectedIndex() <= 0) {
			Sistema.mensaje("No se ha escogido el Turno.. ");
			lbxTurno.setFocus(true);
			return;
		}
		
		
		String nombrejasper = "ReporteCargadeArchivoReperton.jasper";
		//String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String logo = "logo_nirsa.gif";		
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		produccion = new Produccion();
	    produccion = new ProduccionDAOJpaImpl().BurcarFechaProduccionporFecha (String.valueOf( new Timestamp(dteFecReg.getValue().getTime()) ));

	
		Map parameters = new HashMap();
		parameters.put("turno",((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno());
		parameters.put("idproduccion",produccion.getIdproduccion());
		parameters.put("LOGO",ruta_logo);		
		
		//parameters.put("pidcocinaaperturacierredetalle",cacd.getIdcocinaaperturacierredetalle()); 
		
		new ReporteExcel().generarExcelJasper("CocinaControlProceso", nombrejasper, logo, parameters);
		
		
	
	
 }	
	
	
	public void onClick$btnImprimirDesglosePdf() throws InterruptedException, Exception, SuspendNotAllowedException, JRException {
		if (dteFecReg.getText().isEmpty() ) 
		{
			Sistema.mensaje("Seleciones fecha de producción");
			dteFecReg.setFocus(true);
			return;
		}

		if (lbxTurno.getSelectedIndex() <= 0) {
			Sistema.mensaje("No se ha escogido el Turno.. ");
			lbxTurno.setFocus(true);
			return;
		}
		
		imprimirDesglose();
	}
	
	private void imprimirDesglose() throws WrongValueException, SuspendNotAllowedException, JRException, InterruptedException{
		
		produccion = new Produccion();
	    produccion = new ProduccionDAOJpaImpl().BurcarFechaProduccionporFecha (String.valueOf( new Timestamp(dteFecReg.getValue().getTime()) ));

		
		doImprimirReporteDesglose("ReporteCargadeArchivoReperton.jasper", "logo_nirsa.gif",  ((Turno)lbxTurno.getSelectedItem().getValue()).getIdturno(), produccion.getIdproduccion());				
	}
	
	public void doImprimirReporteDesglose(String nombre_report, String logo, Integer idturno, Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		
		Map parameters = new HashMap();
		parameters.put("turno",idturno);
		parameters.put("idproduccion",idProduccion);
		parameters.put("LOGO",ruta_logo);
		//parameters.put("SUBREPORT_DIR", ruta_sub_report);
		
		//parameters.put("IPCL",gloPACL.getIdproduccionarchivocargalote());
		
		parameters.put("CARGA","Subida : "+String.valueOf(lbxCargas.getSelectedIndex())+" - "+gloPACL.getNombrearchivo());
		
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
	

}
