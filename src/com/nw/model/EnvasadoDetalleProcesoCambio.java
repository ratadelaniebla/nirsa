package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envasado_detalle_proceso_cambios database table.
 * 
 */
@Entity
@Table(name="envasado_detalle_proceso_cambios")
@NamedQuery(name="EnvasadoDetalleProcesoCambio.findAll", query="SELECT e FROM EnvasadoDetalleProcesoCambio e")
public class EnvasadoDetalleProcesoCambio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadodetalleprocesocambios;
	private double ac;
	private double ag;
	private String codvideojet;
	private double dre;
	private Timestamp fechacambio;
	private Timestamp fechareg;
	private double fill;
	private double flake;
	private double latas;
	private String observacion;
	private String pesoneto;
	private double porcentajeproteina;
	private EnvasadoProceso envasadoProceso;
	private EnvasadoTipoProteina envasadoTipoProteina;
	private MaquinaCerradora maquinaCerradora;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private Turno turno;
	private Usuario usuario;
	private List<EnvasadoDetalleProcesoCambiosLuthy> envasadoDetalleProcesoCambiosLuthies;

	public EnvasadoDetalleProcesoCambio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadodetalleprocesocambios() {
		return this.idenvasadodetalleprocesocambios;
	}

	public void setIdenvasadodetalleprocesocambios(Long idenvasadodetalleprocesocambios) {
		this.idenvasadodetalleprocesocambios = idenvasadodetalleprocesocambios;
	}


	public double getAc() {
		return this.ac;
	}

	public void setAc(double ac) {
		this.ac = ac;
	}


	public double getAg() {
		return this.ag;
	}

	public void setAg(double ag) {
		this.ag = ag;
	}


	public String getCodvideojet() {
		return this.codvideojet;
	}

	public void setCodvideojet(String codvideojet) {
		this.codvideojet = codvideojet;
	}


	public double getDre() {
		return this.dre;
	}

	public void setDre(double dre) {
		this.dre = dre;
	}


	public Timestamp getFechacambio() {
		return this.fechacambio;
	}

	public void setFechacambio(Timestamp fechacambio) {
		this.fechacambio = fechacambio;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public double getFill() {
		return this.fill;
	}

	public void setFill(double fill) {
		this.fill = fill;
	}


	public double getFlake() {
		return this.flake;
	}

	public void setFlake(double flake) {
		this.flake = flake;
	}


	public double getLatas() {
		return this.latas;
	}

	public void setLatas(double latas) {
		this.latas = latas;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(String pesoneto) {
		this.pesoneto = pesoneto;
	}


	public double getPorcentajeproteina() {
		return this.porcentajeproteina;
	}

	public void setPorcentajeproteina(double porcentajeproteina) {
		this.porcentajeproteina = porcentajeproteina;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@ManyToOne
	@JoinColumn(name="idenvasadoproceso")
	public EnvasadoProceso getEnvasadoProceso() {
		return this.envasadoProceso;
	}

	public void setEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		this.envasadoProceso = envasadoProceso;
	}


	//bi-directional many-to-one association to EnvasadoTipoProteina
	@ManyToOne
	@JoinColumn(name="idenvasadotipoproteina")
	public EnvasadoTipoProteina getEnvasadoTipoProteina() {
		return this.envasadoTipoProteina;
	}

	public void setEnvasadoTipoProteina(EnvasadoTipoProteina envasadoTipoProteina) {
		this.envasadoTipoProteina = envasadoTipoProteina;
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


	//bi-directional many-to-one association to ProduccionDetalleOrden
	@ManyToOne
	@JoinColumn(name="idproducciondetalleorden")
	public ProduccionDetalleOrden getProduccionDetalleOrden() {
		return this.produccionDetalleOrden;
	}

	public void setProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		this.produccionDetalleOrden = produccionDetalleOrden;
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


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambiosLuthy
	@OneToMany(mappedBy="envasadoDetalleProcesoCambio")
	public List<EnvasadoDetalleProcesoCambiosLuthy> getEnvasadoDetalleProcesoCambiosLuthies() {
		return this.envasadoDetalleProcesoCambiosLuthies;
	}

	public void setEnvasadoDetalleProcesoCambiosLuthies(List<EnvasadoDetalleProcesoCambiosLuthy> envasadoDetalleProcesoCambiosLuthies) {
		this.envasadoDetalleProcesoCambiosLuthies = envasadoDetalleProcesoCambiosLuthies;
	}

	public EnvasadoDetalleProcesoCambiosLuthy addEnvasadoDetalleProcesoCambiosLuthy(EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy) {
		getEnvasadoDetalleProcesoCambiosLuthies().add(envasadoDetalleProcesoCambiosLuthy);
		envasadoDetalleProcesoCambiosLuthy.setEnvasadoDetalleProcesoCambio(this);

		return envasadoDetalleProcesoCambiosLuthy;
	}

	public EnvasadoDetalleProcesoCambiosLuthy removeEnvasadoDetalleProcesoCambiosLuthy(EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy) {
		getEnvasadoDetalleProcesoCambiosLuthies().remove(envasadoDetalleProcesoCambiosLuthy);
		envasadoDetalleProcesoCambiosLuthy.setEnvasadoDetalleProcesoCambio(null);

		return envasadoDetalleProcesoCambiosLuthy;
	}

}