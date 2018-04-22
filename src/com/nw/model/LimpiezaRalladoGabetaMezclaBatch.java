package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_rallado_gabeta_mezcla_batch database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_gabeta_mezcla_batch")
public class LimpiezaRalladoGabetaMezclaBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaralladogabetamezclabatch;

	private Timestamp fechareg;

	//bi-directional many-to-one association to ControlFichaBatch
	@ManyToOne
	@JoinColumn(name="idcontrolfichabatch")
	private ControlFichaBatch controlFichaBatch;

	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchCabecera
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladomezclabatchcabecera")
	private LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaRalladoGabetaMezclaBatch() {
	}

	public Long getIdlimpiezaralladogabetamezclabatch() {
		return this.idlimpiezaralladogabetamezclabatch;
	}

	public void setIdlimpiezaralladogabetamezclabatch(Long idlimpiezaralladogabetamezclabatch) {
		this.idlimpiezaralladogabetamezclabatch = idlimpiezaralladogabetamezclabatch;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public ControlFichaBatch getControlFichaBatch() {
		return this.controlFichaBatch;
	}

	public void setControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		this.controlFichaBatch = controlFichaBatch;
	}

	public LimpiezaRalladoMezclaBatchCabecera getLimpiezaRalladoMezclaBatchCabecera() {
		return this.limpiezaRalladoMezclaBatchCabecera;
	}

	public void setLimpiezaRalladoMezclaBatchCabecera(LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {
		this.limpiezaRalladoMezclaBatchCabecera = limpiezaRalladoMezclaBatchCabecera;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}