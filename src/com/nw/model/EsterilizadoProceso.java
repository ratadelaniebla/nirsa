package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the esterilizado_proceso database table.
 * 
 */
@Entity
@Table(name="esterilizado_proceso")
@NamedQuery(name="EsterilizadoProceso.findAll", query="SELECT e FROM EsterilizadoProceso e")
public class EsterilizadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idesterilizadoproceso;
	private Timestamp fechareg;
	private List<EsterilizadoCoche> esterilizadoCoches;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;
	private List<EsterilizadoProcesoParada> esterilizadoProcesoParadas;

	public EsterilizadoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdesterilizadoproceso() {
		return this.idesterilizadoproceso;
	}

	public void setIdesterilizadoproceso(Long idesterilizadoproceso) {
		this.idesterilizadoproceso = idesterilizadoproceso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to EsterilizadoCoche
	@OneToMany(mappedBy="esterilizadoProceso")
	public List<EsterilizadoCoche> getEsterilizadoCoches() {
		return this.esterilizadoCoches;
	}

	public void setEsterilizadoCoches(List<EsterilizadoCoche> esterilizadoCoches) {
		this.esterilizadoCoches = esterilizadoCoches;
	}

	public EsterilizadoCoche addEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().add(esterilizadoCoch);
		esterilizadoCoch.setEsterilizadoProceso(this);

		return esterilizadoCoch;
	}

	public EsterilizadoCoche removeEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().remove(esterilizadoCoch);
		esterilizadoCoch.setEsterilizadoProceso(null);

		return esterilizadoCoch;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idaperturaprocesocierre")
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


	//bi-directional many-to-one association to EsterilizadoProcesoParada
	@OneToMany(mappedBy="esterilizadoProceso")
	public List<EsterilizadoProcesoParada> getEsterilizadoProcesoParadas() {
		return this.esterilizadoProcesoParadas;
	}

	public void setEsterilizadoProcesoParadas(List<EsterilizadoProcesoParada> esterilizadoProcesoParadas) {
		this.esterilizadoProcesoParadas = esterilizadoProcesoParadas;
	}

	public EsterilizadoProcesoParada addEsterilizadoProcesoParada(EsterilizadoProcesoParada esterilizadoProcesoParada) {
		getEsterilizadoProcesoParadas().add(esterilizadoProcesoParada);
		esterilizadoProcesoParada.setEsterilizadoProceso(this);

		return esterilizadoProcesoParada;
	}

	public EsterilizadoProcesoParada removeEsterilizadoProcesoParada(EsterilizadoProcesoParada esterilizadoProcesoParada) {
		getEsterilizadoProcesoParadas().remove(esterilizadoProcesoParada);
		esterilizadoProcesoParada.setEsterilizadoProceso(null);

		return esterilizadoProcesoParada;
	}

}