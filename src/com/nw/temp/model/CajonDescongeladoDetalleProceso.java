package com.nw.temp.model;

import java.sql.Timestamp;



public class CajonDescongeladoDetalleProceso {

	private int idCajonDescongelado;
	private String idCajon;
	private int idLote;
	private int origen;
	private int pedido;
	private String cajonRevolteo;
	private String descripcionEspecieTalla;
	private int idDucha;
	private int iddescongeladoProceso;
	private int idproduccionDetalleLoteCajon;
	private Timestamp horaIngreso;
	
	

	public CajonDescongeladoDetalleProceso() {
	}
	
	public CajonDescongeladoDetalleProceso(int idCajonDescongelado,
			String idCajon, String cajonRevolteo, int idLote,
			String descripcionEspecieTalla, int origen, int pedido) {
		this.idCajonDescongelado = idCajonDescongelado;
		this.idCajon = idCajon;
		this.cajonRevolteo = cajonRevolteo;
		this.idLote = idLote;
		this.descripcionEspecieTalla = descripcionEspecieTalla;
		this.origen = origen;
		this.pedido = pedido;
	}

	public int getIdCajonDescongelado() {
		return idCajonDescongelado;
	}

	public void setIdCajonDescongelado(int idCajonDescongelado) {
		this.idCajonDescongelado = idCajonDescongelado;
	}

	public String getIdCajon() {
		return idCajon;
	}

	public void setIdCajon(String idCajon) {
		this.idCajon = idCajon;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getCajonRevolteo() {
		return cajonRevolteo;
	}

	public void setCajonRevolteo(String cajonRevolteo) {
		this.cajonRevolteo = cajonRevolteo;
	}

	public String getDescripcionEspecieTalla() {
		return descripcionEspecieTalla;
	}

	public void setDescripcionEspecieTalla(String descripcionEspecieTalla) {
		this.descripcionEspecieTalla = descripcionEspecieTalla;
	}

	public int getIdDucha() {
		return idDucha;
	}

	public void setIdDucha(int idDucha) {
		this.idDucha = idDucha;
	}

	public int getIdproduccionDetalleLoteCajon() {
		return idproduccionDetalleLoteCajon;
	}

	public void setIdproduccionDetalleLoteCajon(int idproduccionDetalleLoteCajon) {
		this.idproduccionDetalleLoteCajon = idproduccionDetalleLoteCajon;
	}

	public int getIddescongeladoProceso() {
		return iddescongeladoProceso;
	}

	public void setIddescongeladoProceso(int iddescongeladoProceso) {
		this.iddescongeladoProceso = iddescongeladoProceso;
	}

	public Timestamp getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}


}
