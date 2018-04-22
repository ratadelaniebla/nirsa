package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_tipo_corte database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_tipo_corte")
public class LimpiezaDetalleTipoCorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetalletipocorte;

	private Timestamp horafin;

	private Timestamp horainicio;

	private Integer numeroincialempleados;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to LimpiezaTipoCorte
	@ManyToOne
	@JoinColumn(name="idlimpiezatipocorte")
	private LimpiezaTipoCorte limpiezaTipoCorte;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioactualizacion")
	private Usuario usuario;

	public LimpiezaDetalleTipoCorte() {
	}

	public Long getIdlimpiezadetalletipocorte() {
		return this.idlimpiezadetalletipocorte;
	}

	public void setIdlimpiezadetalletipocorte(Long idlimpiezadetalletipocorte) {
		this.idlimpiezadetalletipocorte = idlimpiezadetalletipocorte;
	}

	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public Integer getNumeroincialempleados() {
		return this.numeroincialempleados;
	}

	public void setNumeroincialempleados(Integer numeroincialempleados) {
		this.numeroincialempleados = numeroincialempleados;
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

	public LimpiezaTipoCorte getLimpiezaTipoCorte() {
		return this.limpiezaTipoCorte;
	}

	public void setLimpiezaTipoCorte(LimpiezaTipoCorte limpiezaTipoCorte) {
		this.limpiezaTipoCorte = limpiezaTipoCorte;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}