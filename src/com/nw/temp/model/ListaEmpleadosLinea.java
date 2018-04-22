package com.nw.temp.model;

import com.nw.model.Empleado;
import com.nw.model.LimpiezaLineaGrupo;

public class ListaEmpleadosLinea 
{

	private Long idempleado;
	private Integer ubicacion;
	private String cargo;
	private Integer linea;
	private String tarjeta;
	private boolean eliminar = false;
	private String nombre;
	private Empleado empleado = new Empleado();
	private LimpiezaLineaGrupo limpiezaLineaGrupo = new LimpiezaLineaGrupo();
	private String disponible;
	private String marco;

	public String getMarco() {
		return marco;
	}

	public void setMarco(String marco) {
		this.marco = marco;
	}

	public ListaEmpleadosLinea() {
	}

	public ListaEmpleadosLinea(Long idempleado, Integer ubicacion, String cargo, Integer linea, String tarjeta, boolean eliminar, String nombre, Empleado empleado, LimpiezaLineaGrupo limpiezaLineaGrupo, String disponible) 
	{
		this.setIdempleado(idempleado);
		this.setUbicacion(ubicacion);
		this.setCargo(cargo);
		this.setLinea(linea);
		this.setTarjeta(tarjeta);
		this.setEliminar(eliminar);
		this.setNombre(nombre);		
		this.setEmpleado(empleado);		
		this.setLimpiezaLineaGrupo(limpiezaLineaGrupo);
		this.setDisponible(disponible);
	}

	
	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getLinea() {
		return linea;
	}

	public void setLinea(Integer linea) {
		this.linea = linea;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LimpiezaLineaGrupo getLimpiezaLineaGrupo() {
		return limpiezaLineaGrupo;
	}

	public void setLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		this.limpiezaLineaGrupo = limpiezaLineaGrupo;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	
}
