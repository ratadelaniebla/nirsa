package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
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
	private Boolean accambio;
	private double ag;
	private Boolean agcambio;
	private String codvideojet;
	private Boolean codvideojetcambio;
	private double concentracion;
	private Boolean concentracioncambio;
	private double densidad;
	private Boolean densidadcambio;
	private double dre;
	private Timestamp fechacambio;
	private Timestamp fechareg;
	private double fillPromedio;
	private Boolean fillPromedioCambio;
	private double fillRango1;
	private Boolean fillRango1Cambio;
	private double fillRango2;
	private Boolean fillRango2Cambio;
	private double flake;
	private Boolean flakecambio;
	private double formato;
	private Boolean formatocambio;
	private double latas;
	private String observacion;
	private double pesonetoformulado;
	private Boolean pesonetoformuladocambio;
	private String pesoneto;
	private double porcentajeproteina;
	private Boolean porcentajeproteinacambio;
	private double sal;
	private Boolean salcambio;
	private EnvasadoProceso envasadoProceso;
	private MaquinaCerradora maquinaCerradora;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private EnvasadoMotivoCambio envasadoMotivoCambio;
	private EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina;
	private Boolean envasadocaldovegetalproteinacambio;
	private EnvasadoProveedorLata envasadoProveedorLata;
	private EnvasadoProveedorTapa envasadoProveedorTapa;
	private Boolean envasadoproveedorlatascambio;
	private Boolean envasadoproveedortapacambio;
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


	public double getConcentracion() {
		return concentracion;
	}


	public void setConcentracion(double concentracion) {
		this.concentracion = concentracion;
	}


	public double getDensidad() {
		return densidad;
	}


	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}


	public double getFormato() {
		return formato;
	}


	public void setFormato(double formato) {
		this.formato = formato;
	}


	public double getPesonetoformulado() {
		return this.pesonetoformulado;
	}

	public void setPesonetoformulado(double pesonetoformulado) {
		this.pesonetoformulado = pesonetoformulado;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
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


	//bi-directional many-to-one association to EnvasadoCaldoVegetalProteina
	@ManyToOne
	@JoinColumn(name="idenvasadocaldovegetalproteina")
	public EnvasadoCaldoVegetalProteina getEnvasadoCaldoVegetalProteina() {
		return this.envasadoCaldoVegetalProteina;
	}

	public void setEnvasadoCaldoVegetalProteina(EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina) {
		this.envasadoCaldoVegetalProteina = envasadoCaldoVegetalProteina;
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
	
	//bi-directional many-to-one association to EnvasadoProveedorLata
	@ManyToOne
	@JoinColumn(name="idenvasadoproveedortapa")
	public EnvasadoProveedorLata getEnvasadoProveedorLata() {
		return this.envasadoProveedorLata;
	}

	public void setEnvasadoProveedorLata(EnvasadoProveedorLata envasadoProveedorLata) {
		this.envasadoProveedorLata = envasadoProveedorLata;
	}


	//bi-directional many-to-one association to EnvasadoProveedorTapa
	@ManyToOne
	@JoinColumn(name="idenvasadoproveedorlatas")
	public EnvasadoProveedorTapa getEnvasadoProveedorTapa() {
		return this.envasadoProveedorTapa;
	}

	public void setEnvasadoProveedorTapa(EnvasadoProveedorTapa envasadoProveedorTapa) {
		this.envasadoProveedorTapa = envasadoProveedorTapa;
	}

	
	//bi-directional many-to-one association to EnvasadoMotivoCambio
	@ManyToOne
	@JoinColumn(name="idenvasadomotivocambios")
	public EnvasadoMotivoCambio getEnvasadoMotivoCambio() {
		return this.envasadoMotivoCambio;
	}

	public void setEnvasadoMotivoCambio(EnvasadoMotivoCambio envasadoMotivoCambio) {
		this.envasadoMotivoCambio = envasadoMotivoCambio;
	}


	public Boolean getAccambio() {
		return accambio;
	}


	public void setAccambio(Boolean accambio) {
		this.accambio = accambio;
	}


	public Boolean getAgcambio() {
		return agcambio;
	}


	public void setAgcambio(Boolean agcambio) {
		this.agcambio = agcambio;
	}


	public Boolean getCodvideojetcambio() {
		return codvideojetcambio;
	}


	public void setCodvideojetcambio(Boolean codvideojetcambio) {
		this.codvideojetcambio = codvideojetcambio;
	}


	public Boolean getConcentracioncambio() {
		return concentracioncambio;
	}


	public void setConcentracioncambio(Boolean concentracioncambio) {
		this.concentracioncambio = concentracioncambio;
	}


	public Boolean getDensidadcambio() {
		return densidadcambio;
	}


	public void setDensidadcambio(Boolean densidadcambio) {
		this.densidadcambio = densidadcambio;
	}


	@Column(name="fill_promedio")
	public double getFillPromedio() {
		return this.fillPromedio;
	}

	public void setFillPromedio(double fillPromedio) {
		this.fillPromedio = fillPromedio;
	}


	@Column(name="fill_promedio_cambio")
	public Boolean getFillPromedioCambio() {
		return this.fillPromedioCambio;
	}

	public void setFillPromedioCambio(Boolean fillPromedioCambio) {
		this.fillPromedioCambio = fillPromedioCambio;
	}


	@Column(name="fill_rango1")
	public double getFillRango1() {
		return this.fillRango1;
	}

	public void setFillRango1(double fillRango1) {
		this.fillRango1 = fillRango1;
	}


	@Column(name="fill_rango1_cambio")
	public Boolean getFillRango1Cambio() {
		return this.fillRango1Cambio;
	}

	public void setFillRango1Cambio(Boolean fillRango1Cambio) {
		this.fillRango1Cambio = fillRango1Cambio;
	}


	@Column(name="fill_rango2")
	public double getFillRango2() {
		return this.fillRango2;
	}

	public void setFillRango2(double fillRango2) {
		this.fillRango2 = fillRango2;
	}


	@Column(name="fill_rango2_cambio")
	public Boolean getFillRango2Cambio() {
		return this.fillRango2Cambio;
	}

	public void setFillRango2Cambio(Boolean fillRango2Cambio) {
		this.fillRango2Cambio = fillRango2Cambio;
	}
	

	public Boolean getFlakecambio() {
		return flakecambio;
	}


	public void setFlakecambio(Boolean flakecambio) {
		this.flakecambio = flakecambio;
	}


	public Boolean getFormatocambio() {
		return formatocambio;
	}


	public void setFormatocambio(Boolean formatocambio) {
		this.formatocambio = formatocambio;
	}


	public Boolean getPesonetoformuladocambio() {
		return pesonetoformuladocambio;
	}


	public void setPesonetoformuladocambio(Boolean pesonetoformuladocambio) {
		this.pesonetoformuladocambio = pesonetoformuladocambio;
	}


	public Boolean getPorcentajeproteinacambio() {
		return porcentajeproteinacambio;
	}


	public void setPorcentajeproteinacambio(Boolean porcentajeproteinacambio) {
		this.porcentajeproteinacambio = porcentajeproteinacambio;
	}


	public Boolean getSalcambio() {
		return salcambio;
	}


	public void setSalcambio(Boolean salcambio) {
		this.salcambio = salcambio;
	}


	public Boolean getEnvasadocaldovegetalproteinacambio() {
		return envasadocaldovegetalproteinacambio;
	}


	public void setEnvasadocaldovegetalproteinacambio(Boolean envasadocaldovegetalproteinacambio) {
		this.envasadocaldovegetalproteinacambio = envasadocaldovegetalproteinacambio;
	}


	public Boolean getEnvasadoproveedorlatascambio() {
		return envasadoproveedorlatascambio;
	}


	public void setEnvasadoproveedorlatascambio(Boolean envasadoproveedorlatascambio) {
		this.envasadoproveedorlatascambio = envasadoproveedorlatascambio;
	}


	public Boolean getEnvasadoproveedortapacambio() {
		return envasadoproveedortapacambio;
	}


	public void setEnvasadoproveedortapacambio(Boolean envasadoproveedortapacambio) {
		this.envasadoproveedortapacambio = envasadoproveedortapacambio;
	}

	
}