package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_tipo_para database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_tipo_para")
@NamedQuery(name="LimpiezaDetalleTipoPara.findAll", query="SELECT l FROM LimpiezaDetalleTipoPara l")
public class LimpiezaDetalleTipoPara implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalletipopara;
	private Timestamp horafin;
	private Timestamp horainicio;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;
	private LimpiezaTipoPara limpiezaTipoPara;
	private Usuario usuario;

	public LimpiezaDetalleTipoPara() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetalletipopara() {
		return this.idlimpiezadetalletipopara;
	}

	public void setIdlimpiezadetalletipopara(Long idlimpiezadetalletipopara) {
		this.idlimpiezadetalletipopara = idlimpiezadetalletipopara;
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


	//bi-directional many-to-one association to LimpiezaTipoPara
	@ManyToOne
	@JoinColumn(name="idlimpiezatipopara")
	public LimpiezaTipoPara getLimpiezaTipoPara() {
		return this.limpiezaTipoPara;
	}

	public void setLimpiezaTipoPara(LimpiezaTipoPara limpiezaTipoPara) {
		this.limpiezaTipoPara = limpiezaTipoPara;
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