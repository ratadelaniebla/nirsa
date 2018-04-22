package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the desperdicio_detalle database table.
 * 
 */
@Entity
@Table(name="desperdicio_detalle")
public class DesperdicioDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddesperdiciodetalle;

	private Integer diajuliano;

	private Timestamp fecharegistro;

	private String numerocajontemporal;

	private Integer numerogavetas;

	private double pesobruto;

	private double pesoneto;

	private String tipoingreso;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@ManyToOne
	@JoinColumn(name="iddesperdiciocajonharina")
	private DesperdicioCajonHarina desperdicioCajonHarina;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	private Lugar lugar;

	//bi-directional many-to-one association to LugarDetalle
	@ManyToOne
	@JoinColumn(name="idlugardetalle")
	private LugarDetalle lugarDetalle;

	//bi-directional many-to-one association to Subproducto
	@ManyToOne
	@JoinColumn(name="idsubproducto")
	private Subproducto subproducto;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DetalleLoteDesperdicio
	@OneToMany(mappedBy="desperdicioDetalle")
	private List<DetalleLoteDesperdicio> detalleLoteDesperdicios;

	public DesperdicioDetalle() {
	}

	public Long getIddesperdiciodetalle() {
		return this.iddesperdiciodetalle;
	}

	public void setIddesperdiciodetalle(Long iddesperdiciodetalle) {
		this.iddesperdiciodetalle = iddesperdiciodetalle;
	}

	public Integer getDiajuliano() {
		return this.diajuliano;
	}

	public void setDiajuliano(Integer diajuliano) {
		this.diajuliano = diajuliano;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getNumerocajontemporal() {
		return this.numerocajontemporal;
	}

	public void setNumerocajontemporal(String numerocajontemporal) {
		this.numerocajontemporal = numerocajontemporal;
	}

	public Integer getNumerogavetas() {
		return this.numerogavetas;
	}

	public void setNumerogavetas(Integer numerogavetas) {
		this.numerogavetas = numerogavetas;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public DesperdicioCajonHarina getDesperdicioCajonHarina() {
		return this.desperdicioCajonHarina;
	}

	public void setDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		this.desperdicioCajonHarina = desperdicioCajonHarina;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public LugarDetalle getLugarDetalle() {
		return this.lugarDetalle;
	}

	public void setLugarDetalle(LugarDetalle lugarDetalle) {
		this.lugarDetalle = lugarDetalle;
	}

	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
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

	public List<DetalleLoteDesperdicio> getDetalleLoteDesperdicios() {
		return this.detalleLoteDesperdicios;
	}

	public void setDetalleLoteDesperdicios(List<DetalleLoteDesperdicio> detalleLoteDesperdicios) {
		this.detalleLoteDesperdicios = detalleLoteDesperdicios;
	}

}