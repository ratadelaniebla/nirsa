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
public class LimpiezaCabeceraCortesPlanta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezacabeceracortesplanta;

	private Timestamp fechareg;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaDetalleCortesPlanta
	@OneToMany(mappedBy="limpiezaCabeceraCortesPlanta")
	private List<LimpiezaDetalleCortesPlanta> limpiezaDetalleCortesPlantas;

	public LimpiezaCabeceraCortesPlanta() {
	}

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

	public List<LimpiezaDetalleCortesPlanta> getLimpiezaDetalleCortesPlantas() {
		return this.limpiezaDetalleCortesPlantas;
	}

	public void setLimpiezaDetalleCortesPlantas(List<LimpiezaDetalleCortesPlanta> limpiezaDetalleCortesPlantas) {
		this.limpiezaDetalleCortesPlantas = limpiezaDetalleCortesPlantas;
	}

}