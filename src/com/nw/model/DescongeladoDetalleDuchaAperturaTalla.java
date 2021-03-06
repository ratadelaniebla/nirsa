package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the descongelado_detalle_ducha_apertura_talla database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_ducha_apertura_talla")
@NamedQuery(name="DescongeladoDetalleDuchaAperturaTalla.findAll", query="SELECT d FROM DescongeladoDetalleDuchaAperturaTalla d")
public class DescongeladoDetalleDuchaAperturaTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladodetalleduchaaperturatalla;
	private Integer estado;
	private Timestamp fechacreacionregistro;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Integer numeroduchadageneral;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle;
	private Talla talla;
	private Usuario usuario;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	public DescongeladoDetalleDuchaAperturaTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladodetalleduchaaperturatalla() {
		return this.iddescongeladodetalleduchaaperturatalla;
	}

	public void setIddescongeladodetalleduchaaperturatalla(Long iddescongeladodetalleduchaaperturatalla) {
		this.iddescongeladodetalleduchaaperturatalla = iddescongeladodetalleduchaaperturatalla;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechacreacionregistro() {
		return this.fechacreacionregistro;
	}

	public void setFechacreacionregistro(Timestamp fechacreacionregistro) {
		this.fechacreacionregistro = fechacreacionregistro;
	}


	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}


	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}


	public Integer getNumeroduchadageneral() {
		return this.numeroduchadageneral;
	}

	public void setNumeroduchadageneral(Integer numeroduchadageneral) {
		this.numeroduchadageneral = numeroduchadageneral;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle() {
		return this.descongeladoDuchaAperturaCierreDetalle;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		this.descongeladoDuchaAperturaCierreDetalle = descongeladoDuchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
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


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDetalleDuchaAperturaTalla")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoDetalleDuchaAperturaTalla(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoDetalleDuchaAperturaTalla(null);

		return descongeladoDetalleProceso;
	}

}