package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the envasado_detalle_proceso_cambios_luthy database table.
 * 
 */
@Entity
@Table(name="envasado_detalle_proceso_cambios_luthy")
@NamedQuery(name="EnvasadoDetalleProcesoCambiosLuthy.findAll", query="SELECT e FROM EnvasadoDetalleProcesoCambiosLuthy e")
public class EnvasadoDetalleProcesoCambiosLuthy implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadodetalleprocesocambiosluthy;
	private EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio;
	private Luthy luthy;

	public EnvasadoDetalleProcesoCambiosLuthy() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadodetalleprocesocambiosluthy() {
		return this.idenvasadodetalleprocesocambiosluthy;
	}

	public void setIdenvasadodetalleprocesocambiosluthy(Long idenvasadodetalleprocesocambiosluthy) {
		this.idenvasadodetalleprocesocambiosluthy = idenvasadodetalleprocesocambiosluthy;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@ManyToOne
	@JoinColumn(name="idenvasadodetalleprocesocambios")
	public EnvasadoDetalleProcesoCambio getEnvasadoDetalleProcesoCambio() {
		return this.envasadoDetalleProcesoCambio;
	}

	public void setEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		this.envasadoDetalleProcesoCambio = envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}

}