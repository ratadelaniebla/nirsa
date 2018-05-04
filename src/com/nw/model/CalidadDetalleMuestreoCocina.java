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
@NamedQuery(name="CalidadDetalleMuestreoCocina.findAll", query="SELECT c FROM CalidadDetalleMuestreoCocina c")
public class CalidadDetalleMuestreoCocina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidaddetallemuestreococina;
	private Timestamp fechaRegActualizacion;
	private Timestamp fechareg;
	private double histamina;
	private double humedad;
	private Integer nummuestralote;
	private double salinidad;
	private String usuarioActualizacion;
	private CalidadMuestreoCocina calidadMuestreoCocina;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private Turno turno;
	private Usuario usuario;

	public CalidadDetalleMuestreoCocina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidaddetallemuestreococina() {
		return this.idcalidaddetallemuestreococina;
	}

	public void setIdcalidaddetallemuestreococina(Long idcalidaddetallemuestreococina) {
		this.idcalidaddetallemuestreococina = idcalidaddetallemuestreococina;
	}


	@Column(name="fecha_reg_actualizacion")
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


	@Column(name="usuario_actualizacion")
	public String getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}


	//bi-directional many-to-one association to CalidadMuestreoCocina
	@ManyToOne
	@JoinColumn(name="idcalidadmuestreococina")
	public CalidadMuestreoCocina getCalidadMuestreoCocina() {
		return this.calidadMuestreoCocina;
	}

	public void setCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		this.calidadMuestreoCocina = calidadMuestreoCocina;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
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
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}