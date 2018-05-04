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
@NamedQuery(name="CoccionMuestreoTempCocheIngreso.findAll", query="SELECT c FROM CoccionMuestreoTempCocheIngreso c")
public class CoccionMuestreoTempCocheIngreso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcoccionmuestreotempcocheingreso;
	private Timestamp fechareg;
	private String observacion;
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public CoccionMuestreoTempCocheIngreso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="coccionMuestreoTempCocheIngreso")
	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public CoccionDetalleMuestreoTempCocheIngreso addCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().add(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setCoccionMuestreoTempCocheIngreso(this);

		return coccionDetalleMuestreoTempCocheIngreso;
	}

	public CoccionDetalleMuestreoTempCocheIngreso removeCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().remove(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setCoccionMuestreoTempCocheIngreso(null);

		return coccionDetalleMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
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