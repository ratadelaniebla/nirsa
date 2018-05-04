package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Subproducto.findAll", query="SELECT s FROM Subproducto s")
public class Subproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idsubproducto;
	private String descripcion;
	private Integer rechazo;
	private String tipo;
	private List<AreaSubproducto> areaSubproductos;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;
	private Lugar lugar;

	public Subproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="subproducto")
	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
	}

	public AreaSubproducto addAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().add(areaSubproducto);
		areaSubproducto.setSubproducto(this);

		return areaSubproducto;
	}

	public AreaSubproducto removeAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().remove(areaSubproducto);
		areaSubproducto.setSubproducto(null);

		return areaSubproducto;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="subproducto")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().add(desperdicioCajonHarina);
		desperdicioCajonHarina.setSubproducto(this);

		return desperdicioCajonHarina;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().remove(desperdicioCajonHarina);
		desperdicioCajonHarina.setSubproducto(null);

		return desperdicioCajonHarina;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="subproducto")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setSubproducto(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setSubproducto(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="subproducto")
	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public LimpiezaDetalleDesperdicio addLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().add(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setSubproducto(this);

		return limpiezaDetalleDesperdicio;
	}

	public LimpiezaDetalleDesperdicio removeLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().remove(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setSubproducto(null);

		return limpiezaDetalleDesperdicio;
	}


	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}