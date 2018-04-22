package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rociado_detalle_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="rociado_detalle_muestreo_temp_coche")
public class RociadoDetalleMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadodetallemuestreotempcoche;

	private Timestamp fechareg;

	private Timestamp fecharegactualizacion;

	private Integer nummuestralote;

	private double peso;

	private double temperatura;

	private String usuarioactualizacion;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@ManyToOne
	@JoinColumn(name="idrociadomuestreotempcoche")
	private RociadoMuestreoTempCoche rociadoMuestreoTempCoche;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public RociadoDetalleMuestreoTempCoche() {
	}

	public Long getIdrociadodetallemuestreotempcoche() {
		return this.idrociadodetallemuestreotempcoche;
	}

	public void setIdrociadodetallemuestreotempcoche(Long idrociadodetallemuestreotempcoche) {
		this.idrociadodetallemuestreotempcoche = idrociadodetallemuestreotempcoche;
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

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public RociadoMuestreoTempCoche getRociadoMuestreoTempCoche() {
		return this.rociadoMuestreoTempCoche;
	}

	public void setRociadoMuestreoTempCoche(RociadoMuestreoTempCoche rociadoMuestreoTempCoche) {
		this.rociadoMuestreoTempCoche = rociadoMuestreoTempCoche;
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