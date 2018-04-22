package com.nw.util;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

 
import com.nw.model.CantidadLibra;
import com.nw.model.Luthy;
import com.nw.model.MaquinaCerradora;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.tiempo.Tiempo;


/**
 *  Copyright 2017 Nirsa. All rights reserved.
 *
 *  @author crholguin on 07/09/2017.
 *  Checkin Date   : 	 16/10/2017.
 *
 *  
 *  @Objetivo      : 
 *                   Clase generica para usar en los controladores (Windows)
 *             
 *  @Nota          :
 *                   La clase tiene que seguir creciendo y mejorando segun se requiera 
 *                   
 *                      
 *
 */
public class GenericNw extends GenericForwardComposer {
 
	private static final long serialVersionUID 		= 1L;
	
	protected Usuario 				   usuario 		= new Usuario();
    protected Tiempo 				   tiempo 		= new Tiempo();
    protected int 					   anioactual    ;
    protected Turno 				   turno 		 ;
    protected MaquinaCerradora 		   maquinaCerradora;
    protected Luthy 				   luthy		 ;
    protected CantidadLibra 		   cantidadLibra ;
	
    /** Objetos de los zul de Clase GenericNw */
    /*  fechas */
    protected Listbox                  lbxMes        , 
    								   lbxDias       , 
    					               lbxHoras      , 
    					               lbxMinutos    , 
    					               lbxMesFin     , 
    					               lbxDiasFin    , 
    					               lbxHorasFin   , 
    					               lbxMinutosFin ; 
    /* Listbox   */
    protected Listbox  				   lbxLinea      ,
    				    			   lbxProceso    , 
    				    			   lbxTipoParada , 
    				    			   lbxParadas    ; 
    /* Listbox  turno  */
    protected Listbox  				   lbxTurno      ;
    /* Listbox  talla  */
    protected Listbox  				   lbxTalla      ;
    /* Listbox MaquinaCerradora */
    protected Listbox  		  		   lbxMaquinaCerradora; 
    /* Listbox CantidadLibra  */
    protected Listbox  				   lbxCantidadLibra;
    /* Listbox Luthys  */
    protected Listbox                  lbxLuthy;
    
    /* textbox */
    protected Textbox 				   txtProduccionTurno;
    /* intbox */
    protected Intbox 				   ibxVelocidadNominal,
    								   ibxVelocidadMaxima ,
    								   ibxVelocidadReal ;
    
    /* botones crud */
    protected Toolbarbutton 		   btnAgregar , btnGrabar , btnEliminar;
    /* botones reporte */
    protected Toolbarbutton 		   btnPdf 	  , btnExcel  , btnHtml;
    
    /* datebox */
    protected Datebox 						   dtFechaLabor;
    
	 
	@Override
	public void doAfterCompose(Component comp) throws Exception 
	{  
	   super.doAfterCompose(comp); 
	   String usuarioSession = (String) Sessions.getCurrent().getAttribute("usuario");
	   usuario.setIdusuario(usuarioSession);   
	   DateFormat dateFormata = new SimpleDateFormat("yyyy");				
	   anioactual = Integer.valueOf(dateFormata.format(new Timestamp(new Date().getTime())));
	}

	
	/*   ====================================================================================   */
	/*     						     TODO : CARGA DE LISTBOX    						    */
	/*   ====================================================================================   */
	
