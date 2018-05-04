package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the desperdicio_cajon_harina database table.
 * 
 */
@Entity
@Table(name="desperdicio_cajon_harina")
@NamedQuery(name="DesperdicioCajonHarina.findAll", query="SELECT d FROM DesperdicioCajonHarina d")
public class DesperdicioCajonHarina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddesperdiciocajonharina;
	private Integer diajuliano;
	private Integer estado;
	private Timestamp fechajoracreacionregisto;
	private Date fechaproduccion;
	private Timestamp fechaselladodesperdicio;
	private Timestamp fechaselladoharina;
	private double pesobrutodesperdiciootraarea;
	private double pesoharina;
	private String sello1desperdicio;
	private String sello1harina;
	private String sello2desperdicio;
	private String sello2harina;
	private double tara;
	private double temperatura;
	private double valordiferenciapermitido;
	private Area area;
	private Cajon cajon;
	private Planta planta;
	private Produccion produccion;
	private Subproducto subproducto;
	private Turno turno1;
	private Turno turno2;
	private Turno turno3;
	private Usuario usuario1;
	private Usuario usuario2;
	private List<DesperdicioDetalle> desperdicioDetalles;

	public DesperdicioCajonHarina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddesperdiciocajonharina() {
		return this.iddesperdiciocajonharina;
	}

	public void setIddesperdiciocajonharina(Long iddesperdiciocajonharina) {
		this.iddesperdiciocajonharina = iddesperdiciocajonharina;
	}


	public Integer getDiajuliano() {
		return this.diajuliano;
	}

	public void setDiajuliano(Integer diajuliano) {
		this.diajuliano = diajuliano;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechajoracreacionregisto() {
		return this.fechajoracreacionregisto;
	}

	public void setFechajoracreacionregisto(Timestamp fechajoracreacionregisto) {
		this.fechajoracreacionregisto = fechajoracreacionregisto;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Date fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}


	public Timestamp getFechaselladodesperdicio() {
		return this.fechaselladodesperdicio;
	}

	public void setFechaselladodesperdicio(Timestamp fechaselladodesperdicio) {
		this.fechaselladodesperdicio = fechaselladodesperdicio;
	}


	public Timestamp getFechaselladoharina() {
		return this.fechaselladoharina;
	}

	public void setFechaselladoharina(Timestamp fechaselladoharina) {
		this.fechaselladoharina = fechaselladoharina;
	}


	public double getPesobrutodesperdiciootraarea() {
		return this.pesobrutodesperdiciootraarea;
	}

	public void setPesobrutodesperdiciootraarea(double pesobrutodesperdiciootraarea) {
		this.pesobrutodesperdiciootraarea = pesobrutodesperdiciootraarea;
	}


	public double getPesoharina() {
		return this.pesoharina;
	}

	public void setPesoharina(double pesoharina) {
		this.pesoharina = pesoharina;
	}


	public String getSello1desperdicio() {
		return this.sello1desperdicio;
	}

	public void setSello1desperdicio(String sello1desperdicio) {
		this.sello1desperdicio = sello1desperdicio;
	}


	public String getSello1harina() {
		return this.sello1harina;
	}

	public void setSello1harina(String sello1harina) {
		this.sello1harina = sello1harina;
	}


	public String getSello2desperdicio() {
		return this.sello2desperdicio;
	}

	public void setSello2desperdicio(String sello2desperdicio) {
		this.sello2desperdicio = sello2desperdicio;
	}


	public String getSello2harina() {
		return this.sello2harina;
	}

	public void setSello2harina(String sello2harina) {
		this.sello2harina = sello2harina;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	public double getValordiferenciapermitido() {
		return this.valordiferenciapermitido;
	}

	public void setValordiferenciapermitido(double valordiferenciapermitido) {
		this.valordiferenciapermitido = valordiferenciapermitido;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idareaharina")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}


	//bi-directional many-to-one association to Planta
	@ManyToOne
	@JoinColumn(name="idplanta")
	public Planta getPlanta() {
		return this.planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
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


	//bi-directional many-to-one association to Subproducto
	@ManyToOne
	@JoinColumn(name="idsubproducto")
	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturnodesperdicio")
	public Turno getTurno1() {
		return this.turno1;
	}

	public void setTurno1(Turno turno1) {
		this.turno1 = turno1;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturnoproduccion")
	public Turno getTurno2() {
		return this.turno2;
	}

	public void setTurno2(Turno turno2) {
		this.turno2 = turno2;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturnoharina")
	public Turno getTurno3() {
		return this.turno3;
	}

	public void setTurno3(Turno turno3) {
		this.turno3 = turno3;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariodesperdicio")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioharina")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="desperdicioCajonHarina")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setDesperdicioCajonHarina(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setDesperdicioCajonHarina(null);

		return desperdicioDetalle;
	}

}