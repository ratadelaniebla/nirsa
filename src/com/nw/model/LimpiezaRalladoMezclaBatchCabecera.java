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
@NamedQuery(name="LimpiezaRalladoMezclaBatchCabecera.findAll", query="SELECT l FROM LimpiezaRalladoMezclaBatchCabecera l")
public class LimpiezaRalladoMezclaBatchCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaralladomezclabatchcabecera;
	private Timestamp fechareg;
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;
	private Usuario usuario;
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;

	public LimpiezaRalladoMezclaBatchCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="limpiezaRalladoMezclaBatchCabecera")
	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

	public LimpiezaRalladoGabetaMezclaBatch addLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().add(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setLimpiezaRalladoMezclaBatchCabecera(this);

		return limpiezaRalladoGabetaMezclaBatch;
	}

	public LimpiezaRalladoGabetaMezclaBatch removeLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().remove(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setLimpiezaRalladoMezclaBatchCabecera(null);

		return limpiezaRalladoGabetaMezclaBatch;
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


	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoMezclaBatchCabecera")
	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

	public LimpiezaRalladoMezclaBatchDetalle addLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().add(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setLimpiezaRalladoMezclaBatchCabecera(this);

		return limpiezaRalladoMezclaBatchDetalle;
	}

	public LimpiezaRalladoMezclaBatchDetalle removeLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().remove(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setLimpiezaRalladoMezclaBatchCabecera(null);

		return limpiezaRalladoMezclaBatchDetalle;
	}

}