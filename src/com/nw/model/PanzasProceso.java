package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the panzas_proceso database table.
 * 
 */
@Entity
@Table(name="panzas_proceso")
@NamedQuery(name="PanzasProceso.findAll", query="SELECT p FROM PanzasProceso p")
public class PanzasProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpanzasproceso;
	private Timestamp fechareg;
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;

	public PanzasProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpanzasproceso() {
		return this.idpanzasproceso;
	}

	public void setIdpanzasproceso(Long idpanzasproceso) {
		this.idpanzasproceso = idpanzasproceso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="panzasProceso")
	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public PanzasDetalleProcesoLote addPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().add(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setPanzasProceso(this);

		return panzasDetalleProcesoLote;
	}

	public PanzasDetalleProcesoLote removePanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().remove(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setPanzasProceso(null);

		return panzasDetalleProcesoLote;
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