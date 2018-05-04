package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the lonjas_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="lonjas_detalle_proceso_coche")
@NamedQuery(name="LonjasDetalleProcesoCoche.findAll", query="SELECT l FROM LonjasDetalleProcesoCoche l")
public class LonjasDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasdetalleprocesocoche;
	private Integer estado;
	private Timestamp fecharegistro;
	private LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoche;
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;
	private LonjasLinea lonjasLinea;
	private LonjasProceso lonjasProceso;
	private Usuario usuario;

	public LonjasDetalleProcesoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlonjasdetalleprocesocoche() {
		return this.idlonjasdetalleprocesocoche;
	}

	public void setIdlonjasdetalleprocesocoche(Long idlonjasdetalleprocesocoche) {
		this.idlonjasdetalleprocesocoche = idlonjasdetalleprocesocoche;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}


	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezalomolimpiocoche")
	public LimpiezaLomoLimpioCoche getLimpiezaLomoLimpioCoche() {
		return this.limpiezaLomoLimpioCoche;
	}

	public void setLimpiezaLomoLimpioCoche(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoche) {
		this.limpiezaLomoLimpioCoche = limpiezaLomoLimpioCoche;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}


	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
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