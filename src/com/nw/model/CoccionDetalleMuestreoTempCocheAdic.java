package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the coccion_detalle_muestreo_temp_coche_adic database table.
 * 
 */
@Entity
@Table(name="coccion_detalle_muestreo_temp_coche_adic")
@NamedQuery(name="CoccionDetalleMuestreoTempCocheAdic.findAll", query="SELECT c FROM CoccionDetalleMuestreoTempCocheAdic c")
public class CoccionDetalleMuestreoTempCocheAdic implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocciondetallemuestreotempcocheadic;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestra;
	private double peso;
	private double temperatura;
	private Integer tipomuestra;
	private String usuarioactualizacion;
	private CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoche;
	private Turno turno;
	private Usuario usuario;

	public CoccionDetalleMuestreoTempCocheAdic() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcocciondetallemuestreotempcocheadic() {
		return this.idcocciondetallemuestreotempcocheadic;
	}

	public void setIdcocciondetallemuestreotempcocheadic(Long idcocciondetallemuestreotempcocheadic) {
		this.idcocciondetallemuestreotempcocheadic = idcocciondetallemuestreotempcocheadic;
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


	public Integer getTipomuestra() {
		return this.tipomuestra;
	}

	public void setTipomuestra(Integer tipomuestra) {
		this.tipomuestra = tipomuestra;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@ManyToOne
	@JoinColumn(name="idcocciondetallemuestreotempcoche")
	public CoccionDetalleMuestreoTempCoche getCoccionDetalleMuestreoTempCoche() {
		return this.coccionDetalleMuestreoTempCoche;
	}

	public void setCoccionDetalleMuestreoTempCoche(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoche) {
		this.coccionDetalleMuestreoTempCoche = coccionDetalleMuestreoTempCoche;
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