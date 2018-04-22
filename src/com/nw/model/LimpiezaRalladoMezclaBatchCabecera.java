package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_rallado_mezcla_batch_cabecera database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_mezcla_batch_cabecera")
public class LimpiezaRalladoMezclaBatchCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaralladomezclabatchcabecera;

	private Timestamp fechareg;

	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="limpiezaRalladoMezclaBatchCabecera")
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoMezclaBatchCabecera")
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;

	public LimpiezaRalladoMezclaBatchCabecera() {
	}

	public Long getIdlimpiezaralladomezclabatchcabecera() {
		return this.idlimpiezaralladomezclabatchcabecera;
	}

	public void setIdlimpiezaralladomezclabatchcabecera(Long idlimpiezaralladomezclabatchcabecera) {
		this.idlimpiezaralladomezclabatchcabecera = idlimpiezaralladomezclabatchcabecera;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

}