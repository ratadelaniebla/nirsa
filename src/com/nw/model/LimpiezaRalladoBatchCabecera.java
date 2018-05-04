package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_rallado_batch_cabecera database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_batch_cabecera")
@NamedQuery(name="LimpiezaRalladoBatchCabecera.findAll", query="SELECT l FROM LimpiezaRalladoBatchCabecera l")
public class LimpiezaRalladoBatchCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaralladobatchcabecera;
	private Integer batch;
	private Integer estado;
	private Timestamp fechareg;
	private Integer tipo;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;
	private List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles;
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;

	public LimpiezaRalladoBatchCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaralladobatchcabecera() {
		return this.idlimpiezaralladobatchcabecera;
	}

	public void setIdlimpiezaralladobatchcabecera(Long idlimpiezaralladobatchcabecera) {
		this.idlimpiezaralladobatchcabecera = idlimpiezaralladobatchcabecera;
	}


	public Integer getBatch() {
		return this.batch;
	}

	public void setBatch(Integer batch) {
		this.batch = batch;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to LimpiezaRalladoBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoBatchCabecera")
	public List<LimpiezaRalladoBatchDetalle> getLimpiezaRalladoBatchDetalles() {
		return this.limpiezaRalladoBatchDetalles;
	}

	public void setLimpiezaRalladoBatchDetalles(List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles) {
		this.limpiezaRalladoBatchDetalles = limpiezaRalladoBatchDetalles;
	}

	public LimpiezaRalladoBatchDetalle addLimpiezaRalladoBatchDetalle(LimpiezaRalladoBatchDetalle limpiezaRalladoBatchDetalle) {
		getLimpiezaRalladoBatchDetalles().add(limpiezaRalladoBatchDetalle);
		limpiezaRalladoBatchDetalle.setLimpiezaRalladoBatchCabecera(this);

		return limpiezaRalladoBatchDetalle;
	}

	public LimpiezaRalladoBatchDetalle removeLimpiezaRalladoBatchDetalle(LimpiezaRalladoBatchDetalle limpiezaRalladoBatchDetalle) {
		getLimpiezaRalladoBatchDetalles().remove(limpiezaRalladoBatchDetalle);
		limpiezaRalladoBatchDetalle.setLimpiezaRalladoBatchCabecera(null);

		return limpiezaRalladoBatchDetalle;
	}


	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoBatchCabecera")
	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

	public LimpiezaRalladoMezclaBatchDetalle addLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().add(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setLimpiezaRalladoBatchCabecera(this);

		return limpiezaRalladoMezclaBatchDetalle;
	}

	public LimpiezaRalladoMezclaBatchDetalle removeLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().remove(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setLimpiezaRalladoBatchCabecera(null);

		return limpiezaRalladoMezclaBatchDetalle;
	}

}