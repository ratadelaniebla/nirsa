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
public class LimpiezaTarifaPonchada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtarifaponchadas;

	private Integer idlimpiezatipo;

	private String linea;

	private Integer rango1;

	private Integer rango2;

	private double tarifa;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoBonificacionPonchada
	@OneToMany(mappedBy="limpiezaTarifaPonchada")
	private List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas;

	public LimpiezaTarifaPonchada() {
	}

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

	public List<LimpiezaProcesoEmpleadoBonificacionPonchada> getLimpiezaProcesoEmpleadoBonificacionPonchadas() {
		return this.limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public void setLimpiezaProcesoEmpleadoBonificacionPonchadas(List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas) {
		this.limpiezaProcesoEmpleadoBonificacionPonchadas = limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

}