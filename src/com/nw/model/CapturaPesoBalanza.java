package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the captura_peso_balanza database table.
 * 
 */
@Entity
@Table(name="captura_peso_balanza")
public class CapturaPesoBalanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcapturapesobalanza;

	private Timestamp fecharegistro;

	private Integer idarea;

	private Integer idcajon;

	private Integer idlote;

	private String idordenproduccion;

	private double peso;

	public CapturaPesoBalanza() {
	}

	public Long getIdcapturapesobalanza() {
		return this.idcapturapesobalanza;
	}

	public void setIdcapturapesobalanza(Long idcapturapesobalanza) {
		this.idcapturapesobalanza = idcapturapesobalanza;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Integer getIdarea() {
		return this.idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(Integer idcajon) {
		this.idcajon = idcajon;
	}

	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}

	public String getIdordenproduccion() {
		return this.idordenproduccion;
	}

	public void setIdordenproduccion(String idordenproduccion) {
		this.idordenproduccion = idordenproduccion;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}