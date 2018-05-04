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
@NamedQuery(name="HarinaEspecie.findAll", query="SELECT h FROM HarinaEspecie h")
public class HarinaEspecie implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idharinaespecie;
	private String codigosap;
	private String descripcionespecie;
	private Integer estado;
	private List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	private List<HarinaGrupoEspecie> harinaGrupoEspecies;
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	public HarinaEspecie() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to HarinaDetalleEspeceRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaEspecie")
	public List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> getHarinaDetalleEspeceRecepcionDetallePescaComprobantes() {
		return this.harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobantes(List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobantes = harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante addHarinaDetalleEspeceRecepcionDetallePescaComprobante(HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante) {
		getHarinaDetalleEspeceRecepcionDetallePescaComprobantes().add(harinaDetalleEspeceRecepcionDetallePescaComprobante);
		harinaDetalleEspeceRecepcionDetallePescaComprobante.setHarinaEspecie(this);

		return harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante removeHarinaDetalleEspeceRecepcionDetallePescaComprobante(HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante) {
		getHarinaDetalleEspeceRecepcionDetallePescaComprobantes().remove(harinaDetalleEspeceRecepcionDetallePescaComprobante);
		harinaDetalleEspeceRecepcionDetallePescaComprobante.setHarinaEspecie(null);

		return harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}


	//bi-directional many-to-one association to HarinaGrupoEspecie
	@OneToMany(mappedBy="harinaEspecie")
	public List<HarinaGrupoEspecie> getHarinaGrupoEspecies() {
		return this.harinaGrupoEspecies;
	}

	public void setHarinaGrupoEspecies(List<HarinaGrupoEspecie> harinaGrupoEspecies) {
		this.harinaGrupoEspecies = harinaGrupoEspecies;
	}

	public HarinaGrupoEspecie addHarinaGrupoEspecy(HarinaGrupoEspecie harinaGrupoEspecy) {
		getHarinaGrupoEspecies().add(harinaGrupoEspecy);
		harinaGrupoEspecy.setHarinaEspecie(this);

		return harinaGrupoEspecy;
	}

	public HarinaGrupoEspecie removeHarinaGrupoEspecy(HarinaGrupoEspecie harinaGrupoEspecy) {
		getHarinaGrupoEspecies().remove(harinaGrupoEspecy);
		harinaGrupoEspecy.setHarinaEspecie(null);

		return harinaGrupoEspecy;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaEspecie")
	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public HarinaRecepcionDetallePescaComprobante addHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().add(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setHarinaEspecie(this);

		return harinaRecepcionDetallePescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante removeHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().remove(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setHarinaEspecie(null);

		return harinaRecepcionDetallePescaComprobante;
	}

}