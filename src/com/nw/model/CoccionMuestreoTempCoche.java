package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="coccion_muestreo_temp_coche")
public class CoccionMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcoccionmuestreotempcoche;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="coccionMuestreoTempCoche")
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;

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

	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="coccionMuestreoTempCoche")
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;

	public CoccionMuestreoTempCoche() {
	}

	public Long getIdcoccionmuestreotempcoche() {
		return this.idcoccionmuestreotempcoche;
	}

	public void setIdcoccionmuestreotempcoche(Long idcoccionmuestreotempcoche) {
		this.idcoccionmuestreotempcoche = idcoccionmuestreotempcoche;
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

	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
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

	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

}