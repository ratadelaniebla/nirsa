package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_proceso_lote")
public class LimpiezaDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetalleprocesolote;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Timestamp fechareg;

	@Column(name="idtalla_ajustada")
	private Integer idtallaAjustada;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;

	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	private ProduccionDetalleLote produccionDetalleLote;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;

	public LimpiezaDetalleProcesoLote() {
	}

	public Long getIdlimpiezadetalleprocesolote() {
		return this.idlimpiezadetalleprocesolote;
	}

	public void setIdlimpiezadetalleprocesolote(Long idlimpiezadetalleprocesolote) {
		this.idlimpiezadetalleprocesolote = idlimpiezadetalleprocesolote;
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

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getIdtallaAjustada() {
		return this.idtallaAjustada;
	}

	public void setIdtallaAjustada(Integer idtallaAjustada) {
		this.idtallaAjustada = idtallaAjustada;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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

	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
	}

}