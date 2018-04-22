package com.nw.temp.model;

import com.nw.model.CocinaProcesoControlEspinaDetalle;
import com.nw.model.CocinaProcesoTipoTemperatura;
 

/**
 * Esta clase personalizada permite seleccionar los item para eliminarlos 
 * segun los que se escojan y ademas permitira saber si son datos provenientes de la base de datos 
 * o si son nuevos y  con esto puedo determinar lo q tengo q modificar o guardar
 */
public class CocinaProcesoControlEspinaDetalleEstado {

	
	private CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle; 
	private boolean estadoEspina;
	private boolean eliminarEspina;
	private CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura;	
	
	public CocinaProcesoControlEspinaDetalleEstado() {
	 
	}
	
	public CocinaProcesoControlEspinaDetalleEstado( CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle, boolean estadoEspina , boolean eliminarEspina, CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura) 
	{
	 this.cocinaProcesoControlEspinaDetalle = cocinaProcesoControlEspinaDetalle;
	 this.estadoEspina = estadoEspina;
	 this.eliminarEspina = eliminarEspina;
	 this.setCocinaProcesoTipoTemperatura(cocinaProcesoTipoTemperatura);
		
	}

	public CocinaProcesoControlEspinaDetalle getCocinaProcesoControlEspinaDetalle() {
		return cocinaProcesoControlEspinaDetalle;
	}

	public void setCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		this.cocinaProcesoControlEspinaDetalle = cocinaProcesoControlEspinaDetalle;
	}

	public boolean isEstadoEspina() {
		return estadoEspina;
	}


	public void setEstadoEspina(boolean estadoEspina) {
		this.estadoEspina = estadoEspina;
	}


	public boolean isEliminarEspina() {
		return eliminarEspina;
	}


	public void setEliminarEspina(boolean eliminarEspina) {
		this.eliminarEspina = eliminarEspina;
	}

	public CocinaProcesoTipoTemperatura getCocinaProcesoTipoTemperatura() {
		return cocinaProcesoTipoTemperatura;
	}

	public void setCocinaProcesoTipoTemperatura(
			CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura) {
		this.cocinaProcesoTipoTemperatura = cocinaProcesoTipoTemperatura;
	}

}
