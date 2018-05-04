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
@NamedQuery(name="LimpiezaDetalleProcesoCocheTemperaturaBatch.findAll", query="SELECT l FROM LimpiezaDetalleProcesoCocheTemperaturaBatch l")
public class LimpiezaDetalleProcesoCocheTemperaturaBatch implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalleprocesocochetemperaturabatch;
	private Timestamp fechareg;
	private double temperatura;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;
	private Usuario usuario;

	public LimpiezaDetalleProcesoCocheTemperaturaBatch() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
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