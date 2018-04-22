package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idarea;

	private Integer desperdicio;

	private String nombre;

	//bi-directional many-to-one association to Planta
	@ManyToOne
	@JoinColumn(name="idplanta")
	private Planta planta;

	//bi-directional many-to-one association to Procedencia
	@ManyToOne
	@JoinColumn(name="idprocedencia")
	private Procedencia procedencia;

	//bi-directional many-to-one association to AreaProceso
	@OneToMany(mappedBy="area")
	private List<AreaProceso> areaProcesos;

	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="area")
	private List<AreaSubproducto> areaSubproductos;

	//bi-directional many-to-one association to Balanza
	@OneToMany(mappedBy="area")
	private List<Balanza> balanzas;

	//bi-directional many-to-one association to Cajon
	@OneToMany(mappedBy="area")
	private List<Cajon> cajons;

	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="area")
	private List<ControlFichaBatch> controlFichaBatches;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="area")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="area")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="area")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to Lugar
	@OneToMany(mappedBy="area")
	private List<Lugar> lugars;

	//bi-directional many-to-one association to LugarDetalle
	@OneToMany(mappedBy="area")
	private List<LugarDetalle> lugarDetalles;

	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="area")
	private List<TurnoGestionDetalle> turnoGestionDetalles;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="area")
	private List<Usuario> usuarios;

	public Area() {
	}

	public Integer getIdarea() {
		return this.idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getDesperdicio() {
		return this.desperdicio;
	}

	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Planta getPlanta() {
		return this.planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Procedencia getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}

	public List<AreaProceso> getAreaProcesos() {
		return this.areaProcesos;
	}

	public void setAreaProcesos(List<AreaProceso> areaProcesos) {
		this.areaProcesos = areaProcesos;
	}

	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
	}

	public List<Balanza> getBalanzas() {
		return this.balanzas;
	}

	public void setBalanzas(List<Balanza> balanzas) {
		this.balanzas = balanzas;
	}

	public List<Cajon> getCajons() {
		return this.cajons;
	}

	public void setCajons(List<Cajon> cajons) {
		this.cajons = cajons;
	}

	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
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

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<Lugar> getLugars() {
		return this.lugars;
	}

	public void setLugars(List<Lugar> lugars) {
		this.lugars = lugars;
	}

	public List<LugarDetalle> getLugarDetalles() {
		return this.lugarDetalles;
	}

	public void setLugarDetalles(List<LugarDetalle> lugarDetalles) {
		this.lugarDetalles = lugarDetalles;
	}

	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}