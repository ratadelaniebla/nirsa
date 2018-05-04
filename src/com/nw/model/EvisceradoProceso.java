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
@NamedQuery(name="EvisceradoProceso.findAll", query="SELECT e FROM EvisceradoProceso e")
public class EvisceradoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradoproceso;
	private Timestamp fechareg;
	private Integer secuenciaidcocheglobal;
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;
	private ObservacionesProceso observacionesProceso;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;

	public EvisceradoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CalidadMuestreoCocina> getCalidadMuestreoCocinas() {
		return this.calidadMuestreoCocinas;
	}

	public void setCalidadMuestreoCocinas(List<CalidadMuestreoCocina> calidadMuestreoCocinas) {
		this.calidadMuestreoCocinas = calidadMuestreoCocinas;
	}

	public CalidadMuestreoCocina addCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().add(calidadMuestreoCocina);
		calidadMuestreoCocina.setEvisceradoProceso(this);

		return calidadMuestreoCocina;
	}

	public CalidadMuestreoCocina removeCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().remove(calidadMuestreoCocina);
		calidadMuestreoCocina.setEvisceradoProceso(null);

		return calidadMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CalidadMuestreoTempCoccion> getCalidadMuestreoTempCoccions() {
		return this.calidadMuestreoTempCoccions;
	}

	public void setCalidadMuestreoTempCoccions(List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions) {
		this.calidadMuestreoTempCoccions = calidadMuestreoTempCoccions;
	}

	public CalidadMuestreoTempCoccion addCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().add(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setEvisceradoProceso(this);

		return calidadMuestreoTempCoccion;
	}

	public CalidadMuestreoTempCoccion removeCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().remove(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setEvisceradoProceso(null);

		return calidadMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CalidadMuestreoTempCochesEviscerado> getCalidadMuestreoTempCochesEviscerados() {
		return this.calidadMuestreoTempCochesEviscerados;
	}

	public void setCalidadMuestreoTempCochesEviscerados(List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados) {
		this.calidadMuestreoTempCochesEviscerados = calidadMuestreoTempCochesEviscerados;
	}

	public CalidadMuestreoTempCochesEviscerado addCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().add(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setEvisceradoProceso(this);

		return calidadMuestreoTempCochesEviscerado;
	}

	public CalidadMuestreoTempCochesEviscerado removeCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().remove(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setEvisceradoProceso(null);

		return calidadMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CalidadMuestreoTempPanzasEviscerado> getCalidadMuestreoTempPanzasEviscerados() {
		return this.calidadMuestreoTempPanzasEviscerados;
	}

	public void setCalidadMuestreoTempPanzasEviscerados(List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados) {
		this.calidadMuestreoTempPanzasEviscerados = calidadMuestreoTempPanzasEviscerados;
	}

	public CalidadMuestreoTempPanzasEviscerado addCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().add(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setEvisceradoProceso(this);

		return calidadMuestreoTempPanzasEviscerado;
	}

	public CalidadMuestreoTempPanzasEviscerado removeCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().remove(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setEvisceradoProceso(null);

		return calidadMuestreoTempPanzasEviscerado;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CoccionMuestreoTempCoche> getCoccionMuestreoTempCoches() {
		return this.coccionMuestreoTempCoches;
	}

	public void setCoccionMuestreoTempCoches(List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches) {
		this.coccionMuestreoTempCoches = coccionMuestreoTempCoches;
	}

	public CoccionMuestreoTempCoche addCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().add(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setEvisceradoProceso(this);

		return coccionMuestreoTempCoch;
	}

	public CoccionMuestreoTempCoche removeCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().remove(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setEvisceradoProceso(null);

		return coccionMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="evisceradoProceso")
	public List<CoccionMuestreoTempCocheIngreso> getCoccionMuestreoTempCocheIngresos() {
		return this.coccionMuestreoTempCocheIngresos;
	}

	public void setCoccionMuestreoTempCocheIngresos(List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos) {
		this.coccionMuestreoTempCocheIngresos = coccionMuestreoTempCocheIngresos;
	}

	public CoccionMuestreoTempCocheIngreso addCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().add(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setEvisceradoProceso(this);

		return coccionMuestreoTempCocheIngreso;
	}

	public CoccionMuestreoTempCocheIngreso removeCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().remove(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setEvisceradoProceso(null);

		return coccionMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="evisceradoProceso")
	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public EvisceradoDetalleProceso addEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().add(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setEvisceradoProceso(this);

		return evisceradoDetalleProceso;
	}

	public EvisceradoDetalleProceso removeEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().remove(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setEvisceradoProceso(null);

		return evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="evisceradoProceso")
	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public EvisceradoDetalleProcesoModificacion addEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().add(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setEvisceradoProceso(this);

		return evisceradoDetalleProcesoModificacion;
	}

	public EvisceradoDetalleProcesoModificacion removeEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().remove(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setEvisceradoProceso(null);

		return evisceradoDetalleProcesoModificacion;
	}


	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoProceso")
	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
	}

	public EvisceradoMuestreoTempCoche addEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().add(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setEvisceradoProceso(this);

		return evisceradoMuestreoTempCoch;
	}

	public EvisceradoMuestreoTempCoche removeEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().remove(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setEvisceradoProceso(null);

		return evisceradoMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="evisceradoProceso")
	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

	public EvisceradoRackeoLote addEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().add(evisceradoRackeoLote);
		evisceradoRackeoLote.setEvisceradoProceso(this);

		return evisceradoRackeoLote;
	}

	public EvisceradoRackeoLote removeEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().remove(evisceradoRackeoLote);
		evisceradoRackeoLote.setEvisceradoProceso(null);

		return evisceradoRackeoLote;
	}

}