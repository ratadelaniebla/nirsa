package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_pcc database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_pcc")
@NamedQuery(name="CalidadDetallePcc.findAll", query="SELECT c FROM CalidadDetallePcc c")
public class CalidadDetallePcc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddetallecalidadpcc;
	private Integer agalla;
	private double consumonitrogeno;
	private Integer danofisico;
	private Timestamp fechareg;
	private double histamina;
	private Integer idcalidadolormuestra;
	private Integer idcalidadsabormuestra;
	private String lotecamara;
	private double nitrogeno;
	private Integer nummuestra;
	private String observacionnhistnit;
	private Integer ojos;
	private double pesonitrogeno;
	private double ph;
	private Integer piel;
	private double sal;
	private double temperatura;
	private double tempsalmuera;
	private String usuariohistamina;
	private String usuariosal;
	private BarcoEstibaCuba barcoEstibaCuba;
	private CalidadNumeroMuestreoPcc calidadNumeroMuestreoPcc;
	private CalidadPcc calidadPcc;
	private CamaraCajon camaraCajon;
	private EspecieTalla especieTalla;
	private Usuario usuario;

	public CalidadDetallePcc() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddetallecalidadpcc() {
		return this.iddetallecalidadpcc;
	}

	public void setIddetallecalidadpcc(Long iddetallecalidadpcc) {
		this.iddetallecalidadpcc = iddetallecalidadpcc;
	}


	public Integer getAgalla() {
		return this.agalla;
	}

	public void setAgalla(Integer agalla) {
		this.agalla = agalla;
	}


	public double getConsumonitrogeno() {
		return this.consumonitrogeno;
	}

	public void setConsumonitrogeno(double consumonitrogeno) {
		this.consumonitrogeno = consumonitrogeno;
	}


	public Integer getDanofisico() {
		return this.danofisico;
	}

	public void setDanofisico(Integer danofisico) {
		this.danofisico = danofisico;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public double getHistamina() {
		return this.histamina;
	}

	public void setHistamina(double histamina) {
		this.histamina = histamina;
	}


	public Integer getIdcalidadolormuestra() {
		return this.idcalidadolormuestra;
	}

	public void setIdcalidadolormuestra(Integer idcalidadolormuestra) {
		this.idcalidadolormuestra = idcalidadolormuestra;
	}


	public Integer getIdcalidadsabormuestra() {
		return this.idcalidadsabormuestra;
	}

	public void setIdcalidadsabormuestra(Integer idcalidadsabormuestra) {
		this.idcalidadsabormuestra = idcalidadsabormuestra;
	}


	public String getLotecamara() {
		return this.lotecamara;
	}

	public void setLotecamara(String lotecamara) {
		this.lotecamara = lotecamara;
	}


	public double getNitrogeno() {
		return this.nitrogeno;
	}

	public void setNitrogeno(double nitrogeno) {
		this.nitrogeno = nitrogeno;
	}


	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}


	public String getObservacionnhistnit() {
		return this.observacionnhistnit;
	}

	public void setObservacionnhistnit(String observacionnhistnit) {
		this.observacionnhistnit = observacionnhistnit;
	}


	public Integer getOjos() {
		return this.ojos;
	}

	public void setOjos(Integer ojos) {
		this.ojos = ojos;
	}


	public double getPesonitrogeno() {
		return this.pesonitrogeno;
	}

	public void setPesonitrogeno(double pesonitrogeno) {
		this.pesonitrogeno = pesonitrogeno;
	}


	public double getPh() {
		return this.ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}


	public Integer getPiel() {
		return this.piel;
	}

	public void setPiel(Integer piel) {
		this.piel = piel;
	}


	public double getSal() {
		return this.sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	public double getTempsalmuera() {
		return this.tempsalmuera;
	}

	public void setTempsalmuera(double tempsalmuera) {
		this.tempsalmuera = tempsalmuera;
	}


	public String getUsuariohistamina() {
		return this.usuariohistamina;
	}

	public void setUsuariohistamina(String usuariohistamina) {
		this.usuariohistamina = usuariohistamina;
	}


	public String getUsuariosal() {
		return this.usuariosal;
	}

	public void setUsuariosal(String usuariosal) {
		this.usuariosal = usuariosal;
	}


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}


	//bi-directional many-to-one association to CalidadNumeroMuestreoPcc
	@ManyToOne
	@JoinColumn(name="nummuestreo")
	public CalidadNumeroMuestreoPcc getCalidadNumeroMuestreoPcc() {
		return this.calidadNumeroMuestreoPcc;
	}

	public void setCalidadNumeroMuestreoPcc(CalidadNumeroMuestreoPcc calidadNumeroMuestreoPcc) {
		this.calidadNumeroMuestreoPcc = calidadNumeroMuestreoPcc;
	}


	//bi-directional many-to-one association to CalidadPcc
	@ManyToOne
	@JoinColumn(name="idcalidadpcc")
	public CalidadPcc getCalidadPcc() {
		return this.calidadPcc;
	}

	public void setCalidadPcc(CalidadPcc calidadPcc) {
		this.calidadPcc = calidadPcc;
	}


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
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