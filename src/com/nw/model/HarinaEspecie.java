package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the harina_especie database table.
 * 
 */
@Entity
@Table(name="harina_especie")
public class HarinaEspecie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idharinaespecie;

	private String codigosap;

	private String descripcionespecie;

	private Integer estado;

	//bi-directional many-to-one association to HarinaDetalleEspeceRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaEspecie")
	private List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to HarinaGrupoEspecie
	@OneToMany(mappedBy="harinaEspecie")
	private List<HarinaGrupoEspecie> harinaGrupoEspecies;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaEspecie")
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	public HarinaEspecie() {
	}

	public Integer getIdharinaespecie() {
		return this.idharinaespecie;
	}

	public void setIdharinaespecie(Integer idharinaespecie) {
		this.idharinaespecie = idharinaespecie;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getDescripcionespecie() {
		return this.descripcionespecie;
	}

	public void setDescripcionespecie(String descripcionespecie) {
		this.descripcionespecie = descripcionespecie;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> getHarinaDetalleEspeceRecepcionDetallePescaComprobantes() {
		return this.harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobantes(List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobantes = harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public List<HarinaGrupoEspecie> getHarinaGrupoEspecies() {
		return this.harinaGrupoEspecies;
	}

	public void setHarinaGrupoEspecies(List<HarinaGrupoEspecie> harinaGrupoEspecies) {
		this.harinaGrupoEspecies = harinaGrupoEspecies;
	}

	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

}