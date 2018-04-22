package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the oee_envasado_cabecera_velocidad_maquina_cerradora database table.
 * 
 */
@Entity
@Table(name="oee_envasado_cabecera_velocidad_maquina_cerradora")
public class OeeEnvasadoCabeceraVelocidadMaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_envasado_cabecera_velocidad_maquina_cerradora")
	private Integer idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;

	@Column(name="fecha_hora_corte")
	private Timestamp fechaHoraCorte;

	@Column(name="fecha_hora_fin")
	private Timestamp fechaHoraFin;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="velocidad_maxima")
	private Integer velocidadMaxima;

	@Column(name="velocidad_nominal")
	private Integer velocidadNominal;

	@Column(name="velocidad_real")
	private Integer velocidadReal;

	//bi-directional many-to-one association to CantidadLibra
	@ManyToOne
	@JoinColumn(name="idcantidadlibras")
	private CantidadLibra cantidadLibra;

	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	private MaquinaCerradora maquinaCerradora;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="oeeEnvasadoCabeceraVelocidadMaquinaCerradora")
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
	}

	public Integer getIdOeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
		return this.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public void setIdOeeEnvasadoCabeceraVelocidadMaquinaCerradora(Integer idOeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		this.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora = idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public Timestamp getFechaHoraCorte() {
		return this.fechaHoraCorte;
	}

	public void setFechaHoraCorte(Timestamp fechaHoraCorte) {
		this.fechaHoraCorte = fechaHoraCorte;
	}

	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getVelocidadMaxima() {
		return this.velocidadMaxima;
	}

	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}

	public Integer getVelocidadReal() {
		return this.velocidadReal;
	}

	public void setVelocidadReal(Integer velocidadReal) {
		this.velocidadReal = velocidadReal;
	}

	public CantidadLibra getCantidadLibra() {
		return this.cantidadLibra;
	}

	public void setCantidadLibra(CantidadLibra cantidadLibra) {
		this.cantidadLibra = cantidadLibra;
	}

	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

}