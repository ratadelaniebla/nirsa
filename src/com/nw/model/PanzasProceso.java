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
public class PanzasProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpanzasproceso;

	private Timestamp fechareg;

	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="panzasProceso")
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PanzasProceso() {
	}

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

	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
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