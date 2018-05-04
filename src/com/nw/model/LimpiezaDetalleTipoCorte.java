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
@NamedQuery(name="LimpiezaDetalleTipoCorte.findAll", query="SELECT l FROM LimpiezaDetalleTipoCorte l")
public class LimpiezaDetalleTipoCorte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalletipocorte;
	private Timestamp horafin;
	private Timestamp horainicio;
	private Integer numeroincialempleados;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;
	private LimpiezaTipoCorte limpiezaTipoCorte;
	private Usuario usuario;

	public LimpiezaDetalleTipoCorte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
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


	//bi-directional many-to-one association to LimpiezaTipoCorte
	@ManyToOne
	@JoinColumn(name="idlimpiezatipocorte")
	public LimpiezaTipoCorte getLimpiezaTipoCorte() {
		return this.limpiezaTipoCorte;
	}

	public void setLimpiezaTipoCorte(LimpiezaTipoCorte limpiezaTipoCorte) {
		this.limpiezaTipoCorte = limpiezaTipoCorte;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioactualizacion")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}