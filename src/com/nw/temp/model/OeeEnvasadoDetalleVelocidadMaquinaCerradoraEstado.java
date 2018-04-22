package com.nw.temp.model;

 
import com.nw.model.OeeEnvasadoDetalleVelocidadMaquinaCerradora;

public class OeeEnvasadoDetalleVelocidadMaquinaCerradoraEstado {

	private OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	private boolean seleccionado;
	private boolean estado;
	
	public OeeEnvasadoDetalleVelocidadMaquinaCerradoraEstado(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora ,
															boolean seleccionado , boolean estado) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradora        = oeeEnvasadoDetalleVelocidadMaquinaCerradora;
		this.seleccionado 								        = seleccionado;
		this.estado 										    =  estado;
	}


	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora getOeeEnvasadoDetalleVelocidadMaquinaCerradora() {
		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}



	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradora(
			OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradora = oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
