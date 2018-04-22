package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the harina_grupo_especie database table.
 * 
 */
@Entity
@Table(name="harina_grupo_especie")
public class HarinaGrupoEspecie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinagrupoespecie;

	//bi-directional many-to-one association to HarinaComprobanteDetalleGrupoEspecie
	@OneToMany(mappedBy="harinaGrupoEspecie")
	private List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies;

	//bi-directional many-to-one association to HarinaEspecie
	@ManyToOne
	@JoinColumn(name="idharinaespecie")
	private HarinaEspecie harinaEspecie;

	//bi-directional many-to-one association to HarinaGrupo
	@ManyToOne
	@JoinColumn(name="idharinagrupo")
	private HarinaGrupo harinaGrupo;

	public HarinaGrupoEspecie() {
	}

	public Long getIdharinagrupoespecie() {
		return this.idharinagrupoespecie;
	}

	public void setIdharinagrupoespecie(Long idharinagrupoespecie) {
		this.idharinagrupoespecie = idharinagrupoespecie;
	}

	public List<HarinaComprobanteDetalleGrupoEspecie> getHarinaComprobanteDetalleGrupoEspecies() {
		return this.harinaComprobanteDetalleGrupoEspecies;
	}

	public void setHarinaComprobanteDetalleGrupoEspecies(List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies) {
		this.harinaComprobanteDetalleGrupoEspecies = harinaComprobanteDetalleGrupoEspecies;
	}

	public HarinaEspecie getHarinaEspecie() {
		return this.harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}

	public HarinaGrupo getHarinaGrupo() {
		return this.harinaGrupo;
	}

	public void setHarinaGrupo(HarinaGrupo harinaGrupo) {
		this.harinaGrupo = harinaGrupo;
	}

}