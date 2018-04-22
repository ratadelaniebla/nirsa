package com.nw.temp.model;

import com.nw.model.HarinaComprobanteDetalleGrupoEspecie;
import com.nw.model.HarinaEspecie;
import com.nw.model.HarinaGrupo;
import com.nw.model.LimpiezaRalladoBatchCabecera;
import com.nw.model.LimpiezaRalladoMezclaBatchCabecera;


public class LimpiezaRalladoMezclaBatchEstado  {


	private LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera;
	private LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera; 
	private Integer batchrallado;
	private String tipo;
	private boolean eliminar;
	
	public LimpiezaRalladoMezclaBatchEstado() 
	{
	}	
	
	
	public LimpiezaRalladoMezclaBatchEstado(LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera, LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera, Integer batchrallado, String tipo, boolean eliminar) 
	{
		this.setLimpiezaRalladoBatchCabecera(limpiezaRalladoBatchCabecera);
		this.setLimpiezaRalladoMezclaBatchCabecera(limpiezaRalladoMezclaBatchCabecera);
		this.setBatchrallado(batchrallado);
		this.setTipo(tipo);
		this.setEliminar(eliminar);		
	}


	public boolean isEliminar() {
		return eliminar;
	}


	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabecera() {
		return limpiezaRalladoBatchCabecera;
	}

	public void setLimpiezaRalladoBatchCabecera(
			LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		this.limpiezaRalladoBatchCabecera = limpiezaRalladoBatchCabecera;
	}

	public Integer getBatchrallado() {
		return batchrallado;
	}

	public void setBatchrallado(Integer batchrallado) {
		this.batchrallado = batchrallado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public LimpiezaRalladoMezclaBatchCabecera getLimpiezaRalladoMezclaBatchCabecera() {
		return limpiezaRalladoMezclaBatchCabecera;
	}


	public void setLimpiezaRalladoMezclaBatchCabecera(
			LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {
		this.limpiezaRalladoMezclaBatchCabecera = limpiezaRalladoMezclaBatchCabecera;
	}






}