package com.nw.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkex.zul.Center;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

 
import com.nw.model.LimpiezaDetalleProcesoBandeja;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaProcesoEmpleado;
import com.nw.model.Parametro;
import com.nw.model.dao.impl.LimpiezaProcesoEmpleadoDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.PccParametroDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;


@SuppressWarnings("unchecked")
public class Sistema {
	
	private static Log log = LogFactory.getLog(Sistema.class);
	
	/** Formato de la mascara para las fechas */
	public static final String FORMATO_FECHA_GUI = "yyyy-MM-dd";
	public static final String FORMATO_FECHA_DMY = "dd-MM-yyyy";
	public static final String FORMATO_FECHA_DMY_HMS = "dd-MM-yyyy HH:mm:ss";	
	
	/** Accion para crear un registro */
	public static final int NUEVO  = 0;

	// ***************************************************************
	/** Formulario para mostrar las opciones del menú */
	public static final String WIN_MENU = "/rol/menuPrincipal.zul";

	/** DATO NULL **/
	public static final Double dato_null = -1999.91;
	
	/** PROCESOS */
	public static final int PROC_DESCONGELADO  	= 1;
	public static final int PROC_EVISCERADO  	= 2;
	public static final int PROC_COCCION  		= 3;
	public static final int PROC_NEBULIZADO  	= 4;
	public static final int PROC_ASIGMESAS  	= 5;
	public static final int PROC_BANDEJAS  		= 6;

	/** ESTADOS PROCESO */
	public static final String STTSPROC_BORRADOR  	= "B";
	public static final String STTSPROC_CERRADO  	= "C";
	
	// ***************************************************************
	public static final String MSG_SELECCIONAR_ORDEN 		= "Seleccione una Orden o Producto";
	public static final String MSG_CONSULTA_VACIA 			= "La consulta NO ha devuelto registros";
	public static final String MSG_TRANSACCION_GRABADA		= "La transacción ha sido grabada!";
	public static final String MSG_ERRORPESOTINAS			= "Existen Tinas sin registro de peso!";
	public static final String MSG_NOIMPLEMENTADOAUN		= "Disculpas Funcionalidad no implementada aun!";
	public static final String MSG_PROCESO_CERRADO			= "Proceso ya se encuentra CERRADO!";
	public static final String MSG_MARCAR_CERRAR			= "Marque Indicador Cerrar Proceso!";

	public static final String MSG_ORDEN_INEXISTENTE 		= "Orden no existe, favor verificar los datos ";
	public static final String MSG_ORDEN_EXISTENTE 			= "Orden ya existe, favor verificar los datos ";
	public static final String MSG_TINA_INEXISTENTE 		= "Ingrese datos de cabecera de proceso!";
	public static final String MSG_COCINADA_SELECCIONADA	= "Cocinada ya ha sido seleccionada!";
	public static final String MSG_TINAS_GRABADAS 			= "Tinas grabadas correctamente ";
	public static final String MSG_MEDIOS_GRABADOS 			= "Medios grabados correctamente ";
	public static final String MSG_MEDIOS_SIN_TARA 			= "Medio sin Tara ";
	public static final String MSG_ORDENES_GRABADAS 		= "Ordenes grabadas correctamente ";
	
	public static final String MSG_GRABAR_C_PROCESO 		= "Grabe Primero Datos de cabecera de Proceso!";
	public static final String MSG_INGRESE_DATOS_CP 		= "Ingrese datos de cabecera de proceso!";
	public static final String MSG_INGRESE_DATOS_COCINAS 	= "Ingrese datos de Cocinas!";
	public static final String MSG_INGRESE_DATOS_CAMARAS 	= "Ingrese datos de Camara!";
	public static final String MSG_INGRESE_DATOS_RECURSO 	= "Ingrese datos de Recurso!";
	public static final String MSG_INGRESE_DATOS_MESAS 		= "Ingrese datos de Mesas!";
	public static final String MSG_INGRESE_DATOS_FACTOR		= "Ingrese dato de Factor!";
	public static final String MSG_INGRESE_MEDIO		 	= "Ingrese medio!";
	public static final String MSG_INGRESE_SCRAP		 	= "No olvide Crear Scrap!";
	public static final String MSG_INGRESE_RECURSOS		 	= "No olvide Ingresar Recursos!";

