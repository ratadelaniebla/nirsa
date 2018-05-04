package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pouch_proceso database table.
 * 
 */
@Entity
@Table(name="pouch_proceso")
@NamedQuery(name="PouchProceso.findAll", query="SELECT p FROM PouchProceso p")
public class PouchProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpouchproceso;
	private Timestamp fechareg;
	private Long ordenproduccion;
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private ProduccionOrdenPedido produccionOrdenPedido;
	private Usuario usuario;

	public PouchProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpouchproceso() {
		return this.idpouchproceso;
	}

	public void setIdpouchproceso(Long idpouchproceso) {
		this.idpouchproceso = idpouchproceso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Long getOrdenproduccion() {
		return this.ordenproduccion;
	}

	public void setOrdenproduccion(Long ordenproduccion) {
		this.ordenproduccion = ordenproduccion;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="pouchProceso")
	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
	}

	public PouchDetalleProcesoLote addPouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().add(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setPouchProceso(this);

		return pouchDetalleProcesoLote;
	}

	public PouchDetalleProcesoLote removePouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().remove(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setPouchProceso(null);

		return pouchDetalleProcesoLote;
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


	//bi-directional many-to-one association to ProduccionOrdenPedido
	@ManyToOne
	@JoinColumn(name="idproduccionordenpedido")
	public ProduccionOrdenPedido getProduccionOrdenPedido() {
		return this.produccionOrdenPedido;
	}

	public void setProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		this.produccionOrdenPedido = produccionOrdenPedido;
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