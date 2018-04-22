package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_muestreo_temp_coche_ingreso database table.
 * 
 */
@Entity
@Table(name="coccion_muestreo_temp_coche_ingreso")
public class CoccionMuestreoTempCocheIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcoccionmuestreotempcocheingreso;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="coccionMuestreoTempCocheIngreso")
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	private EvisceradoProceso evisceradoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CoccionMuestreoTempCocheIngreso() {
	}

	public Long getIdcoccionmuestreotempcocheingreso() {
		return this.idcoccionmuestreotempcocheingreso;
	}

	public void setIdcoccionmuestreotempcocheingreso(Long idcoccionmuestreotempcocheingreso) {
		this.idcoccionmuestreotempcocheingreso = idcoccionmuestreotempcocheingreso;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
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