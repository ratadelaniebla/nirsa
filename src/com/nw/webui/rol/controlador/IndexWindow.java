package com.nw.webui.rol.controlador;

import java.util.Date;

import org.zkoss.zk.ui.*;
import org.zkoss.zul.*;
import org.apache.commons.logging.*; 

import com.avante.core.webui.util.GFCBaseCtrl;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;

import com.nw.util.*;


public class IndexWindow extends GFCBaseCtrl{
	
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(IndexWindow.class);
	private int i=0;
	private String strUsuario, strClave;
	public AreaMarco area;
	protected Window indexWindow; // autowired
	protected Textbox txtUsuario; // autowire
	protected Textbox txtClave; // autowire
	
	public IndexWindow() {
		super();

		if (log.isDebugEnabled()) {
			log.debug("--> super()");
		}
	}
	
	public void onCreate(){
		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		indexWindow.setWidth(area.ancho);
	}

	public void onOK(){
		try{
			
			strUsuario = txtUsuario.getValue().toLowerCase();
			strClave = txtClave.getValue();
			
			//Usuario u1 = new Usuario();
			//Usuario u2 = getUsuarioDAO().getUser(strUsuario);
			//List l = getWmService().getOpcionesAsignadas(strUsuario);
			//List keyapps = new JPAPersistenceManager().
			Usuario u = new UsuarioDAOJpaImpl().getUser(strUsuario);
			
			if (u == null)
			{
				
				Sistema.mensaje("Usuario/clave incorrecta 1");
				
				i++;
				if (i==3)
				{
					//i = 0;
					Sistema.terminarSesion();
				}
				return;
			}
			
			//Validamos que el objeto no este anulado
			if (u != null)
			{				
				//System.out.println("Esta en la clave :"+u.getClave());
				
				if( ! u.getClave().equalsIgnoreCase(strClave) )
				{
					Sistema.mensaje("Usuario/clave incorrecta 2");
					i++;
					if (i==3)
					{
						//i = 0;
						Sistema.terminarSesion();					
						
					}
				return;	
				}				
			}

			
//			try {
//				if(u.getClave() == null)
//				{
//					Sistema.mensaje("Usuario/clave incorrecta");
//					i++;
//					if (i==3)
//					{
//						i = 0;
//						Sistema.terminarSesion();
//						return;
//					}
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//				Sistema.mensaje("Usuario/clave incorrecta");
//				i++;
//				if (i==3)
//				{
//					i = 0;
//					Sistema.terminarSesion();					
//					return;
//				}
//			}

				
				
			
			//if(u.getClave().equals(strClave) == false)
			if( ! u.getClave().equalsIgnoreCase(strClave) )
			{
				Sistema.mensaje("Usuario/clave incorrecta 3");
				i++;
				if (i==3)
				{
					//i = 0;
					Sistema.terminarSesion();										
				}
				return;
			}
			else
			{
				String ip = Sessions.getCurrent().getRemoteAddr();
				Sessions.getCurrent().setAttribute("usuario", strUsuario);
				//Sessions.getCurrent().setAttribute("grupo", Short.toString(u.getGrupo().getIidGrupo()));
				Sessions.getCurrent().setAttribute("conexion", ip+" "+new Fecha(new Date()).strGetFecha() );
				log.warn("Login: "+ip+" "+strUsuario);
				Executions.sendRedirect("menu.zul");
			}
			
		}catch(Exception e) {
			Sistema.mensaje(e);
			Sistema.mensaje("Usuario/clave incorrecta.....4");
			i++;
			if (i==3)
			{
				//i = 0;
				Sistema.terminarSesion();				
				
			}
			return;
		}
	}


	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	// ++++++++++++++++++ getter / setter +++++++++++++++++++//
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	



}
