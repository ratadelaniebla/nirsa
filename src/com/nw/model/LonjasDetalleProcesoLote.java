package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lonjas_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="lonjas_detalle_proceso_lote")
public class LonjasDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasdetalleprocesolote;

	private String codigobarco;

	private Integer codigolonjas;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Timestamp fecharegistro;

	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to LonjasEspecietalla
	@ManyToOne
	@JoinColumn(name="idlonjasespecietalla")
	private LonjasEspecietalla lonjasEspecietalla;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	private LonjasOrdenProduccion lonjasOrdenProduccion;

	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	private LonjasProceso lonjasProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LonjasDetalleProcesoLote() {
	}

	public Long getIdlonjasdetalleprocesolote() {
		return this.idlonjasdetalleprocesolote;
	}

	public void setIdlonjasdetalleprocesolote(Long idlonjasdetalleprocesolote) {
		this.idlonjasdetalleprocesolote = idlonjasdetalleprocesolote;
	}

	public String getCodigobarco() {
		return this.codigobarco;
	}

	public void setCodigobarco(String codigobarco) {
		this.codigobarco = codigobarco;
	}

	public Integer getCodigolonjas() {
		return this.codigolonjas;
	}

	public void setCodigolonjas(Integer codigolonjas) {
		this.codigolonjas = codigolonjas;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}

	public LonjasEspecietalla getLonjasEspecietalla() {
		return this.lonjasEspecietalla;
	}

	public void setLonjasEspecietalla(LonjasEspecietalla lonjasEspecietalla) {
		this.lonjasEspecietalla = lonjasEspecietalla;
	}

	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}

	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
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

}