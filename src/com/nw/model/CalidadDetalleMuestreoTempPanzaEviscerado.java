package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_muestreo_temp_panza_eviscerado database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_muestreo_temp_panza_eviscerado")
public class CalidadDetalleMuestreoTempPanzaEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddetallemuestreotemppanzaseviscerado;

	private Timestamp fechareg;

	private Timestamp fecharegactualizacion;

	private Integer nummuestralote;

	private double temperatura;

	private String usuarioactualizacion;

	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@ManyToOne
	@JoinColumn(name="idcalidadmuestreotemppanzaseviscerado")
	private CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadDetalleMuestreoTempPanzaEviscerado() {
	}

	public Long getIdcalidaddetallemuestreotemppanzaseviscerado() {
		return this.idcalidaddetallemuestreotemppanzaseviscerado;
	}

	public void setIdcalidaddetallemuestreotemppanzaseviscerado(Long idcalidaddetallemuestreotemppanzaseviscerado) {
		this.idcalidaddetallemuestreotemppanzaseviscerado = idcalidaddetallemuestreotemppanzaseviscerado;
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

	public CalidadMuestreoTempPanzasEviscerado getCalidadMuestreoTempPanzasEviscerado() {
		return this.calidadMuestreoTempPanzasEviscerado;
	}

	public void setCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		this.calidadMuestreoTempPanzasEviscerado = calidadMuestreoTempPanzasEviscerado;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
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