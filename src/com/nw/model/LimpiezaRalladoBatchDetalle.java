package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_rallado_batch_detalle database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_batch_detalle")
public class LimpiezaRalladoBatchDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaralladobatchdetalle;

	private Timestamp fechareg;

	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladobatchcabecera")
	private LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera;

	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladodetallepesos")
	private LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaRalladoBatchDetalle() {
	}

	public Long getIdlimpiezaralladobatchdetalle() {
		return this.idlimpiezaralladobatchdetalle;
	}

	public void setIdlimpiezaralladobatchdetalle(Long idlimpiezaralladobatchdetalle) {
		this.idlimpiezaralladobatchdetalle = idlimpiezaralladobatchdetalle;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabecera() {
		return this.limpiezaRalladoBatchCabecera;
	}

	public void setLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		this.limpiezaRalladoBatchCabecera = limpiezaRalladoBatchCabecera;
	}

	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePeso() {
		return this.limpiezaRalladoDetallePeso;
	}

	public void setLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		this.limpiezaRalladoDetallePeso = limpiezaRalladoDetallePeso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}