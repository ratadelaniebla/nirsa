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
@NamedQuery(name="LimpiezaDetalleProcesoLote.findAll", query="SELECT l FROM LimpiezaDetalleProcesoLote l")
public class LimpiezaDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalleprocesolote;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Timestamp fechareg;
	private Integer idtallaAjustada;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;
	private LimpiezaProceso limpiezaProceso;
	private LimpiezaTipo limpiezaTipo;
	private ProduccionDetalleLote produccionDetalleLote;
	private Turno turno;
	private Usuario usuario;
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;

	public LimpiezaDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="idtalla_ajustada")
	public Integer getIdtallaAjustada() {
		return this.idtallaAjustada;
	}

	public void setIdtallaAjustada(Integer idtallaAjustada) {
		this.idtallaAjustada = idtallaAjustada;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().add(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaDetalleProcesoLote(this);

		return limpiezaCocheModificacion;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().remove(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaDetalleProcesoLote(null);

		return limpiezaCocheModificacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public LimpiezaDetalleDesperdicio addLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().add(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setLimpiezaDetalleProcesoLote(this);

		return limpiezaDetalleDesperdicio;
	}

	public LimpiezaDetalleDesperdicio removeLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().remove(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setLimpiezaDetalleProcesoLote(null);

		return limpiezaDetalleDesperdicio;
	}


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public LimpiezaDetallePesoDespellejadoT addLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().add(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setLimpiezaDetalleProcesoLote(this);

		return limpiezaDetallePesoDespellejadoT;
	}

	public LimpiezaDetallePesoDespellejadoT removeLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().remove(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setLimpiezaDetalleProcesoLote(null);

		return limpiezaDetallePesoDespellejadoT;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaDetalleProcesoLote(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaDetalleProcesoLote(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaDetalleProcesoLote(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaDetalleProcesoLote(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaDetalleProcesoCoche addLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().add(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setLimpiezaDetalleProcesoLote(this);

		return limpiezaDetalleProcesoCoch;
	}

	public LimpiezaDetalleProcesoCoche removeLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().remove(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setLimpiezaDetalleProcesoLote(null);

		return limpiezaDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}


	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public LimpiezaProcesoLoteActivo addLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().add(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaDetalleProcesoLote(this);

		return limpiezaProcesoLoteActivo;
	}

	public LimpiezaProcesoLoteActivo removeLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().remove(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaDetalleProcesoLote(null);

		return limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLimpiezaDetalleProcesoLote(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLimpiezaDetalleProcesoLote(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaDetalleProcesoLote")
	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
	}

	public PouchDetalleProcesoLote addPouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().add(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setLimpiezaDetalleProcesoLote(this);

		return pouchDetalleProcesoLote;
	}

	public PouchDetalleProcesoLote removePouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().remove(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setLimpiezaDetalleProcesoLote(null);

		return pouchDetalleProcesoLote;
	}

}