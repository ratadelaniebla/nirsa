package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_tarifa_ponchadas database table.
 * 
 */
@Entity
@Table(name="limpieza_tarifa_ponchadas")
@NamedQuery(name="LimpiezaTarifaPonchada.findAll", query="SELECT l FROM LimpiezaTarifaPonchada l")
public class LimpiezaTarifaPonchada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idtarifaponchadas;
	private Integer idlimpiezatipo;
	private String linea;
	private Integer rango1;
	private Integer rango2;
	private double tarifa;
	private List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas;

	public LimpiezaTarifaPonchada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdtarifaponchadas() {
		return this.idtarifaponchadas;
	}

	public void setIdtarifaponchadas(Integer idtarifaponchadas) {
		this.idtarifaponchadas = idtarifaponchadas;
	}


	public Integer getIdlimpiezatipo() {
		return this.idlimpiezatipo;
	}

	public void setIdlimpiezatipo(Integer idlimpiezatipo) {
		this.idlimpiezatipo = idlimpiezatipo;
	}


	public String getLinea() {
		return this.linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}


	public Integer getRango1() {
		return this.rango1;
	}

	public void setRango1(Integer rango1) {
		this.rango1 = rango1;
	}


	public Integer getRango2() {
		return this.rango2;
	}

	public void setRango2(Integer rango2) {
		this.rango2 = rango2;
	}


	public double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoBonificacionPonchada
	@OneToMany(mappedBy="limpiezaTarifaPonchada")
	public List<LimpiezaProcesoEmpleadoBonificacionPonchada> getLimpiezaProcesoEmpleadoBonificacionPonchadas() {
		return this.limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public void setLimpiezaProcesoEmpleadoBonificacionPonchadas(List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas) {
		this.limpiezaProcesoEmpleadoBonificacionPonchadas = limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public LimpiezaProcesoEmpleadoBonificacionPonchada addLimpiezaProcesoEmpleadoBonificacionPonchada(LimpiezaProcesoEmpleadoBonificacionPonchada limpiezaProcesoEmpleadoBonificacionPonchada) {
		getLimpiezaProcesoEmpleadoBonificacionPonchadas().add(limpiezaProcesoEmpleadoBonificacionPonchada);
		limpiezaProcesoEmpleadoBonificacionPonchada.setLimpiezaTarifaPonchada(this);

		return limpiezaProcesoEmpleadoBonificacionPonchada;
	}

	public LimpiezaProcesoEmpleadoBonificacionPonchada removeLimpiezaProcesoEmpleadoBonificacionPonchada(LimpiezaProcesoEmpleadoBonificacionPonchada limpiezaProcesoEmpleadoBonificacionPonchada) {
		getLimpiezaProcesoEmpleadoBonificacionPonchadas().remove(limpiezaProcesoEmpleadoBonificacionPonchada);
		limpiezaProcesoEmpleadoBonificacionPonchada.setLimpiezaTarifaPonchada(null);

		return limpiezaProcesoEmpleadoBonificacionPonchada;
	}

}