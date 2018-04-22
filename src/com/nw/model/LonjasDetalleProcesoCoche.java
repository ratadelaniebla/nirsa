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
public class LonjasDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasdetalleprocesocoche;

	private Integer estado;

	private Timestamp fecharegistro;

	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezalomolimpiocoche")
	private LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoche;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;

	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	private LonjasLinea lonjasLinea;

	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	private LonjasProceso lonjasProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LonjasDetalleProcesoCoche() {
	}

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

	public LimpiezaLomoLimpioCoche getLimpiezaLomoLimpioCoche() {
		return this.limpiezaLomoLimpioCoche;
	}

	public void setLimpiezaLomoLimpioCoche(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoche) {
		this.limpiezaLomoLimpioCoche = limpiezaLomoLimpioCoche;
	}

	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}

	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}

	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}