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
@NamedQuery(name="OeeEnvasadoCabeceraVelocidadMaquinaCerradora.findAll", query="SELECT o FROM OeeEnvasadoCabeceraVelocidadMaquinaCerradora o")
public class OeeEnvasadoCabeceraVelocidadMaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	private Timestamp fechaHoraCorte;
	private Timestamp fechaHoraFin;
	private Timestamp fechaRegistro;
	private Integer velocidadMaxima;
	private Integer velocidadNominal;
	private Integer velocidadReal;
	private CantidadLibra cantidadLibra;
	private MaquinaCerradora maquinaCerradora;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Usuario usuario;
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_envasado_cabecera_velocidad_maquina_cerradora")
	public Integer getIdOeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
		return this.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public void setIdOeeEnvasadoCabeceraVelocidadMaquinaCerradora(Integer idOeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		this.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora = idOeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}


	@Column(name="fecha_hora_corte")
	public Timestamp getFechaHoraCorte() {
		return this.fechaHoraCorte;
	}

	public void setFechaHoraCorte(Timestamp fechaHoraCorte) {
		this.fechaHoraCorte = fechaHoraCorte;
	}


	@Column(name="fecha_hora_fin")
	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}


	@Column(name="fecha_registro")
	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name="velocidad_maxima")
	public Integer getVelocidadMaxima() {
		return this.velocidadMaxima;
	}

	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}


	@Column(name="velocidad_nominal")
	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}


	@Column(name="velocidad_real")
	public Integer getVelocidadReal() {
		return this.velocidadReal;
	}

	public void setVelocidadReal(Integer velocidadReal) {
		this.velocidadReal = velocidadReal;
	}


	//bi-directional many-to-one association to CantidadLibra
	@ManyToOne
	@JoinColumn(name="idcantidadlibras")
	public CantidadLibra getCantidadLibra() {
		return this.cantidadLibra;
	}

	public void setCantidadLibra(CantidadLibra cantidadLibra) {
		this.cantidadLibra = cantidadLibra;
	}


	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
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


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="oeeEnvasadoCabeceraVelocidadMaquinaCerradora")
	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora addOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().add(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setOeeEnvasadoCabeceraVelocidadMaquinaCerradora(this);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora removeOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().remove(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setOeeEnvasadoCabeceraVelocidadMaquinaCerradora(null);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

}