	public static final String MSG_INGRESE_DATO		 		= "Ingrese dato ";

	public static final String FMTFECHA_YMD24HMS			= "yyyy-MM-dd HH:mm:ss";

	@SuppressWarnings("unused")
	private static LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja = new LimpiezaDetalleProcesoBandeja();
	/**
	 * Convierte un String a tipo primitivo short 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (short, valor convertido)
	 */
	public static short parseShort(String strValor){
		short valor=0;
		try{
			valor = Short.parseShort(strValor);
		}catch(Exception e){
			valor = 0;
		}
		return valor;
	}
	
	/**
	 * Convierte un String a tipo primitivo int 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (int, valor convertido)
	 */
	public static int parseInt(String strValor){
		int valor=0;
		try{
			valor = Integer.parseInt(strValor);
		}catch(Exception e){
			valor = 0;
		}
		return valor;
	}

	/**
	 * Convierte un String a tipo primitivo long 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (long, valor convertido)
	 */
	public static long parseLong(String strValor){
		long valor=0;
		try{
			valor = Long.parseLong(strValor);
		}catch(Exception e){
			valor = 0;
		}
		return valor;
	}
	
	/**
	 * Convierte un String a tipo primitivo double 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (double, valor convertido)
	 */
	public static double parseDouble(String strValor){
		double valor=0;
		try{
			valor = Float.parseFloat(strValor);
		}catch(Exception e){
			valor = 0;
		}
		return valor;
	}

	/**
	 * Convierte un String a tipo primitivo float 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (float, valor convertido)
	 */
	public static float parseFloat(String strValor){
		float valor;
		try{
			valor = Float.parseFloat(strValor);
		}catch(Exception e){
			valor = 0;
		}
		return valor;
	}

	/** Termina la sesion del usuario en el sistema */
	public static void terminarSesion(){
		log.warn("Logout: "+Sessions.getCurrent().getAttribute("usuario"));
		Sessions.getCurrent().setAttribute("usuario", null);
		org.zkoss.zk.ui.Executions.sendRedirect("/index.zul");
	}


	/**
	 * Muestra un mensaje de excepcion mediante un alert de javascript
	 * @author carper
	 * @param e (Exception, Objeto de excepcion para mostrar el mensaje de error
	 */
	public static void mensaje(Exception e){
//		System.out.println("****************************************************************************");
//		System.out.println(e.getCause());
//		System.out.println("****************************************************************************");
		String causa = throwable2String(e.getCause());
		if (causa!=null)
			Clients.evalJavaScript("alert('"+causa+"')");
		
		log.warn(stack2string(e) );
		
		String str = e.getMessage(); e.printStackTrace();
		Clients.evalJavaScript("alert('"+str+"')");			
	}
	
	/**
	 * Muestra un mensaje especificado mediante un alert de javascript
	 * @author carper
	 * @param str (String, Mensaje a presentar)
	 */
	public static void mensaje(String str){
		Clients.evalJavaScript("alert('"+str+"')");
		System.out.println(str);
	}

	
	public static void mensajeError(String str){
		Clients.evalJavaScript("alert('ERROR :"+str+"')");
		System.out.println(str);
	}	
	
	
	//confirm("¿Quieres ir al índice de WebTaller?"
	
	public static Integer mensajeYesNo(String str){
		//Clients.
		//Integer res;
		Clients.evalJavaScript("alert('"+str+"')");
		
		
		String script = "var s1 = 'background:green; color:yellow; font-weight:bold; font-style: italic;'," +
				"s2 = 'background:white; color:black; font-weight:normal; font-style: normal;';" +
				"this.setStyle(this.getValue() == 'OK' ? s1: s2);";
		
		/////////////Clients.evalJavaScript("confirm('"+str+"')");
		//Clients.evalJavaScript("zk.Widget.$(jq('$tabOne')[0])._preventSelect = true");
		System.out.println(str);
		return 1;
	}
	
