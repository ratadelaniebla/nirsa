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
@NamedQuery(name="HarinaGrupoEspecie.findAll", query="SELECT h FROM HarinaGrupoEspecie h")
public class HarinaGrupoEspecie implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idharinagrupoespecie;
	private List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies;
	private HarinaEspecie harinaEspecie;
	private HarinaGrupo harinaGrupo;

	public HarinaGrupoEspecie() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdharinagrupoespecie() {
		return this.idharinagrupoespecie;
	}

	public void setIdharinagrupoespecie(Long idharinagrupoespecie) {
		this.idharinagrupoespecie = idharinagrupoespecie;
	}


	//bi-directional many-to-one association to HarinaComprobanteDetalleGrupoEspecie
	@OneToMany(mappedBy="harinaGrupoEspecie")
	public List<HarinaComprobanteDetalleGrupoEspecie> getHarinaComprobanteDetalleGrupoEspecies() {
		return this.harinaComprobanteDetalleGrupoEspecies;
	}

	public void setHarinaComprobanteDetalleGrupoEspecies(List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies) {
		this.harinaComprobanteDetalleGrupoEspecies = harinaComprobanteDetalleGrupoEspecies;
	}

	public HarinaComprobanteDetalleGrupoEspecie addHarinaComprobanteDetalleGrupoEspecy(HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecy) {
		getHarinaComprobanteDetalleGrupoEspecies().add(harinaComprobanteDetalleGrupoEspecy);
		harinaComprobanteDetalleGrupoEspecy.setHarinaGrupoEspecie(this);

		return harinaComprobanteDetalleGrupoEspecy;
	}

	public HarinaComprobanteDetalleGrupoEspecie removeHarinaComprobanteDetalleGrupoEspecy(HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecy) {
		getHarinaComprobanteDetalleGrupoEspecies().remove(harinaComprobanteDetalleGrupoEspecy);
		harinaComprobanteDetalleGrupoEspecy.setHarinaGrupoEspecie(null);

		return harinaComprobanteDetalleGrupoEspecy;
	}


	//bi-directional many-to-one association to HarinaEspecie
	@ManyToOne
	@JoinColumn(name="idharinaespecie")
	public HarinaEspecie getHarinaEspecie() {
		return this.harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}


	//bi-directional many-to-one association to HarinaGrupo
	@ManyToOne
	@JoinColumn(name="idharinagrupo")
	public HarinaGrupo getHarinaGrupo() {
		return this.harinaGrupo;
	}

	public void setHarinaGrupo(HarinaGrupo harinaGrupo) {
		this.harinaGrupo = harinaGrupo;
	}

}