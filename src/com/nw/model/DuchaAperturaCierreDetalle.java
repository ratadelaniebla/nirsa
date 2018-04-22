package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ducha_apertura_cierre_detalle database table.
 * 
 */
@Entity
@Table(name="ducha_apertura_cierre_detalle")
public class DuchaAperturaCierreDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idduchaaperturacierredetalle;

	private Integer estado;

	private Integer estadoducha;

	private Timestamp fechafin;

	private Timestamp fechafinducha;

	private Timestamp fechainicio;

	private Integer numeroducha;

	private Integer numeroduchageneral;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="duchaAperturaCierreDetalle")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="duchaAperturaCierreDetalle")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="iddescongeladoducha")
	private DescongeladoDucha descongeladoDucha;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public DuchaAperturaCierreDetalle() {
	}

	public Long getIdduchaaperturacierredetalle() {
		return this.idduchaaperturacierredetalle;
	}

	public void setIdduchaaperturacierredetalle(Long idduchaaperturacierredetalle) {
		this.idduchaaperturacierredetalle = idduchaaperturacierredetalle;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstadoducha() {
		return this.estadoducha;
	}

	public void setEstadoducha(Integer estadoducha) {
		this.estadoducha = estadoducha;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechafinducha() {
		return this.fechafinducha;
	}

	public void setFechafinducha(Timestamp fechafinducha) {
		this.fechafinducha = fechafinducha;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Integer getNumeroducha() {
		return this.numeroducha;
	}

	public void setNumeroducha(Integer numeroducha) {
		this.numeroducha = numeroducha;
	}

	public Integer getNumeroduchageneral() {
		return this.numeroduchageneral;
	}

	public void setNumeroduchageneral(Integer numeroduchageneral) {
		this.numeroduchageneral = numeroduchageneral;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}