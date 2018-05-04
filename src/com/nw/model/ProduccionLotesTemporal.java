package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produccion_lotes_temporal database table.
 * 
 */
@Entity
@Table(name="produccion_lotes_temporal")
@NamedQuery(name="ProduccionLotesTemporal.findAll", query="SELECT p FROM ProduccionLotesTemporal p")
public class ProduccionLotesTemporal implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idproduccionlotestemporal;
	private Integer idlote;
	private Long idproduccion;
	private Integer idturno;
	private double peso;

	public ProduccionLotesTemporal() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdproduccionlotestemporal() {
		return this.idproduccionlotestemporal;
	}

	public void setIdproduccionlotestemporal(Integer idproduccionlotestemporal) {
		this.idproduccionlotestemporal = idproduccionlotestemporal;
	}


	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}


	public Long getIdproduccion() {
		return this.idproduccion;
	}

	public void setIdproduccion(Long idproduccion) {
		this.idproduccion = idproduccion;
	}


	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}