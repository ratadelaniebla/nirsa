package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cocina_proceso_control_espina_detalle database table.
 * 
 */
@Entity
@Table(name="cocina_proceso_control_espina_detalle")
@NamedQuery(name="CocinaProcesoControlEspinaDetalle.findAll", query="SELECT c FROM CocinaProcesoControlEspinaDetalle c")
public class CocinaProcesoControlEspinaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocinaprocesocontrolespinadetalle;
	private Timestamp fechareg;
	private double temperatura;
	private String tipoRegistro;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private CocinaProcesoControlEspina cocinaProcesoControlEspina;
	private CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura;
	private Usuario usuario;

	public CocinaProcesoControlEspinaDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcocinaprocesocontrolespinadetalle() {
		return this.idcocinaprocesocontrolespinadetalle;
	}

	public void setIdcocinaprocesocontrolespinadetalle(Long idcocinaprocesocontrolespinadetalle) {
		this.idcocinaprocesocontrolespinadetalle = idcocinaprocesocontrolespinadetalle;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	@Column(name="tipo_registro")
	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to CocinaProcesoControlEspina
	@ManyToOne
	@JoinColumn(name="idcocinaprocesocontrolespina")
	public CocinaProcesoControlEspina getCocinaProcesoControlEspina() {
		return this.cocinaProcesoControlEspina;
	}

	public void setCocinaProcesoControlEspina(CocinaProcesoControlEspina cocinaProcesoControlEspina) {
		this.cocinaProcesoControlEspina = cocinaProcesoControlEspina;
	}


	//bi-directional many-to-one association to CocinaProcesoTipoTemperatura
	@ManyToOne
	@JoinColumn(name="idcocinaprocesotipotemperatura")
	public CocinaProcesoTipoTemperatura getCocinaProcesoTipoTemperatura() {
		return this.cocinaProcesoTipoTemperatura;
	}

	public void setCocinaProcesoTipoTemperatura(CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura) {
		this.cocinaProcesoTipoTemperatura = cocinaProcesoTipoTemperatura;
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