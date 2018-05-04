package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_coche_modificacion database table.
 * 
 */
@Entity
@Table(name="limpieza_coche_modificacion")
@NamedQuery(name="LimpiezaCocheModificacion.findAll", query="SELECT l FROM LimpiezaCocheModificacion l")
public class LimpiezaCocheModificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezacochemodificacion;
	private Timestamp fechaactualizacion;
	private Timestamp fechareg;
	private Timestamp fecharegtara;
	private String idusuariotara;
	private double peso;
	private double tara;
	private String tipoingreso;
	private String tipoingresotara;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LimpiezaLinea limpiezaLinea;
	private Turno turno;
	private Usuario usuario1;
	private Usuario usuario2;

	public LimpiezaCocheModificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezacochemodificacion() {
		return this.idlimpiezacochemodificacion;
	}

	public void setIdlimpiezacochemodificacion(Long idlimpiezacochemodificacion) {
		this.idlimpiezacochemodificacion = idlimpiezacochemodificacion;
	}


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegtara() {
		return this.fecharegtara;
	}

	public void setFecharegtara(Timestamp fecharegtara) {
		this.fecharegtara = fecharegtara;
	}


	public String getIdusuariotara() {
		return this.idusuariotara;
	}

	public void setIdusuariotara(String idusuariotara) {
		this.idusuariotara = idusuariotara;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}


	public String getTipoingresotara() {
		return this.tipoingresotara;
	}

	public void setTipoingresotara(String tipoingresotara) {
		this.tipoingresotara = tipoingresotara;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="evisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesocoche")
	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche() {
		return this.limpiezaDetalleProcesoCoche;
	}

	public void setLimpiezaDetalleProcesoCoche(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		this.limpiezaDetalleProcesoCoche = limpiezaDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioactualizacion")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}