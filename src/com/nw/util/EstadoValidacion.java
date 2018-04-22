package com.nw.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author crholguin
 * Objeto de resultado aplicable a cualquier proceso q se requiera validar
 */
public class EstadoValidacion <T> {

	private Boolean 		estado;
	private String  		mensaje;
	private Object  		objeto;
	private List<T>    listaObjetos = new ArrayList<T>();
	
	public EstadoValidacion() {
		 
	}
	
    public EstadoValidacion(List<T> entityClass) {
        this.listaObjetos = entityClass;
    }
	
	public EstadoValidacion(Boolean estado,String mensaje ) {
		 this.estado  = estado;
		 this.mensaje = mensaje;
	}
	
	public EstadoValidacion(Boolean estado ,
							String mensaje ,
			                Object  objeto ,
			                List<T> 	listaObjetos) {
		 this.estado       = estado;
		 this.mensaje      = mensaje;
		 this.objeto  	   = objeto;
		 this.listaObjetos = listaObjetos;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public List<T> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(List<T> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}
	
}
