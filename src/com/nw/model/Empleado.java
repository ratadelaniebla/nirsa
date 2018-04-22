package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idempleado;

	private String cedula;

	private String codigoevolution;

	private String codpersona;

	private String nombres;

	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="empleado")
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="empleado")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;

	public Empleado() {
	}

	public Long getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigoevolution() {
		return this.codigoevolution;
	}

	public void setCodigoevolution(String codigoevolution) {
		this.codigoevolution = codigoevolution;
	}

	public String getCodpersona() {
		return this.codpersona;
	}

	public void setCodpersona(String codpersona) {
		this.codpersona = codpersona;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

}