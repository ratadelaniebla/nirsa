package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_rallado_mezcla_batch_detalle database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_mezcla_batch_detalle")
@NamedQuery(name="LimpiezaRalladoMezclaBatchDetalle.findAll", query="SELECT l FROM LimpiezaRalladoMezclaBatchDetalle l")
public class LimpiezaRalladoMezclaBatchDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaralladomezclabatchdetalle;
	private Timestamp fechareg;
	private LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera;
	private LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera;
	private Usuario usuario;

	public LimpiezaRalladoMezclaBatchDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaralladomezclabatchdetalle() {
		return this.idlimpiezaralladomezclabatchdetalle;
	}

	public void setIdlimpiezaralladomezclabatchdetalle(Long idlimpiezaralladomezclabatchdetalle) {
		this.idlimpiezaralladomezclabatchdetalle = idlimpiezaralladomezclabatchdetalle;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladobatchcabecera")
	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabecera() {
		return this.limpiezaRalladoBatchCabecera;
	}

	public void setLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		this.limpiezaRalladoBatchCabecera = limpiezaRalladoBatchCabecera;
	}


	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchCabecera
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladomezclabatchcabecera")
	public LimpiezaRalladoMezclaBatchCabecera getLimpiezaRalladoMezclaBatchCabecera() {
		return this.limpiezaRalladoMezclaBatchCabecera;
	}

	public void setLimpiezaRalladoMezclaBatchCabecera(LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {
		this.limpiezaRalladoMezclaBatchCabecera = limpiezaRalladoMezclaBatchCabecera;
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

}