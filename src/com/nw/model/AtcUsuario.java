package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_usuario database table.
 * 
 */
@Entity
@Table(name="atc_usuario")
public class AtcUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idatcusuario;

	private String clave;

	private String usuario;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTemp
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs;

	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;

	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;

	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;

	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;

	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;

	//bi-directional many-to-one association to AtcProduccionArchivoCargaLote
	@OneToMany(mappedBy="atcUsuario")
	private List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes;

	//bi-directional many-to-one association to AtcGrupo
	@ManyToOne
	@JoinColumn(name="idatcgrupo")
	private AtcGrupo atcGrupo;

	public AtcUsuario() {
	}

	public String getIdatcusuario() {
		return this.idatcusuario;
	}

	public void setIdatcusuario(String idatcusuario) {
		this.idatcusuario = idatcusuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public List<AtcDescongeladoDetalleProcesoTemp> getAtcDescongeladoDetalleProcesoTemps() {
		return this.atcDescongeladoDetalleProcesoTemps;
	}

	public void setAtcDescongeladoDetalleProcesoTemps(List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps) {
		this.atcDescongeladoDetalleProcesoTemps = atcDescongeladoDetalleProcesoTemps;
	}

	public List<AtcDescongeladoDetalleProcesoTempIng> getAtcDescongeladoDetalleProcesoTempIngs() {
		return this.atcDescongeladoDetalleProcesoTempIngs;
	}

	public void setAtcDescongeladoDetalleProcesoTempIngs(List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs) {
		this.atcDescongeladoDetalleProcesoTempIngs = atcDescongeladoDetalleProcesoTempIngs;
	}

	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

	public List<AtcProduccionArchivoCargaLote> getAtcProduccionArchivoCargaLotes() {
		return this.atcProduccionArchivoCargaLotes;
	}

	public void setAtcProduccionArchivoCargaLotes(List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes) {
		this.atcProduccionArchivoCargaLotes = atcProduccionArchivoCargaLotes;
	}

	public AtcGrupo getAtcGrupo() {
		return this.atcGrupo;
	}

	public void setAtcGrupo(AtcGrupo atcGrupo) {
		this.atcGrupo = atcGrupo;
	}

}