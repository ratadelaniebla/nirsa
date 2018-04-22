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
public class EvisceradoDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradodetalleprocesocoche;

	private Integer canastillas;

	private Long codbarra;

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

	private Boolean contingencia;
	
	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;

	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;

	//bi-directional many-to-one association to EvisceradoAuditoriaReimpresion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	private Cocina cocina;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to EvisceradoCorte
	@ManyToOne
	@JoinColumn(name="idevisceradocorte")
	private EvisceradoCorte evisceradoCorte;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	private EvisceradoPescadosLata evisceradoPescadosLata;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to EvisceradoReanudacionSecCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches;

	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;

	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProcesoCoche")
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	public EvisceradoDetalleProcesoCoche() {
	}

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

	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public List<EvisceradoAuditoriaReimpresion> getEvisceradoAuditoriaReimpresions() {
		return this.evisceradoAuditoriaReimpresions;
	}

	public void setEvisceradoAuditoriaReimpresions(List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions) {
		this.evisceradoAuditoriaReimpresions = evisceradoAuditoriaReimpresions;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}

	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}

	public EvisceradoCorte getEvisceradoCorte() {
		return this.evisceradoCorte;
	}

	public void setEvisceradoCorte(EvisceradoCorte evisceradoCorte) {
		this.evisceradoCorte = evisceradoCorte;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}

	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EvisceradoReanudacionSecCoche> getEvisceradoReanudacionSecCoches() {
		return this.evisceradoReanudacionSecCoches;
	}

	public void setEvisceradoReanudacionSecCoches(List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches) {
		this.evisceradoReanudacionSecCoches = evisceradoReanudacionSecCoches;
	}

	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public Boolean getContingencia() {
		return contingencia;
	}

	public void setContingencia(Boolean contingencia) {
		this.contingencia = contingencia;
	}

}