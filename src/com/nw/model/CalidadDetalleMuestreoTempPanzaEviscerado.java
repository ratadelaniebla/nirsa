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
@NamedQuery(name="CalidadDetalleMuestreoTempPanzaEviscerado.findAll", query="SELECT c FROM CalidadDetalleMuestreoTempPanzaEviscerado c")
public class CalidadDetalleMuestreoTempPanzaEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidaddetallemuestreotemppanzaseviscerado;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double temperatura;
	private String usuarioactualizacion;
	private CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadDetalleMuestreoTempPanzaEviscerado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@ManyToOne
	@JoinColumn(name="idcalidadmuestreotemppanzaseviscerado")
	public CalidadMuestreoTempPanzasEviscerado getCalidadMuestreoTempPanzasEviscerado() {
		return this.calidadMuestreoTempPanzasEviscerado;
	}

	public void setCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		this.calidadMuestreoTempPanzasEviscerado = calidadMuestreoTempPanzasEviscerado;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
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