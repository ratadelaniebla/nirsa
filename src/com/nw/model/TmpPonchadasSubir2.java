package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tmp_ponchadas_subir2 database table.
 * 
 */
@Entity
@Table(name="tmp_ponchadas_subir2")
@NamedQuery(name="TmpPonchadasSubir2.findAll", query="SELECT t FROM TmpPonchadasSubir2 t")
public class TmpPonchadasSubir2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cinco;
	private String codigoevolution;
	private Integer cuatro;
	private Integer dieciocho;
	private Integer diez;
	private Integer doce;
	private Integer dos;
	private Timestamp fecha;
	private Integer idlinea;
	private Integer ocho;
	private Integer quince;
	private Integer seis;
	private Integer tipolimpieza;
	private Integer tres;
	private Integer veintiuno;

	public TmpPonchadasSubir2() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCinco() {
		return this.cinco;
	}

	public void setCinco(Integer cinco) {
		this.cinco = cinco;
	}


	public String getCodigoevolution() {
		return this.codigoevolution;
	}

	public void setCodigoevolution(String codigoevolution) {
		this.codigoevolution = codigoevolution;
	}


	public Integer getCuatro() {
		return this.cuatro;
	}

	public void setCuatro(Integer cuatro) {
		this.cuatro = cuatro;
	}


	public Integer getDieciocho() {
		return this.dieciocho;
	}

	public void setDieciocho(Integer dieciocho) {
		this.dieciocho = dieciocho;
	}


	public Integer getDiez() {
		return this.diez;
	}

	public void setDiez(Integer diez) {
		this.diez = diez;
	}


	public Integer getDoce() {
		return this.doce;
	}

	public void setDoce(Integer doce) {
		this.doce = doce;
	}


	public Integer getDos() {
		return this.dos;
	}

	public void setDos(Integer dos) {
		this.dos = dos;
	}


	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public Integer getIdlinea() {
		return this.idlinea;
	}

	public void setIdlinea(Integer idlinea) {
		this.idlinea = idlinea;
	}


	public Integer getOcho() {
		return this.ocho;
	}

	public void setOcho(Integer ocho) {
		this.ocho = ocho;
	}


	public Integer getQuince() {
		return this.quince;
	}

	public void setQuince(Integer quince) {
		this.quince = quince;
	}


	public Integer getSeis() {
		return this.seis;
	}

	public void setSeis(Integer seis) {
		this.seis = seis;
	}


	public Integer getTipolimpieza() {
		return this.tipolimpieza;
	}

	public void setTipolimpieza(Integer tipolimpieza) {
		this.tipolimpieza = tipolimpieza;
	}


	public Integer getTres() {
		return this.tres;
	}

	public void setTres(Integer tres) {
		this.tres = tres;
	}


	public Integer getVeintiuno() {
		return this.veintiuno;
	}

	public void setVeintiuno(Integer veintiuno) {
		this.veintiuno = veintiuno;
	}

}