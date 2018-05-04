package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_area_cabecera database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_cabecera")
@NamedQuery(name="CalidadMuestraAreaCabecera.findAll", query="SELECT c FROM CalidadMuestraAreaCabecera c")
public class CalidadMuestraAreaCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestraareacabecera;
	private Integer accioncorrectivaporcontrolinterno;
	private Integer accioncorrectivaporhistamina;
	private Integer accioncorrectivaporsal;
	private Boolean aplicaaccioncorrectiva;
	private Boolean aprobado;
	private Boolean aprobadohistamina;
	private Boolean aprobadosal;
	private String armador;
	private String comentario;
	private Integer controlinterno;
	private Timestamp fecharegistro;
	private String lotehaccp;
	private Boolean mostrarvariable;
	private Integer numeropescados;
	private Boolean rechazado;
	private Boolean revisado;
	private Boolean revisadohistamina;
	private Boolean revisadosal;
	private Integer sal;
	private double totalnetohaccp;
	private BarcoDescarga barcoDescarga;
	private CalidadMuestraArea calidadMuestraArea;
	private CalidadMuestraAreaMotivo calidadMuestraAreaMotivo;
	private CalidadMuestraTipoAnalisi calidadMuestraTipoAnalisi;
	private CalidadVariable calidadVariable;
	private CamaraCajon camaraCajon;
	private ProduccionDetalleLote produccionDetalleLote;
	private Turno turno;
	private Usuario usuario;
	private List<CalidadMuestraAreaCabeceraAnalisisProtocolo> calidadMuestraAreaCabeceraAnalisisProtocolos;
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;
	private List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos;

	public CalidadMuestraAreaCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadmuestraareacabecera() {
		return this.idcalidadmuestraareacabecera;
	}

	public void setIdcalidadmuestraareacabecera(Long idcalidadmuestraareacabecera) {
		this.idcalidadmuestraareacabecera = idcalidadmuestraareacabecera;
	}


	public Integer getAccioncorrectivaporcontrolinterno() {
		return this.accioncorrectivaporcontrolinterno;
	}

	public void setAccioncorrectivaporcontrolinterno(Integer accioncorrectivaporcontrolinterno) {
		this.accioncorrectivaporcontrolinterno = accioncorrectivaporcontrolinterno;
	}


	public Integer getAccioncorrectivaporhistamina() {
		return this.accioncorrectivaporhistamina;
	}

	public void setAccioncorrectivaporhistamina(Integer accioncorrectivaporhistamina) {
		this.accioncorrectivaporhistamina = accioncorrectivaporhistamina;
	}


	public Integer getAccioncorrectivaporsal() {
		return this.accioncorrectivaporsal;
	}

	public void setAccioncorrectivaporsal(Integer accioncorrectivaporsal) {
		this.accioncorrectivaporsal = accioncorrectivaporsal;
	}


	public Boolean getAplicaaccioncorrectiva() {
		return this.aplicaaccioncorrectiva;
	}

	public void setAplicaaccioncorrectiva(Boolean aplicaaccioncorrectiva) {
		this.aplicaaccioncorrectiva = aplicaaccioncorrectiva;
	}


	public Boolean getAprobado() {
		return this.aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}


	public Boolean getAprobadohistamina() {
		return this.aprobadohistamina;
	}

	public void setAprobadohistamina(Boolean aprobadohistamina) {
		this.aprobadohistamina = aprobadohistamina;
	}


	public Boolean getAprobadosal() {
		return this.aprobadosal;
	}

	public void setAprobadosal(Boolean aprobadosal) {
		this.aprobadosal = aprobadosal;
	}


	public String getArmador() {
		return this.armador;
	}

	public void setArmador(String armador) {
		this.armador = armador;
	}


	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Integer getControlinterno() {
		return this.controlinterno;
	}

	public void setControlinterno(Integer controlinterno) {
		this.controlinterno = controlinterno;
	}


	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}


	public String getLotehaccp() {
		return this.lotehaccp;
	}

	public void setLotehaccp(String lotehaccp) {
		this.lotehaccp = lotehaccp;
	}


	public Boolean getMostrarvariable() {
		return this.mostrarvariable;
	}

	public void setMostrarvariable(Boolean mostrarvariable) {
		this.mostrarvariable = mostrarvariable;
	}


	public Integer getNumeropescados() {
		return this.numeropescados;
	}

	public void setNumeropescados(Integer numeropescados) {
		this.numeropescados = numeropescados;
	}


	public Boolean getRechazado() {
		return this.rechazado;
	}

	public void setRechazado(Boolean rechazado) {
		this.rechazado = rechazado;
	}


	public Boolean getRevisado() {
		return this.revisado;
	}

	public void setRevisado(Boolean revisado) {
		this.revisado = revisado;
	}


	public Boolean getRevisadohistamina() {
		return this.revisadohistamina;
	}

	public void setRevisadohistamina(Boolean revisadohistamina) {
		this.revisadohistamina = revisadohistamina;
	}


	public Boolean getRevisadosal() {
		return this.revisadosal;
	}

	public void setRevisadosal(Boolean revisadosal) {
		this.revisadosal = revisadosal;
	}


	public Integer getSal() {
		return this.sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}


	public double getTotalnetohaccp() {
		return this.totalnetohaccp;
	}

	public void setTotalnetohaccp(double totalnetohaccp) {
		this.totalnetohaccp = totalnetohaccp;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to CalidadMuestraArea
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraarea")
	public CalidadMuestraArea getCalidadMuestraArea() {
		return this.calidadMuestraArea;
	}

	public void setCalidadMuestraArea(CalidadMuestraArea calidadMuestraArea) {
		this.calidadMuestraArea = calidadMuestraArea;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaMotivo
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareamotivo")
	public CalidadMuestraAreaMotivo getCalidadMuestraAreaMotivo() {
		return this.calidadMuestraAreaMotivo;
	}

	public void setCalidadMuestraAreaMotivo(CalidadMuestraAreaMotivo calidadMuestraAreaMotivo) {
		this.calidadMuestraAreaMotivo = calidadMuestraAreaMotivo;
	}


	//bi-directional many-to-one association to CalidadMuestraTipoAnalisi
	@ManyToOne
	@JoinColumn(name="idcalidadmuestratipoanalisis")
	public CalidadMuestraTipoAnalisi getCalidadMuestraTipoAnalisi() {
		return this.calidadMuestraTipoAnalisi;
	}

	public void setCalidadMuestraTipoAnalisi(CalidadMuestraTipoAnalisi calidadMuestraTipoAnalisi) {
		this.calidadMuestraTipoAnalisi = calidadMuestraTipoAnalisi;
	}


	//bi-directional many-to-one association to CalidadVariable
	@ManyToOne
	@JoinColumn(name="idcalidadvariable")
	public CalidadVariable getCalidadVariable() {
		return this.calidadVariable;
	}

	public void setCalidadVariable(CalidadVariable calidadVariable) {
		this.calidadVariable = calidadVariable;
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


	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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


	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAnalisisProtocolo
	@OneToMany(mappedBy="calidadMuestraAreaCabecera")
	public List<CalidadMuestraAreaCabeceraAnalisisProtocolo> getCalidadMuestraAreaCabeceraAnalisisProtocolos() {
		return this.calidadMuestraAreaCabeceraAnalisisProtocolos;
	}

	public void setCalidadMuestraAreaCabeceraAnalisisProtocolos(List<CalidadMuestraAreaCabeceraAnalisisProtocolo> calidadMuestraAreaCabeceraAnalisisProtocolos) {
		this.calidadMuestraAreaCabeceraAnalisisProtocolos = calidadMuestraAreaCabeceraAnalisisProtocolos;
	}

	public CalidadMuestraAreaCabeceraAnalisisProtocolo addCalidadMuestraAreaCabeceraAnalisisProtocolo(CalidadMuestraAreaCabeceraAnalisisProtocolo calidadMuestraAreaCabeceraAnalisisProtocolo) {
		getCalidadMuestraAreaCabeceraAnalisisProtocolos().add(calidadMuestraAreaCabeceraAnalisisProtocolo);
		calidadMuestraAreaCabeceraAnalisisProtocolo.setCalidadMuestraAreaCabecera(this);

		return calidadMuestraAreaCabeceraAnalisisProtocolo;
	}

	public CalidadMuestraAreaCabeceraAnalisisProtocolo removeCalidadMuestraAreaCabeceraAnalisisProtocolo(CalidadMuestraAreaCabeceraAnalisisProtocolo calidadMuestraAreaCabeceraAnalisisProtocolo) {
		getCalidadMuestraAreaCabeceraAnalisisProtocolos().remove(calidadMuestraAreaCabeceraAnalisisProtocolo);
		calidadMuestraAreaCabeceraAnalisisProtocolo.setCalidadMuestraAreaCabecera(null);

		return calidadMuestraAreaCabeceraAnalisisProtocolo;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="calidadMuestraAreaCabecera")
	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public CalidadMuestraAreaCabeceraAprobacion addCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().add(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setCalidadMuestraAreaCabecera(this);

		return calidadMuestraAreaCabeceraAprobacion;
	}

	public CalidadMuestraAreaCabeceraAprobacion removeCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().remove(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setCalidadMuestraAreaCabecera(null);

		return calidadMuestraAreaCabeceraAprobacion;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="calidadMuestraAreaCabecera")
	public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles() {
		return this.calidadMuestraAreaDetalles;
	}

	public void setCalidadMuestraAreaDetalles(List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles) {
		this.calidadMuestraAreaDetalles = calidadMuestraAreaDetalles;
	}

	public CalidadMuestraAreaDetalle addCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().add(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setCalidadMuestraAreaCabecera(this);

		return calidadMuestraAreaDetalle;
	}

	public CalidadMuestraAreaDetalle removeCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().remove(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setCalidadMuestraAreaCabecera(null);

		return calidadMuestraAreaDetalle;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="calidadMuestraAreaCabecera")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraAreaDetalleMuestra addCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().add(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadMuestraAreaCabecera(this);

		return calidadMuestraAreaDetalleMuestra;
	}

	public CalidadMuestraAreaDetalleMuestra removeCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().remove(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadMuestraAreaCabecera(null);

		return calidadMuestraAreaDetalleMuestra;
	}


	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@OneToMany(mappedBy="calidadMuestraAreaCabecera")
	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMuestraCabeceraDescargaMotivos() {
		return this.calidadMuestraCabeceraDescargaMotivos;
	}

	public void setCalidadMuestraCabeceraDescargaMotivos(List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos) {
		this.calidadMuestraCabeceraDescargaMotivos = calidadMuestraCabeceraDescargaMotivos;
	}

	public CalidadMuestraCabeceraDescargaMotivo addCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().add(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setCalidadMuestraAreaCabecera(this);

		return calidadMuestraCabeceraDescargaMotivo;
	}

	public CalidadMuestraCabeceraDescargaMotivo removeCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().remove(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setCalidadMuestraAreaCabecera(null);

		return calidadMuestraCabeceraDescargaMotivo;
	}

}