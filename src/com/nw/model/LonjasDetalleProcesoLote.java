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
@NamedQuery(name="LonjasDetalleProcesoLote.findAll", query="SELECT l FROM LonjasDetalleProcesoLote l")
public class LonjasDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasdetalleprocesolote;
	private String codigobarco;
	private Integer codigolonjas;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Timestamp fecharegistro;
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LonjasEspecietalla lonjasEspecietalla;
	private LonjasOrdenProduccion lonjasOrdenProduccion;
	private LonjasProceso lonjasProceso;
	private Turno turno;
	private Usuario usuario;

	public LonjasDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public LonjasDetalleProcesoCoche addLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().add(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasDetalleProcesoLote(this);

		return lonjasDetalleProcesoCoch;
	}

	public LonjasDetalleProcesoCoche removeLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().remove(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasDetalleProcesoLote(null);

		return lonjasDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public LonjasDetalleProcesoCocheEmpacado addLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().add(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasDetalleProcesoLote(this);

		return lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasDetalleProcesoCocheEmpacado removeLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().remove(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasDetalleProcesoLote(null);

		return lonjasDetalleProcesoCocheEmpacado;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasDetalleProcesoLote(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasDetalleProcesoLote(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasDetalleProcesoLote")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasDetalleProcesoLote(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasDetalleProcesoLote(null);

		return lonjasDetalleProcesoEmpaque;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasEspecietalla
	@ManyToOne
	@JoinColumn(name="idlonjasespecietalla")
	public LonjasEspecietalla getLonjasEspecietalla() {
		return this.lonjasEspecietalla;
	}

	public void setLonjasEspecietalla(LonjasEspecietalla lonjasEspecietalla) {
		this.lonjasEspecietalla = lonjasEspecietalla;
	}


	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}


	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
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

}