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
public class LimpiezaRalladoBatchCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaralladobatchcabecera;

	private Integer batch;

	private Integer estado;

	private Timestamp fechareg;

	private Integer tipo;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaRalladoBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoBatchCabecera")
	private List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles;

	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoBatchCabecera")
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;

	public LimpiezaRalladoBatchCabecera() {
	}

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

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaRalladoBatchDetalle> getLimpiezaRalladoBatchDetalles() {
		return this.limpiezaRalladoBatchDetalles;
	}

	public void setLimpiezaRalladoBatchDetalles(List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles) {
		this.limpiezaRalladoBatchDetalles = limpiezaRalladoBatchDetalles;
	}

	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

}