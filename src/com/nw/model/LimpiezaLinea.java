package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_linea database table.
 * 
 */
@Entity
@Table(name="limpieza_linea")
@NamedQuery(name="LimpiezaLinea.findAll", query="SELECT l FROM LimpiezaLinea l")
public class LimpiezaLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezalinea;
	private String descripcion;
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private List<LimpiezaLineaGrupo> limpiezaLineaGrupos;
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;
	private List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas;
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;
	private List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas;
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;

	public LimpiezaLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezalinea() {
		return this.idlimpiezalinea;
	}

	public void setIdlimpiezalinea(Integer idlimpiezalinea) {
		this.idlimpiezalinea = idlimpiezalinea;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public ControlDetalleBatchLimpieza addControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().add(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setLimpiezaLinea(this);

		return controlDetalleBatchLimpieza;
	}

	public ControlDetalleBatchLimpieza removeControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().remove(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setLimpiezaLinea(null);

		return controlDetalleBatchLimpieza;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaLinea(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaLinea(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().add(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaLinea(this);

		return limpiezaCocheModificacion;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().remove(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaLinea(null);

		return limpiezaCocheModificacion;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaLinea(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaLinea(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado addLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().add(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setLimpiezaLinea(this);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado removeLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().remove(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setLimpiezaLinea(null);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaLinea(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaLinea(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaLinea(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaLinea(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaDetalleProcesoCoche addLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().add(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setLimpiezaLinea(this);

		return limpiezaDetalleProcesoCoch;
	}

	public LimpiezaDetalleProcesoCoche removeLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().remove(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setLimpiezaLinea(null);

		return limpiezaDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

	public LimpiezaDetalleTipoCorte addLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().add(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaLinea(this);

		return limpiezaDetalleTipoCorte;
	}

	public LimpiezaDetalleTipoCorte removeLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().remove(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaLinea(null);

		return limpiezaDetalleTipoCorte;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

	public LimpiezaDetalleTipoPara addLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().add(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaLinea(this);

		return limpiezaDetalleTipoPara;
	}

	public LimpiezaDetalleTipoPara removeLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().remove(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaLinea(null);

		return limpiezaDetalleTipoPara;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaLinea(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaLinea(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaLineaGrupo> getLimpiezaLineaGrupos() {
		return this.limpiezaLineaGrupos;
	}

	public void setLimpiezaLineaGrupos(List<LimpiezaLineaGrupo> limpiezaLineaGrupos) {
		this.limpiezaLineaGrupos = limpiezaLineaGrupos;
	}

	public LimpiezaLineaGrupo addLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		getLimpiezaLineaGrupos().add(limpiezaLineaGrupo);
		limpiezaLineaGrupo.setLimpiezaLinea(this);

		return limpiezaLineaGrupo;
	}

	public LimpiezaLineaGrupo removeLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		getLimpiezaLineaGrupos().remove(limpiezaLineaGrupo);
		limpiezaLineaGrupo.setLimpiezaLinea(null);

		return limpiezaLineaGrupo;
	}


	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public LimpiezaLomoLimpioCoche addLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().add(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setLimpiezaLinea(this);

		return limpiezaLomoLimpioCoch;
	}

	public LimpiezaLomoLimpioCoche removeLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().remove(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setLimpiezaLinea(null);

		return limpiezaLomoLimpioCoch;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public LimpiezaProcesoEmpleado addLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().add(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaLinea(this);

		return limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoEmpleado removeLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().remove(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaLinea(null);

		return limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaLinea(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaLinea(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoEmpleadoTotalInicial> getLimpiezaProcesoEmpleadoTotalInicials() {
		return this.limpiezaProcesoEmpleadoTotalInicials;
	}

	public void setLimpiezaProcesoEmpleadoTotalInicials(List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials) {
		this.limpiezaProcesoEmpleadoTotalInicials = limpiezaProcesoEmpleadoTotalInicials;
	}

	public LimpiezaProcesoEmpleadoTotalInicial addLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().add(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setLimpiezaLinea(this);

		return limpiezaProcesoEmpleadoTotalInicial;
	}

	public LimpiezaProcesoEmpleadoTotalInicial removeLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().remove(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setLimpiezaLinea(null);

		return limpiezaProcesoEmpleadoTotalInicial;
	}


	//bi-directional many-to-one association to LimpiezaProcesoJornadaLinea
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoJornadaLinea> getLimpiezaProcesoJornadaLineas() {
		return this.limpiezaProcesoJornadaLineas;
	}

	public void setLimpiezaProcesoJornadaLineas(List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas) {
		this.limpiezaProcesoJornadaLineas = limpiezaProcesoJornadaLineas;
	}

	public LimpiezaProcesoJornadaLinea addLimpiezaProcesoJornadaLinea(LimpiezaProcesoJornadaLinea limpiezaProcesoJornadaLinea) {
		getLimpiezaProcesoJornadaLineas().add(limpiezaProcesoJornadaLinea);
		limpiezaProcesoJornadaLinea.setLimpiezaLinea(this);

		return limpiezaProcesoJornadaLinea;
	}

	public LimpiezaProcesoJornadaLinea removeLimpiezaProcesoJornadaLinea(LimpiezaProcesoJornadaLinea limpiezaProcesoJornadaLinea) {
		getLimpiezaProcesoJornadaLineas().remove(limpiezaProcesoJornadaLinea);
		limpiezaProcesoJornadaLinea.setLimpiezaLinea(null);

		return limpiezaProcesoJornadaLinea;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoLineaTara> getLimpiezaProcesoLineaTaras() {
		return this.limpiezaProcesoLineaTaras;
	}

	public void setLimpiezaProcesoLineaTaras(List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras) {
		this.limpiezaProcesoLineaTaras = limpiezaProcesoLineaTaras;
	}

	public LimpiezaProcesoLineaTara addLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().add(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setLimpiezaLinea(this);

		return limpiezaProcesoLineaTara;
	}

	public LimpiezaProcesoLineaTara removeLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().remove(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setLimpiezaLinea(null);

		return limpiezaProcesoLineaTara;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public LimpiezaProcesoLoteActivo addLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().add(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaLinea(this);

		return limpiezaProcesoLoteActivo;
	}

	public LimpiezaProcesoLoteActivo removeLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().remove(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaLinea(null);

		return limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="limpiezaLinea")
	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public LimpiezaRalladoDetallePeso addLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().add(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaLinea(this);

		return limpiezaRalladoDetallePeso;
	}

	public LimpiezaRalladoDetallePeso removeLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().remove(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaLinea(null);

		return limpiezaRalladoDetallePeso;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoLimpiezas() {
		return this.oeeDetalleMediosConDefectoLimpiezas;
	}

	public void setOeeDetalleMediosConDefectoLimpiezas(List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas) {
		this.oeeDetalleMediosConDefectoLimpiezas = oeeDetalleMediosConDefectoLimpiezas;
	}

	public OeeDetalleMediosConDefectoLimpieza addOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().add(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setLimpiezaLinea(this);

		return oeeDetalleMediosConDefectoLimpieza;
	}

	public OeeDetalleMediosConDefectoLimpieza removeOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().remove(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setLimpiezaLinea(null);

		return oeeDetalleMediosConDefectoLimpieza;
	}


	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

	public OeeDetalleParadaLimpieza addOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().add(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setLimpiezaLinea(this);

		return oeeDetalleParadaLimpieza;
	}

	public OeeDetalleParadaLimpieza removeOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().remove(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setLimpiezaLinea(null);

		return oeeDetalleParadaLimpieza;
	}

}