	public void cargarListboxTurno(){
		  
		List<Turno>  turnos = new TurnoDAOJpaImpl().getTurnos();
		lbxTurno.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Turno());
			li.setParent(lbxTurno);
			try {
				for (Turno t : turnos) {
					li = new Listitem();
					li.setValue(t);
					new Listcell(t.getNombre()).setParent(li);
					li.setParent(lbxTurno);
				}
			} catch (Exception e) {
				 e.printStackTrace();
				System.out.println("Error al cargar  listbox lbxTurno");
			}
			lbxTurno.setSelectedIndex(0);
		 
	}
	
	public static <T> void cargarListbox(Object objeto, List<T> list, Listbox listBox , String nombreObjeto ){
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(objeto);
		listitem.setParent(listBox);
		 
		if (list != null) {
			for (Object obj : list) {
				listitem = new Listitem();
				listitem.setValue(obj);
				new Listcell( UtilObjeto.getPropiedad(nombreObjeto , obj )).setParent(listitem);
				listitem.setParent(listBox);
			}
			listBox.setSelectedIndex(0);
		}
		
	}
	
	/*   ====================================================================================   */
	/*     								TODO : BOTONES    							            */
	/*   ====================================================================================   */
	
	public void onClick$btnGrabar() throws InterruptedException{
		
	}
	
	public void onClick$btnAgregar()throws InterruptedException{
		
	}
	
	public void onClick$btnEliminar()throws InterruptedException{
		
	}
	
	public void onClick$btnPdf()throws InterruptedException, SuspendNotAllowedException, JRException{
		
	}
	
	public void onClick$btnExcel()throws InterruptedException, FileNotFoundException, JRException{
		
	}
	
 
	/*   ====================================================================================   */
	/*     						     TODO : SELECCIONES              						    */
	/*   ====================================================================================   */
	
	public void onSelect$lbxMaquinaCerradora() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxCantidadLibra() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxLuthy() throws InterruptedException {
	
	}
	
	public void onSelect$lbxParadas() throws InterruptedException {
		
	}
	
	public void onSelect$lbxProceso() throws InterruptedException {
		
	}
	
	public void onSelect$lbxTipoParada() throws InterruptedException {
		
	}
	
	public void onSelect$lbxTurno() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxTalla() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxMes() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxDias() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxHoras() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxMinutos() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxMesFin() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxDiasFin() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxHorasFin() throws InterruptedException {
		 
	}
	
	public void onSelect$lbxMinutosFin() throws InterruptedException {
		 
	}
	
	public void encerarObjeto(){
		 turno     			  =  null;  
		 maquinaCerradora     =  null;
		 luthy				  = null ;  
		 cantidadLibra 		  = null ;  
	}
	
	
	public  void encerarListboxFecha( Listbox lbxMes, Listbox lbxDia,
			  Listbox lbxHora, Listbox lbxMinuto) {

		if (lbxMes.getSelectedIndex() > 0) {
			lbxMes.setSelectedIndex(0);
		}
		
		if (lbxDia.getSelectedIndex() > 0) {
			lbxDia.setSelectedIndex(0);
		}
		
		if (lbxHora.getSelectedIndex() > 0) {
			lbxHora.setSelectedIndex(0);
		}
		
		if (lbxMinuto.getSelectedIndex() > 0) {
			lbxMinuto.setSelectedIndex(0);
		}
	
	}
	
	public  void encerarListbox( Listbox listbox ) {
		if (listbox.getSelectedIndex() > 0) {
			listbox.setSelectedIndex(0);
		}
	}	
	
	public  void encerarListboxFechaFin( ) {

		if (lbxMesFin.getSelectedIndex() > 0) {
			lbxMesFin.setSelectedIndex(0);
		}
		
		if (lbxDiasFin.getSelectedIndex() > 0) {
			lbxDiasFin.setSelectedIndex(0);
		}
		
		if (lbxHorasFin.getSelectedIndex() > 0) {
			lbxHorasFin.setSelectedIndex(0);
		}
		
		if (lbxMinutosFin.getSelectedIndex() > 0) {
			lbxMinutosFin.setSelectedIndex(0);
		}
	
	}
	
	/*   ====================================================================================   */
	/*     								TODO : MENSAJES    							            */
	/*   ====================================================================================   */
	
	public void mensajeGrabar(){
		 Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
	}
	
	
	/*   ====================================================================================   */
	/*     								TODO : REPORTES    							            */
	/*   ====================================================================================   */
	
	public void doImprimir(String nombre_report, Map<String,Object> parameters )
			throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		String logo = "logo_nirsa.gif";
		String logo2 = "logo_real.gif";
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo   = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_logo2  = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo2;
				
		//Map<String,Object> parameters = new HashMap<String,Object>();
		//parameters.put("turno",idturno);
		//parameters.put("idpro",idProduccion);
		parameters.put("LOGO",ruta_logo);
		parameters.put("LOGO2",ruta_logo2);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	
	
   
	//Funcion Generica para visulizar los reportes
	private void EjecutarReporte(Map<String,Object> parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
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
