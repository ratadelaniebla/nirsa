package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the envasado_detalle_proceso_cambios_luthy database table.
 * 
 */
@Entity
@Table(name="envasado_detalle_proceso_cambios_luthy")
public class EnvasadoDetalleProcesoCambiosLuthy implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadodetalleprocesocambiosluthy;
	private Integer idluthy;
	private EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio;

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


	public Integer getIdluthy() {
		return this.idluthy;
	}

	public void setIdluthy(Integer idluthy) {
		this.idluthy = idluthy;
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

}