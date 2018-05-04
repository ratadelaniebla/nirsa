package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_proceso_empleado")
@NamedQuery(name="AtcLimpiezaProcesoEmpleado.findAll", query="SELECT a FROM AtcLimpiezaProcesoEmpleado a")
public class AtcLimpiezaProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezaprocesoempleado;
	private Timestamp fechareg;
	private Integer idatclimpiezacargo;
	private String tarjetapersonalinea;
	private Integer ubicacion;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;
	private AtcLimpiezaLinea atcLimpiezaLinea;
	private AtcLimpiezaProceso atcLimpiezaProceso;
	private AtcUsuario atcUsuario;
	private Empleado empleado;

	public AtcLimpiezaProcesoEmpleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatclimpiezaprocesoempleado() {
		return this.idatclimpiezaprocesoempleado;
	}

	public void setIdatclimpiezaprocesoempleado(Long idatclimpiezaprocesoempleado) {
		this.idatclimpiezaprocesoempleado = idatclimpiezaprocesoempleado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getIdatclimpiezacargo() {
		return this.idatclimpiezacargo;
	}

	public void setIdatclimpiezacargo(Integer idatclimpiezacargo) {
		this.idatclimpiezacargo = idatclimpiezacargo;
	}


	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}


	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaProcesoEmpleado")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaProcesoEmpleado(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaProcesoEmpleado(null);

		return atcLimpiezaDetalleBandeja;
	}


	//bi-directional many-to-one association to AtcLimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idatclinea")
	public AtcLimpiezaLinea getAtcLimpiezaLinea() {
		return this.atcLimpiezaLinea;
	}

	public void setAtcLimpiezaLinea(AtcLimpiezaLinea atcLimpiezaLinea) {
		this.atcLimpiezaLinea = atcLimpiezaLinea;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}