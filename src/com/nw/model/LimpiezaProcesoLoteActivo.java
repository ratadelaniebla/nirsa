package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_proceso_lote_activo database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_lote_activo")
public class LimpiezaProcesoLoteActivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaprocesoloteactivo;

	private Boolean ajustado;

	private Integer estado;

	private Timestamp fechareg;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoLoteActivo")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoLoteActivo")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="limpiezaProcesoLoteActivo")
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaProcesoLoteActivo() {
	}

	public Long getIdlimpiezaprocesoloteactivo() {
		return this.idlimpiezaprocesoloteactivo;
	}

	public void setIdlimpiezaprocesoloteactivo(Long idlimpiezaprocesoloteactivo) {
		this.idlimpiezaprocesoloteactivo = idlimpiezaprocesoloteactivo;
	}

	public Boolean getAjustado() {
		return this.ajustado;
	}

	public void setAjustado(Boolean ajustado) {
		this.ajustado = ajustado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}