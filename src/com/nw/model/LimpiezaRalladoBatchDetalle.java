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
@NamedQuery(name="LimpiezaRalladoBatchDetalle.findAll", query="SELECT l FROM LimpiezaRalladoBatchDetalle l")
public class LimpiezaRalladoBatchDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaralladobatchdetalle;
	private Timestamp fechareg;
	private LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera;
	private LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso;
	private Usuario usuario;

	public LimpiezaRalladoBatchDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladobatchcabecera")
	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabecera() {
		return this.limpiezaRalladoBatchCabecera;
	}

	public void setLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		this.limpiezaRalladoBatchCabecera = limpiezaRalladoBatchCabecera;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladodetallepesos")
	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePeso() {
		return this.limpiezaRalladoDetallePeso;
	}

	public void setLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		this.limpiezaRalladoDetallePeso = limpiezaRalladoDetallePeso;
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