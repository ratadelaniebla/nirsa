package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_descongelado_detalle_temp_agua database table.
 * 
 */
@Entity
@Table(name="calidad_descongelado_detalle_temp_agua")
@NamedQuery(name="CalidadDescongeladoDetalleTempAgua.findAll", query="SELECT c FROM CalidadDescongeladoDetalleTempAgua c")
public class CalidadDescongeladoDetalleTempAgua implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidaddescongeladodetalletempagua;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestra;
	private double temperaturaagua;
	private String usuarioactualizacion;
	private CalidadDescongeladoTempAgua calidadDescongeladoTempAgua;
	private Turno turno;
	private Usuario usuario;

	public CalidadDescongeladoDetalleTempAgua() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidaddescongeladodetalletempagua() {
		return this.idcalidaddescongeladodetalletempagua;
	}

	public void setIdcalidaddescongeladodetalletempagua(Long idcalidaddescongeladodetalletempagua) {
		this.idcalidaddescongeladodetalletempagua = idcalidaddescongeladodetalletempagua;
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


	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}


	public double getTemperaturaagua() {
		return this.temperaturaagua;
	}

	public void setTemperaturaagua(double temperaturaagua) {
		this.temperaturaagua = temperaturaagua;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@ManyToOne
	@JoinColumn(name="idcalidaddescongeladotempagua")
	public CalidadDescongeladoTempAgua getCalidadDescongeladoTempAgua() {
		return this.calidadDescongeladoTempAgua;
	}

	public void setCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		this.calidadDescongeladoTempAgua = calidadDescongeladoTempAgua;
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