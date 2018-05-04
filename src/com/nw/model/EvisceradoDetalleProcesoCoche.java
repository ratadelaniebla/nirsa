package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the eviscerado_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="eviscerado_detalle_proceso_coche")
@NamedQuery(name="EvisceradoDetalleProcesoCoche.findAll", query="SELECT e FROM EvisceradoDetalleProcesoCoche e")
public class EvisceradoDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradodetalleprocesocoche;
	private Integer canastillas;
	private Long codbarra;
	private Boolean contingencia;
	private Integer estadoespecial;
	private Integer estadouso;
	private Timestamp fechaactualizacion;
	private Timestamp fechareg;
	private Timestamp fecharegrecepcocheconica;
	private Integer idcochedia;
	private Integer idcochelote;
	private Long idcocheprincipal;
	private Long idcocinaaperturacierredetallerecepcocheconica;
	private Integer idcocinarecepcocheconica;
	private String idusuarioactualizacion;
	private String idusuariorecepcocheconica;
	private Integer pescadoadicional;
	private double peso;
	private double tara;
	private String tipoingreso;
	private String tipoingresocontingencia;
	private String tipoingresotara;
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;
	private List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;
	private Cocina cocina;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private EvisceradoCorte evisceradoCorte;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private Turno turno;
	private Usuario usuario;
	private List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches;
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	public EvisceradoDetalleProcesoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradodetalleprocesocoche() {
		return this.idevisceradodetalleprocesocoche;
	}

	public void setIdevisceradodetalleprocesocoche(Long idevisceradodetalleprocesocoche) {
		this.idevisceradodetalleprocesocoche = idevisceradodetalleprocesocoche;
	}


	public Integer getCanastillas() {
		return this.canastillas;
	}

	public void setCanastillas(Integer canastillas) {
		this.canastillas = canastillas;
	}


	public Long getCodbarra() {
		return this.codbarra;
	}

	public void setCodbarra(Long codbarra) {
		this.codbarra = codbarra;
	}


	public Boolean getContingencia() {
		return this.contingencia;
	}

	public void setContingencia(Boolean contingencia) {
		this.contingencia = contingencia;
	}


	public Integer getEstadoespecial() {
		return this.estadoespecial;
	}

	public void setEstadoespecial(Integer estadoespecial) {
		this.estadoespecial = estadoespecial;
	}


	public Integer getEstadouso() {
		return this.estadouso;
	}

	public void setEstadouso(Integer estadouso) {
		this.estadouso = estadouso;
	}


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegrecepcocheconica() {
		return this.fecharegrecepcocheconica;
	}

	public void setFecharegrecepcocheconica(Timestamp fecharegrecepcocheconica) {
		this.fecharegrecepcocheconica = fecharegrecepcocheconica;
	}


	public Integer getIdcochedia() {
		return this.idcochedia;
	}

	public void setIdcochedia(Integer idcochedia) {
		this.idcochedia = idcochedia;
	}


	public Integer getIdcochelote() {
		return this.idcochelote;
	}

	public void setIdcochelote(Integer idcochelote) {
		this.idcochelote = idcochelote;
	}


	public Long getIdcocheprincipal() {
		return this.idcocheprincipal;
	}

	public void setIdcocheprincipal(Long idcocheprincipal) {
		this.idcocheprincipal = idcocheprincipal;
	}


	public Long getIdcocinaaperturacierredetallerecepcocheconica() {
		return this.idcocinaaperturacierredetallerecepcocheconica;
	}

	public void setIdcocinaaperturacierredetallerecepcocheconica(Long idcocinaaperturacierredetallerecepcocheconica) {
		this.idcocinaaperturacierredetallerecepcocheconica = idcocinaaperturacierredetallerecepcocheconica;
	}


	public Integer getIdcocinarecepcocheconica() {
		return this.idcocinarecepcocheconica;
	}

	public void setIdcocinarecepcocheconica(Integer idcocinarecepcocheconica) {
		this.idcocinarecepcocheconica = idcocinarecepcocheconica;
	}


	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}


	public String getIdusuariorecepcocheconica() {
		return this.idusuariorecepcocheconica;
	}

	public void setIdusuariorecepcocheconica(String idusuariorecepcocheconica) {
		this.idusuariorecepcocheconica = idusuariorecepcocheconica;
	}


	public Integer getPescadoadicional() {
		return this.pescadoadicional;
	}

	public void setPescadoadicional(Integer pescadoadicional) {
		this.pescadoadicional = pescadoadicional;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}


	public String getTipoingresocontingencia() {
		return this.tipoingresocontingencia;
	}

	public void setTipoingresocontingencia(String tipoingresocontingencia) {
		this.tipoingresocontingencia = tipoingresocontingencia;
	}


	public String getTipoingresotara() {
		return this.tipoingresotara;
	}

	public void setTipoingresotara(String tipoingresotara) {
		this.tipoingresotara = tipoingresotara;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public CalidadDetalleMuestreoCocina addCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().add(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setEvisceradoDetalleProcesoCoche(this);

		return calidadDetalleMuestreoCocina;
	}

	public CalidadDetalleMuestreoCocina removeCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().remove(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setEvisceradoDetalleProcesoCoche(null);

		return calidadDetalleMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public CalidadDetalleMuestreoTempCoccion addCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().add(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setEvisceradoDetalleProcesoCoche(this);

		return calidadDetalleMuestreoTempCoccion;
	}

	public CalidadDetalleMuestreoTempCoccion removeCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().remove(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setEvisceradoDetalleProcesoCoche(null);

		return calidadDetalleMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado addCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().add(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setEvisceradoDetalleProcesoCoche(this);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado removeCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().remove(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setEvisceradoDetalleProcesoCoche(null);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public CalidadDetalleMuestreoTempLimpieza addCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().add(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setEvisceradoDetalleProcesoCoche(this);

		return calidadDetalleMuestreoTempLimpieza;
	}

	public CalidadDetalleMuestreoTempLimpieza removeCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().remove(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setEvisceradoDetalleProcesoCoche(null);

		return calidadDetalleMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public CoccionDetalleMuestreoTempCoche addCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().add(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(this);

		return coccionDetalleMuestreoTempCoch;
	}

	public CoccionDetalleMuestreoTempCoche removeCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().remove(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(null);

		return coccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public CoccionDetalleMuestreoTempCocheIngreso addCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().add(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setEvisceradoDetalleProcesoCoche(this);

		return coccionDetalleMuestreoTempCocheIngreso;
	}

	public CoccionDetalleMuestreoTempCocheIngreso removeCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().remove(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setEvisceradoDetalleProcesoCoche(null);

		return coccionDetalleMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public CoccionDetalleProcesoCoche addCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().add(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(this);

		return coccionDetalleProcesoCoch;
	}

	public CoccionDetalleProcesoCoche removeCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().remove(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(null);

		return coccionDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche addContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().add(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(this);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche removeContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().remove(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(null);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche addContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().add(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(this);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche removeContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().remove(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(null);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public ControlDetalleBatchLimpieza addControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().add(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setEvisceradoDetalleProcesoCoche(this);

		return controlDetalleBatchLimpieza;
	}

	public ControlDetalleBatchLimpieza removeControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().remove(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setEvisceradoDetalleProcesoCoche(null);

		return controlDetalleBatchLimpieza;
	}


	//bi-directional many-to-one association to EvisceradoAuditoriaReimpresion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<EvisceradoAuditoriaReimpresion> getEvisceradoAuditoriaReimpresions() {
		return this.evisceradoAuditoriaReimpresions;
	}

	public void setEvisceradoAuditoriaReimpresions(List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions) {
		this.evisceradoAuditoriaReimpresions = evisceradoAuditoriaReimpresions;
	}

	public EvisceradoAuditoriaReimpresion addEvisceradoAuditoriaReimpresion(EvisceradoAuditoriaReimpresion evisceradoAuditoriaReimpresion) {
		getEvisceradoAuditoriaReimpresions().add(evisceradoAuditoriaReimpresion);
		evisceradoAuditoriaReimpresion.setEvisceradoDetalleProcesoCoche(this);

		return evisceradoAuditoriaReimpresion;
	}

	public EvisceradoAuditoriaReimpresion removeEvisceradoAuditoriaReimpresion(EvisceradoAuditoriaReimpresion evisceradoAuditoriaReimpresion) {
		getEvisceradoAuditoriaReimpresions().remove(evisceradoAuditoriaReimpresion);
		evisceradoAuditoriaReimpresion.setEvisceradoDetalleProcesoCoche(null);

		return evisceradoAuditoriaReimpresion;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoDetalleProcesoCoche(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoDetalleProcesoCoche(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public EvisceradoDetalleMuestreoTempCoche addEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().add(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(this);

		return evisceradoDetalleMuestreoTempCoch;
	}

	public EvisceradoDetalleMuestreoTempCoche removeEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().remove(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(null);

		return evisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to EvisceradoCorte
	@ManyToOne
	@JoinColumn(name="idevisceradocorte")
	public EvisceradoCorte getEvisceradoCorte() {
		return this.evisceradoCorte;
	}

	public void setEvisceradoCorte(EvisceradoCorte evisceradoCorte) {
		this.evisceradoCorte = evisceradoCorte;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
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


	//bi-directional many-to-one association to EvisceradoReanudacionSecCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<EvisceradoReanudacionSecCoche> getEvisceradoReanudacionSecCoches() {
		return this.evisceradoReanudacionSecCoches;
	}

	public void setEvisceradoReanudacionSecCoches(List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches) {
		this.evisceradoReanudacionSecCoches = evisceradoReanudacionSecCoches;
	}

	public EvisceradoReanudacionSecCoche addEvisceradoReanudacionSecCoch(EvisceradoReanudacionSecCoche evisceradoReanudacionSecCoch) {
		getEvisceradoReanudacionSecCoches().add(evisceradoReanudacionSecCoch);
		evisceradoReanudacionSecCoch.setEvisceradoDetalleProcesoCoche(this);

		return evisceradoReanudacionSecCoch;
	}

	public EvisceradoReanudacionSecCoche removeEvisceradoReanudacionSecCoch(EvisceradoReanudacionSecCoche evisceradoReanudacionSecCoch) {
		getEvisceradoReanudacionSecCoches().remove(evisceradoReanudacionSecCoch);
		evisceradoReanudacionSecCoch.setEvisceradoDetalleProcesoCoche(null);

		return evisceradoReanudacionSecCoch;
	}


	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public LimpiezaAsignacionCanastilla addLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().add(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setEvisceradoDetalleProcesoCoche(this);

		return limpiezaAsignacionCanastilla;
	}

	public LimpiezaAsignacionCanastilla removeLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().remove(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setEvisceradoDetalleProcesoCoche(null);

		return limpiezaAsignacionCanastilla;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().add(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setEvisceradoDetalleProcesoCoche(this);

		return limpiezaCocheModificacion;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().remove(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setEvisceradoDetalleProcesoCoche(null);

		return limpiezaCocheModificacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaDetalleProcesoCoche addLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().add(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(this);

		return limpiezaDetalleProcesoCoch;
	}

	public LimpiezaDetalleProcesoCoche removeLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().remove(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(null);

		return limpiezaDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public RociadoDetalleMuestreoTempCoche addRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().add(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(this);

		return rociadoDetalleMuestreoTempCoch;
	}

	public RociadoDetalleMuestreoTempCoche removeRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().remove(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setEvisceradoDetalleProcesoCoche(null);

		return rociadoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public RociadoDetalleProcesoCoche addRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().add(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(this);

		return rociadoDetalleProcesoCoch;
	}

	public RociadoDetalleProcesoCoche removeRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().remove(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setEvisceradoDetalleProcesoCoche(null);

		return rociadoDetalleProcesoCoch;
	}

}