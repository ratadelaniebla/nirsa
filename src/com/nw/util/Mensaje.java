package com.nw.util;

 

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.util.Clients;

public class Mensaje {

	static Map<String, String> params = new HashMap<String, String>();
	
	public Mensaje() {
	}
	 
	/*22-08-2017 mensajes con la libreria notify.js */
	
	public static void mensajeNotifyInfo(String mensaje){
		 Clients.evalJavaScript(String.format("mensajeInfo(\"%s\")", mensaje));
	}
	
	public static void mensajeNotifyError(String mensaje){
		 Clients.evalJavaScript(String.format("mensajeError(\"%s\")", mensaje));
	}
	
	public static void mensajeNotifyWarn(String mensaje){
		 Clients.evalJavaScript(String.format("mensajeWarn(\"%s\")", mensaje));
	}
	
	public static void mensajeNotifySuccess(String mensaje){
		 Clients.evalJavaScript(String.format("mensajeSuccess(\"%s\")", mensaje));
	}
	
	
}
