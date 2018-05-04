package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the coccion_detalle_muestreo_temp_coche_ingreso database table.
 * 
 */
@Entity
@Table(name="coccion_detalle_muestreo_temp_coche_ingreso")
@NamedQuery(name="CoccionDetalleMuestreoTempCocheIngreso.findAll", query="SELECT c FROM CoccionDetalleMuestreoTempCocheIngreso c")
public class CoccionDetalleMuestreoTempCocheIngreso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocciondetallemuestreotempcocheingreso;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double temperatura;
	private String usuarioactualizacion;
	private CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private Turno turno;
	private Usuario usuario;

	public CoccionDetalleMuestreoTempCocheIngreso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcocciondetallemuestreotempcocheingreso() {
		return this.idcocciondetallemuestreotempcocheingreso;
	}

	public void setIdcocciondetallemuestreotempcocheingreso(Long idcocciondetallemuestreotempcocheingreso) {
		this.idcocciondetallemuestreotempcocheingreso = idcocciondetallemuestreotempcocheingreso;
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


	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@ManyToOne
	@JoinColumn(name="idcoccionmuestreotempcocheingreso")
	public CoccionMuestreoTempCocheIngreso getCoccionMuestreoTempCocheIngreso() {
		return this.coccionMuestreoTempCocheIngreso;
	}

	public void setCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		this.coccionMuestreoTempCocheIngreso = coccionMuestreoTempCocheIngreso;
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