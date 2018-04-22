package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_muestreo_cocina database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_muestreo_cocina")
public class CalidadDetalleMuestreoCocina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddetallemuestreococina;

	@Column(name="fecha_reg_actualizacion")
	private Timestamp fechaRegActualizacion;

	private Timestamp fechareg;

	private double histamina;

	private double humedad;

	private Integer nummuestralote;

	private double salinidad;

	@Column(name="usuario_actualizacion")
	private String usuarioActualizacion;

	//bi-directional many-to-one association to CalidadMuestreoCocina
	@ManyToOne
	@JoinColumn(name="idcalidadmuestreococina")
	private CalidadMuestreoCocina calidadMuestreoCocina;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadDetalleMuestreoCocina() {
	}

	public Long getIdcalidaddetallemuestreococina() {
		return this.idcalidaddetallemuestreococina;
	}

	public void setIdcalidaddetallemuestreococina(Long idcalidaddetallemuestreococina) {
		this.idcalidaddetallemuestreococina = idcalidaddetallemuestreococina;
	}

	public Timestamp getFechaRegActualizacion() {
		return this.fechaRegActualizacion;
	}

	public void setFechaRegActualizacion(Timestamp fechaRegActualizacion) {
		this.fechaRegActualizacion = fechaRegActualizacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getHistamina() {
		return this.histamina;
	}

	public void setHistamina(double histamina) {
		this.histamina = histamina;
	}

	public double getHumedad() {
		return this.humedad;
	}

	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}

	public Integer getNummuestralote() {
		return this.nummuestralote;
	}

	public void setNummuestralote(Integer nummuestralote) {
		this.nummuestralote = nummuestralote;
	}

	public double getSalinidad() {
		return this.salinidad;
	}

	public void setSalinidad(double salinidad) {
		this.salinidad = salinidad;
	}

	public String getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public CalidadMuestreoCocina getCalidadMuestreoCocina() {
		return this.calidadMuestreoCocina;
	}

	public void setCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		this.calidadMuestreoCocina = calidadMuestreoCocina;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}