	public static void areaMarco(String ancho, String alto, String anchoInterno) {
		Sessions.getCurrent().setAttribute("areaMarco", new AreaMarco(ancho,alto,anchoInterno));
	}
	
	public static AreaMarco getAreaMarco(){
		AreaMarco area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		if (area==null)
			area = new AreaMarco("295px","600px","274px");
		
		return area;
	}

	
	
	
	public static Long getFechaProduccionActiva(){
		return new ProduccionDAOJpaImpl().getFechaProduccionActiva().getIdproduccion();
	}	
	
	/**
	* Convert the stack trace into a string using 
	* {@link java.io.StringWriter} and {@link java.io.PrintWriter}.
	*
	* @param throwable a <code>Throwable</code> value
	* @return the string representation of the stack trace
	*/
	private static String throwable2String(Throwable throwable) {
		if (throwable == null) return null;
		StringWriter writer = new StringWriter();
		throwable.printStackTrace(new PrintWriter(writer));
		return(writer.toString());
	}
	// Convierte un stackTrace a String
	public static String stack2string(Exception e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String clienteDireccionIP = "";
			try{ clienteDireccionIP = Sessions.getCurrent().getRemoteAddr(); }
			catch (Exception e1){};
			
			return "\r\n====== EXCEPCION DEL SISTEMA ["+ clienteDireccionIP + " " + new Fecha().strGetFecha()+"] \r\n" + sw.toString() + "======\r";
		}
		catch(Exception e2) {
			e2.printStackTrace();
			return "Stack2string erróneo: " + e2.getMessage();
		}
	}
	
	/**
	 * Este metodo carga un formulario dentro del menu principal. Tambien sirve  
	 * para refrescar el formulario despues de que termina la transaccion.
	 * @param formulario (String, Nombre del formulario a ejecutar)
	 */
	public static void ejecutar(String formulario){
		
    	Center blyCentro = (Center)Path.getComponent("//pagMenu/winMenu/blyCentro");
    	blyCentro.getChildren().clear();
    	Executions.createComponents(formulario, blyCentro, null);
	}

	/*
	 * Metodo que devuelve un Srting dado un int.
	 */
	public static String parseString(int parametro){
		String valor="";
		try{
			valor = String.valueOf(parametro);
		}catch(Exception e){
			valor = "";
		}
		return valor;
	}
	/*
	 * Metodo que devuelve un Srting dado un int.
	 */

	public static String parseString(long parametro){
		String valor="";
		try{
			valor = String.valueOf(parametro);
		}catch(Exception e){
			valor = "";
		}
		return valor;
	}

	/**
	 * Selecciona el item dentro del Listbox mediante el id especificado 
	 * @param lbx (org.zkoss.zul.Listbox, Objeto listbox a explorar)
	 * @param id (String, Dato para comparar con el id del valor del listbox)
	 */
	public static void setPosicionListitem(Listbox lbx, String id){
		int j=0;
		for (Iterator i= lbx.getItems().iterator(); i.hasNext();){
			String strId = ((Listitem)i.next()).getValue().toString();
			if ( id.equals(strId) ) break;
			j++;
		}
		if (lbx.getItems().size()>0)
			lbx.setSelectedIndex(j);
	}

	public static void setPosicionPrimerItem(Listbox lbx){
		if (lbx.getItems().size()>0)
			lbx.setSelectedIndex(0);
	}
	
	/**
	 * Convierte un String a tipo primitivo Date 
	 * @param strValor (String, Cadena a convetir)
	 * @return valor (date, valor convertido)
	 */
	public static BigDecimal parseBigDecimal(String strValor){
		BigDecimal valor=null;
		try{
			valor = new BigDecimal(strValor); 
		}catch(Exception e){
			valor = null;
		}
		return valor;
	}

	

	
	
	//TODO 0 CODIGO REDUNDANTE?
	public static Long getIdProduccionLimpiezaProceso(){
		LimpiezaProceso limpiezaproceso = new LimpiezaProceso();
		limpiezaproceso = new ProcesoAperturaCierreDAOJpaImpl().getSeleccionProcesoAperturaFechaProduccionActivaCierreLimpieza();
		
		return limpiezaproceso.getProduccion().getIdproduccion();
	}

	public static String getEjecucionPorUsuario(String formulario){
		String ip = Sessions.getCurrent().getRemoteAddr();
		String usuario = Sessions.getCurrent().getAttribute("usuario").toString();
		return "***"+formulario + "*** ejecutado por: "+usuario +", desde la terminal: "+ ip+" a las "+new Fecha(new Date()).strGetFecha();
	}

	/**
	 * Devuelve la ruta relativa a la aplicación desplegada del logo de Nirsa
	 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
	 * 2014-01-08
	 * @return
	 */
	public static String getRutaLogoNirsa(){
		return Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"logo_nirsa.gif";
	}
	

	public static String getRutaReporte(String nombreReporte){
		return Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombreReporte;
	}

	/**
	 * Rutina para mostrar el reporte
	 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
	 * 2014-01-08
	 * @param parameters
	 * @param ruta_report
	 * @throws JRException
	 * @throws SuspendNotAllowedException
	 * @throws InterruptedException
	 */
	public static void EjecutarReporte(Map parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException {			
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

	/**
	 * Agregar un listitem en blanco a un Listbox especificado
	 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
	 * 2014-01-08
	 * 
	 * @param lbx
	 */
	public static void agregarListitemEnBlanco(Listbox lbx){
		Listitem listitem = new Listitem();
		listitem.setParent(lbx);
	}


    /**
     * Devuelve un objeto Timestamp de acuerdo a la fecha de tipo String ingresada
	 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
     * @param fecha
     * @return
     */
    public static Timestamp getFecha(String fecha){
    	Timestamp valor = null;
		try {
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(fecha);
			valor = new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valor;
    }
    
    

	public static boolean isNumeric(String cadena)
	{
		  try {
		         Integer.parseInt(cadena);
		         return true;
			  } catch (NumberFormatException nfe){
			         return false;
			  }
	}    
	
	
	public static boolean isDouble(String cadena)
	{
		  try {
		         Double.parseDouble(cadena);
		         return true;
			  } catch (NumberFormatException nfe){
			         return false;
			  }
	}	
	
	
	

	@SuppressWarnings("deprecation")
	public static Listbox  Selecionar_mes(Listbox lbx, Timestamp fecha)
	{		
		
		int mes = 0;
		if (fecha == null)
		{
			mes = new Timestamp(new Date().getTime()).getMonth()+1;	
		}
		else
		{
			mes = fecha.getMonth()+1;
		}

		lbx.setSelectedIndex(mes);
		
		return lbx;
	}

	
	public static Listbox Selecionar_dia(Listbox lbxDi, Timestamp fecha, int restar)
	{
		
		DateFormat dateFormata = new SimpleDateFormat("yyyy");				
		Integer anoactual = Integer.valueOf(dateFormata.format(new Timestamp(fecha.getTime())));

		@SuppressWarnings("deprecation")
		int mes = new Timestamp(new Date().getTime()).getMonth()+1;
		lbxDi = cargarDias(lbxDi, diasDelMes(mes, anoactual));

		DateFormat dateFormatd = new SimpleDateFormat("dd");
		dateFormatd = new SimpleDateFormat("dd");
		

//		if(restar == 1)
//		{
//		  //Dejamos seleccionada el dia segun laa fecha receotada
//		  lbxDi.setSelectedIndex(Integer.valueOf(dateFormatd.format(new Timestamp(fecha.getTime())))-1);	
//		}
//		else
//		{
			  //Dejamos seleccionada el dia segun laa fecha receotada
			  lbxDi.setSelectedIndex(Integer.valueOf(dateFormatd.format(new Timestamp(fecha.getTime()))));	
//		}
		
		
		return lbxDi;
	}

	
	@SuppressWarnings("deprecation")
	public static Listbox Selecionar_hora(Listbox lbxH, Timestamp fecha)
	{
		lbxH.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxH);
		int i;
		for (i=0; i<=24; i++)
		{
			Listitem li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxH);
		}
		
		lbxH.setSelectedIndex(new Timestamp(fecha.getTime()).getHours()+1);
		
		return lbxH;
	}	
	
	

	public static Listbox Selecionar_minuto(Listbox lbxMi, Timestamp fecha, int selectmin59)
	{
		lbxMi.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxMi);
		int i;
		for (i=0; i<=59; i++)
		{
			Listitem li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxMi);
		}
		
		lbxMi.setSelectedIndex(new Timestamp(fecha.getTime()).getMinutes()+1);
		
		//Verifica envio el minuto 0 para dejar seleccionado el minuto 59
		if (selectmin59 == 1)
		{
			lbxMi.setSelectedIndex(60);
		}

		
		return lbxMi;		
	}	
		
	
	
	
	public static Listbox cargarDias(Listbox lbxD, int dias)
	{
		lbxD.getItems().clear();
		int i;

		Listitem li = new Listitem();
		li.setValue("");
		new Listcell(String.valueOf("")).setParent(li);
		li.setParent(lbxD);
		
		for (i=1; i<=dias; i++)
		{
			li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxD);
		}
		return lbxD;
	}	
	
	public static int diasDelMes(int mes, int ano)
	{
		switch(mes)
		{
			case 1:  // Enero
			case 3:  // Marzo
			case 5:  // Mayo
			case 7:  // Julio
			case 8:  // Agosto
			case 10:  // Octubre
			case 12: // Diciembre
			return 31;
			
			case 4:  // Abril
			case 6:  // Junio
			case 9:  // Septiembre
			case 11: // Noviembre
			return 30;
			
			case 2:  // Febrero
			if ( ((ano%100 == 0) && (ano%400 == 0)) || ((ano%100 != 0) && (ano%  4 == 0))  )
			return 29;  // Año Bisiesto
			else
			return 28;
		}
		return 0;
	}	

	
