package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the envasado_tipo_proteina database table.
 * 
 */
@Entity
@Table(name="envasado_tipo_proteina")
public class EnvasadoTipoProteina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadotipoproteina;
	private String descripcion;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;

	public EnvasadoTipoProteina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadotipoproteina() {
		return this.idenvasadotipoproteina;
	}

	public void setIdenvasadotipoproteina(Integer idenvasadotipoproteina) {
		this.idenvasadotipoproteina = idenvasadotipoproteina;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="envasadoTipoProteina")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

}