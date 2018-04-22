package com.nw.temp.model;

import java.sql.Timestamp;

import com.nw.model.LimpiezaProceso;


public class LimpiezaDetalleTipoParaEstado {

	private Long idlimpiezadetalletipopara;
	private String descripcion;
	private Timestamp horainicio;
	private Timestamp horafin;
	private boolean eliminar;

	
	
	public LimpiezaDetalleTipoParaEstado() 
	{
	}	
	
	
	public LimpiezaDetalleTipoParaEstado(Long idlimpiezadetalletipopara, String descripcion, Timestamp horainicio, Timestamp horafin, boolean eliminar) 
	{		
	 this.setIdlimpiezadetalletipopara(idlimpiezadetalletipopara);
	 this.setDescripcion(descripcion);
	 this.setHorainicio(horainicio);
	 this.setHorafin(horafin);
	 this.eliminar = eliminar;
	}



	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}





	public Timestamp getHorainicio() {
		return horainicio;
	}


	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}


	public Timestamp getHorafin() {
		return horafin;
	}


	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getIdlimpiezadetalletipopara() {
		return idlimpiezadetalletipopara;
	}


	public void setIdlimpiezadetalletipopara(Long idlimpiezadetalletipopara) {
		this.idlimpiezadetalletipopara = idlimpiezadetalletipopara;
	}


	
	
	
	
}
