package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the eviscerado_proceso database table.
 * 
 */
@Entity
@Table(name="eviscerado_proceso")
public class EvisceradoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradoproceso;

	private Timestamp fechareg;

	private Integer secuenciaidcocheglobal;

	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;

	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;

	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="evisceradoProceso")
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="evisceradoProceso")
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="evisceradoProceso")
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;

	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoProceso")
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;

	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	private ObservacionesProceso observacionesProceso;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="evisceradoProceso")
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;

	public EvisceradoProceso() {
	}

	public Long getIdevisceradoproceso() {
		return this.idevisceradoproceso;
	}

	public void setIdevisceradoproceso(Long idevisceradoproceso) {
		this.idevisceradoproceso = idevisceradoproceso;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getSecuenciaidcocheglobal() {
		return this.secuenciaidcocheglobal;
	}

	public void setSecuenciaidcocheglobal(Integer secuenciaidcocheglobal) {
		this.secuenciaidcocheglobal = secuenciaidcocheglobal;
	}

	public List<CalidadMuestreoCocina> getCalidadMuestreoCocinas() {
		return this.calidadMuestreoCocinas;
	}

	public void setCalidadMuestreoCocinas(List<CalidadMuestreoCocina> calidadMuestreoCocinas) {
		this.calidadMuestreoCocinas = calidadMuestreoCocinas;
	}

	public List<CalidadMuestreoTempCoccion> getCalidadMuestreoTempCoccions() {
		return this.calidadMuestreoTempCoccions;
	}

	public void setCalidadMuestreoTempCoccions(List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions) {
		this.calidadMuestreoTempCoccions = calidadMuestreoTempCoccions;
	}

	public List<CalidadMuestreoTempCochesEviscerado> getCalidadMuestreoTempCochesEviscerados() {
		return this.calidadMuestreoTempCochesEviscerados;
	}

	public void setCalidadMuestreoTempCochesEviscerados(List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados) {
		this.calidadMuestreoTempCochesEviscerados = calidadMuestreoTempCochesEviscerados;
	}

	public List<CalidadMuestreoTempPanzasEviscerado> getCalidadMuestreoTempPanzasEviscerados() {
		return this.calidadMuestreoTempPanzasEviscerados;
	}

	public void setCalidadMuestreoTempPanzasEviscerados(List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados) {
		this.calidadMuestreoTempPanzasEviscerados = calidadMuestreoTempPanzasEviscerados;
	}

	public List<CoccionMuestreoTempCoche> getCoccionMuestreoTempCoches() {
		return this.coccionMuestreoTempCoches;
	}

	public void setCoccionMuestreoTempCoches(List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches) {
		this.coccionMuestreoTempCoches = coccionMuestreoTempCoches;
	}

	public List<CoccionMuestreoTempCocheIngreso> getCoccionMuestreoTempCocheIngresos() {
		return this.coccionMuestreoTempCocheIngresos;
	}

	public void setCoccionMuestreoTempCocheIngresos(List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos) {
		this.coccionMuestreoTempCocheIngresos = coccionMuestreoTempCocheIngresos;
	}

	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
	}

	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

}