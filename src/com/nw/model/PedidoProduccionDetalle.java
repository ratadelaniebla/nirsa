package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pedido_produccion_detalle database table.
 * 
 */
@Entity
@Table(name="pedido_produccion_detalle")
public class PedidoProduccionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpedidoproducciondetalle;

	private Integer anulado;

	private String destino;

	@Column(name="hora_entrega_camara")
	private Timestamp horaEntregaCamara;

	@Column(name="hora_ingreso_descongelado")
	private Timestamp horaIngresoDescongelado;

	private String idcajon;

	private Integer lote;

	@Column(name="observacion_camara")
	private String observacionCamara;

	@Column(name="observacion_descongelado")
	private String observacionDescongelado;

	private Integer pedido;

	private String registro;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	//bi-directional many-to-one association to PedidoProduccionCabecera
	@ManyToOne
	@JoinColumn(name="idpedidoproduccioncabecera")
	private PedidoProduccionCabecera pedidoProduccionCabecera;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	public PedidoProduccionDetalle() {
	}

	public Integer getIdpedidoproducciondetalle() {
		return this.idpedidoproducciondetalle;
	}

	public void setIdpedidoproducciondetalle(Integer idpedidoproducciondetalle) {
		this.idpedidoproducciondetalle = idpedidoproducciondetalle;
	}

	public Integer getAnulado() {
		return this.anulado;
	}

	public void setAnulado(Integer anulado) {
		this.anulado = anulado;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Timestamp getHoraEntregaCamara() {
		return this.horaEntregaCamara;
	}

	public void setHoraEntregaCamara(Timestamp horaEntregaCamara) {
		this.horaEntregaCamara = horaEntregaCamara;
	}

	public Timestamp getHoraIngresoDescongelado() {
		return this.horaIngresoDescongelado;
	}

	public void setHoraIngresoDescongelado(Timestamp horaIngresoDescongelado) {
		this.horaIngresoDescongelado = horaIngresoDescongelado;
	}

	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}

	public Integer getLote() {
		return this.lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public String getObservacionCamara() {
		return this.observacionCamara;
	}

	public void setObservacionCamara(String observacionCamara) {
		this.observacionCamara = observacionCamara;
	}

	public String getObservacionDescongelado() {
		return this.observacionDescongelado;
	}

	public void setObservacionDescongelado(String observacionDescongelado) {
		this.observacionDescongelado = observacionDescongelado;
	}

	public Integer getPedido() {
		return this.pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

	public PedidoProduccionCabecera getPedidoProduccionCabecera() {
		return this.pedidoProduccionCabecera;
	}

	public void setPedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		this.pedidoProduccionCabecera = pedidoProduccionCabecera;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}