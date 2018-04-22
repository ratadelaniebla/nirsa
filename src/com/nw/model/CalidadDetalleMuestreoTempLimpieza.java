package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_muestreo_temp_limpieza database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_muestreo_temp_limpieza")
public class CalidadDetalleMuestreoTempLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddetallemuestreotemplimpieza;

	private Timestamp fechareg;

	private Timestamp fecharegactualizacion;

	private Integer nummuestralote;

	private double temperatura;

	private String usuarioactualizacion;

	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@ManyToOne
	@JoinColumn(name="idcalidadmuestreotemplimpieza")
	private CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza;

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

	public CalidadDetalleMuestreoTempLimpieza() {
	}

	public Long getIdcalidaddetallemuestreotemplimpieza() {
		return this.idcalidaddetallemuestreotemplimpieza;
	}

	public void setIdcalidaddetallemuestreotemplimpieza(Long idcalidaddetallemuestreotemplimpieza) {
		this.idcalidaddetallemuestreotemplimpieza = idcalidaddetallemuestreotemplimpieza;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}

	public Integer getNummuestralote() {
		return this.nummuestralote;
	}

	public void setNummuestralote(Integer nummuestralote) {
		this.nummuestralote = nummuestralote;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}

	public CalidadMuestreoTempLimpieza getCalidadMuestreoTempLimpieza() {
		return this.calidadMuestreoTempLimpieza;
	}

	public void setCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		this.calidadMuestreoTempLimpieza = calidadMuestreoTempLimpieza;
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