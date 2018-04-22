package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the harina_comprobante_detalle_grupo_especie database table.
 * 
 */
@Entity
@Table(name="harina_comprobante_detalle_grupo_especie")
public class HarinaComprobanteDetalleGrupoEspecie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinacomprobantedetallegrupoespecie;

	private Integer numerogabetas;

	private double porcentaje;

	//bi-directional many-to-one association to HarinaGrupoEspecie
	@ManyToOne
	@JoinColumn(name="idharinagrupoespecie")
	private HarinaGrupoEspecie harinaGrupoEspecie;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@ManyToOne
	@JoinColumn(name="idharinarecepcionpescacomprobante")
	private HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante;

	public HarinaComprobanteDetalleGrupoEspecie() {
	}

	public Long getIdharinacomprobantedetallegrupoespecie() {
		return this.idharinacomprobantedetallegrupoespecie;
	}

	public void setIdharinacomprobantedetallegrupoespecie(Long idharinacomprobantedetallegrupoespecie) {
		this.idharinacomprobantedetallegrupoespecie = idharinacomprobantedetallegrupoespecie;
	}

	public Integer getNumerogabetas() {
		return this.numerogabetas;
	}

	public void setNumerogabetas(Integer numerogabetas) {
		this.numerogabetas = numerogabetas;
	}

	public double getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public HarinaGrupoEspecie getHarinaGrupoEspecie() {
		return this.harinaGrupoEspecie;
	}

	public void setHarinaGrupoEspecie(HarinaGrupoEspecie harinaGrupoEspecie) {
		this.harinaGrupoEspecie = harinaGrupoEspecie;
	}

	public HarinaRecepcionPescaComprobante getHarinaRecepcionPescaComprobante() {
		return this.harinaRecepcionPescaComprobante;
	}

	public void setHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		this.harinaRecepcionPescaComprobante = harinaRecepcionPescaComprobante;
	}

}