//	public static Timestamp sumar_tiempo_Timestamp(Timestamp fecha, int minutos)
//	{
//	    Calendar calendar = Calendar.getInstance();
//	    calendar.setTime(fecha);
//	    calendar.add(Calendar.MINUTE, minutos);	    
//	    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());		
//	    return timestamp;
//	}	
	
	public static Timestamp sumar_tiempo_Timestamp(Timestamp fecha, int horas)
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha);
	    calendar.add(Calendar.HOUR, horas);
	    
	    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());		
	    return timestamp;
	}
	
	public static Timestamp sumar_tiempo_Timestamp_minutos(Timestamp fecha, int horas, int minutos)
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha);
	    calendar.add(Calendar.HOUR, horas);
	    calendar.add(Calendar.MINUTE, minutos);
	    
	    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());		
	    return timestamp;
	}
	
	
	
	public static void notificar_pcc3(double temperatura, String Area, String cocinada)
	{
		try {
			//Validamos que la temperatura no este por debajo de la temperatura minima establecida
			if(temperatura < new PccParametroDAOJpaImpl().getPccParametroById(4).getTemperatura())
			{							
				String titulo = "NW - Alarma PCC3 ALERTA";
				String mensaje = "Notificación de alarma PCC3, temperatura "+ String.valueOf(temperatura) +" Cocinada "+ cocinada +" fuera de parámetro (ALERTA) - "+Area;
				new EmailUtil().EnviarCorreo(mensaje, titulo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	
 

 
}
