package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idempleado;
	private String cedula;
	private String codigoevolution;
	private String codpersona;
	private String nombres;
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;

	public Empleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public AtcLimpiezaProcesoEmpleado addAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().add(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setEmpleado(this);

		return atcLimpiezaProcesoEmpleado;
	}

	public AtcLimpiezaProcesoEmpleado removeAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().remove(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setEmpleado(null);

		return atcLimpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEmpleado(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEmpleado(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEmpleado(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEmpleado(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public LimpiezaProcesoEmpleado addLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().add(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setEmpleado(this);

		return limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoEmpleado removeLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().remove(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setEmpleado(null);

		return limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setEmpleado(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setEmpleado(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public LimpiezaProcesoEmpleadoFalta addLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().add(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setEmpleado(this);

		return limpiezaProcesoEmpleadoFalta;
	}

	public LimpiezaProcesoEmpleadoFalta removeLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().remove(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setEmpleado(null);

		return limpiezaProcesoEmpleadoFalta;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="empleado")
	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public LimpiezaProcesoEmpleadoMarcacione addLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().add(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setEmpleado(this);

		return limpiezaProcesoEmpleadoMarcacione;
	}

	public LimpiezaProcesoEmpleadoMarcacione removeLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().remove(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setEmpleado(null);

		return limpiezaProcesoEmpleadoMarcacione;
	}


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public LonjasProcesoEmpleado addLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().add(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setEmpleado(this);

		return lonjasProcesoEmpleado;
	}

	public LonjasProcesoEmpleado removeLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().remove(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setEmpleado(null);

		return lonjasProcesoEmpleado;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="empleado")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setEmpleado(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setEmpleado(null);

		return oeeDetalleMediosConDefecto;
	}


	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="empleado")
	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

	public RackeoProcesoEmpleado addRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().add(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setEmpleado(this);

		return rackeoProcesoEmpleado;
	}

	public RackeoProcesoEmpleado removeRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().remove(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setEmpleado(null);

		return rackeoProcesoEmpleado;
	}

}