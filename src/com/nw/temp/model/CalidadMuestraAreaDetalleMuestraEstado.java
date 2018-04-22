package com.nw.temp.model;

//import com.nw.model.CalidadMuestraAreaDetalleMuestra;

public class CalidadMuestraAreaDetalleMuestraEstado {

	
	private String  nombre;
	private Integer cantidadmuestra;
	private boolean seleccionado;
	private Integer estado;
	
	public CalidadMuestraAreaDetalleMuestraEstado( String  nombre,  Integer cantidadmuestra,
			boolean seleccionado , Integer estado ) {
        this.nombre 						  = nombre;
        this.cantidadmuestra 				  = cantidadmuestra;
		this.seleccionado 					  = seleccionado;
		this.estado 	  					  = estado;
	}

 

	public boolean getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getCantidadmuestra() {
		return cantidadmuestra;
	}



	public void setCantidadmuestra(Integer cantidadmuestra) {
		this.cantidadmuestra = cantidadmuestra;
	}
	
	
	
}
