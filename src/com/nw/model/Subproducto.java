package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subproducto database table.
 * 
 */
@Entity
public class Subproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idsubproducto;

	private String descripcion;

	private Integer rechazo;

	private String tipo;

	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="subproducto")
	private List<AreaSubproducto> areaSubproductos;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="subproducto")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="subproducto")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="subproducto")
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	private Lugar lugar;

	public Subproducto() {
	}

	public Integer getIdsubproducto() {
		return this.idsubproducto;
	}

	public void setIdsubproducto(Integer idsubproducto) {
		this.idsubproducto = idsubproducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getRechazo() {
		return this.rechazo;
	}

	public void setRechazo(Integer rechazo) {
		this.rechazo = rechazo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}