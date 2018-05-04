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
@NamedQuery(name="RociadoMuestreoTempCoche.findAll", query="SELECT r FROM RociadoMuestreoTempCoche r")
public class RociadoMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrociadomuestreotempcoche;
	private Timestamp fechareg;
	private String observacion;
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;
	private RociadoProceso rociadoProceso;
	private Turno turno;
	private Usuario usuario;

	public RociadoMuestreoTempCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="rociadoMuestreoTempCoche")
	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public RociadoDetalleMuestreoTempCoche addRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().add(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setRociadoMuestreoTempCoche(this);

		return rociadoDetalleMuestreoTempCoch;
	}

	public RociadoDetalleMuestreoTempCoche removeRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().remove(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setRociadoMuestreoTempCoche(null);

		return rociadoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to RociadoProceso
	@ManyToOne
	@JoinColumn(name="idrociadoproceso")
	public RociadoProceso getRociadoProceso() {
		return this.rociadoProceso;
	}

	public void setRociadoProceso(RociadoProceso rociadoProceso) {
		this.rociadoProceso = rociadoProceso;
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