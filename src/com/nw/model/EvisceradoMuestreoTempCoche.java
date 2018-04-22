package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the eviscerado_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="eviscerado_muestreo_temp_coche")
public class EvisceradoMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradomuestreotempcoche;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoMuestreoTempCoche")
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoMuestreoTempCoche")
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;

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

	public EvisceradoMuestreoTempCoche() {
	}

	public Long getIdevisceradomuestreotempcoche() {
		return this.idevisceradomuestreotempcoche;
	}

	public void setIdevisceradomuestreotempcoche(Long idevisceradomuestreotempcoche) {
		this.idevisceradomuestreotempcoche = idevisceradomuestreotempcoche;
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

	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
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