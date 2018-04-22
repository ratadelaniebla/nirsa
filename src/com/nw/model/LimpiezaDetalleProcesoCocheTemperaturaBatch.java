package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_proceso_coche_temperatura_batch database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_proceso_coche_temperatura_batch")
public class LimpiezaDetalleProcesoCocheTemperaturaBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetalleprocesocochetemperaturabatch;

	private Timestamp fechareg;

	private double temperatura;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesocoche")
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaDetalleProcesoCocheTemperaturaBatch() {
	}

	public Long getIdlimpiezadetalleprocesocochetemperaturabatch() {
		return this.idlimpiezadetalleprocesocochetemperaturabatch;
	}

	public void setIdlimpiezadetalleprocesocochetemperaturabatch(Long idlimpiezadetalleprocesocochetemperaturabatch) {
		this.idlimpiezadetalleprocesocochetemperaturabatch = idlimpiezadetalleprocesocochetemperaturabatch;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}

	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche() {
		return this.limpiezaDetalleProcesoCoche;
	}

	public void setLimpiezaDetalleProcesoCoche(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		this.limpiezaDetalleProcesoCoche = limpiezaDetalleProcesoCoche;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}