package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rociado_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="rociado_muestreo_temp_coche")
public class RociadoMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadomuestreotempcoche;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="rociadoMuestreoTempCoche")
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to RociadoProceso
	@ManyToOne
	@JoinColumn(name="idrociadoproceso")
	private RociadoProceso rociadoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public RociadoMuestreoTempCoche() {
	}

	public Long getIdrociadomuestreotempcoche() {
		return this.idrociadomuestreotempcoche;
	}

	public void setIdrociadomuestreotempcoche(Long idrociadomuestreotempcoche) {
		this.idrociadomuestreotempcoche = idrociadomuestreotempcoche;
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

	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public RociadoProceso getRociadoProceso() {
		return this.rociadoProceso;
	}

	public void setRociadoProceso(RociadoProceso rociadoProceso) {
		this.rociadoProceso = rociadoProceso;
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