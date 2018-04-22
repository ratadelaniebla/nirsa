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
public class PouchProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpouchproceso;

	private Timestamp fechareg;

	private Long ordenproduccion;

	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="pouchProceso")
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to ProduccionOrdenPedido
	@ManyToOne
	@JoinColumn(name="idproduccionordenpedido")
	private ProduccionOrdenPedido produccionOrdenPedido;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PouchProceso() {
	}

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

	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
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

	public ProduccionOrdenPedido getProduccionOrdenPedido() {
		return this.produccionOrdenPedido;
	}

	public void setProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		this.produccionOrdenPedido = produccionOrdenPedido;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}