package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_cabecera_cortes_planta database table.
 * 
 */
@Entity
@Table(name="limpieza_cabecera_cortes_planta")
@NamedQuery(name="LimpiezaCabeceraCortesPlanta.findAll", query="SELECT l FROM LimpiezaCabeceraCortesPlanta l")
public class LimpiezaCabeceraCortesPlanta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezacabeceracortesplanta;
	private Timestamp fechareg;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;
	private List<LimpiezaDetalleCortesPlanta> limpiezaDetalleCortesPlantas;

	public LimpiezaCabeceraCortesPlanta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezacabeceracortesplanta() {
		return this.idlimpiezacabeceracortesplanta;
	}

	public void setIdlimpiezacabeceracortesplanta(Long idlimpiezacabeceracortesplanta) {
		this.idlimpiezacabeceracortesplanta = idlimpiezacabeceracortesplanta;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
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


	//bi-directional many-to-one association to LimpiezaDetalleCortesPlanta
	@OneToMany(mappedBy="limpiezaCabeceraCortesPlanta")
	public List<LimpiezaDetalleCortesPlanta> getLimpiezaDetalleCortesPlantas() {
		return this.limpiezaDetalleCortesPlantas;
	}

	public void setLimpiezaDetalleCortesPlantas(List<LimpiezaDetalleCortesPlanta> limpiezaDetalleCortesPlantas) {
		this.limpiezaDetalleCortesPlantas = limpiezaDetalleCortesPlantas;
	}

	public LimpiezaDetalleCortesPlanta addLimpiezaDetalleCortesPlanta(LimpiezaDetalleCortesPlanta limpiezaDetalleCortesPlanta) {
		getLimpiezaDetalleCortesPlantas().add(limpiezaDetalleCortesPlanta);
		limpiezaDetalleCortesPlanta.setLimpiezaCabeceraCortesPlanta(this);

		return limpiezaDetalleCortesPlanta;
	}

	public LimpiezaDetalleCortesPlanta removeLimpiezaDetalleCortesPlanta(LimpiezaDetalleCortesPlanta limpiezaDetalleCortesPlanta) {
		getLimpiezaDetalleCortesPlantas().remove(limpiezaDetalleCortesPlanta);
		limpiezaDetalleCortesPlanta.setLimpiezaCabeceraCortesPlanta(null);

		return limpiezaDetalleCortesPlanta;
	}

}