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
@NamedQuery(name="AtcUsuario.findAll", query="SELECT a FROM AtcUsuario a")
public class AtcUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idatcusuario;
	private String clave;
	private String usuario;
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;
	private List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps;
	private List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs;
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;
	private List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes;
	private AtcGrupo atcGrupo;

	public AtcUsuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public AtcDescongeladoDetalleProceso addAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().add(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcUsuario(this);

		return atcDescongeladoDetalleProceso;
	}

	public AtcDescongeladoDetalleProceso removeAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().remove(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcUsuario(null);

		return atcDescongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTemp
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcDescongeladoDetalleProcesoTemp> getAtcDescongeladoDetalleProcesoTemps() {
		return this.atcDescongeladoDetalleProcesoTemps;
	}

	public void setAtcDescongeladoDetalleProcesoTemps(List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps) {
		this.atcDescongeladoDetalleProcesoTemps = atcDescongeladoDetalleProcesoTemps;
	}

	public AtcDescongeladoDetalleProcesoTemp addAtcDescongeladoDetalleProcesoTemp(AtcDescongeladoDetalleProcesoTemp atcDescongeladoDetalleProcesoTemp) {
		getAtcDescongeladoDetalleProcesoTemps().add(atcDescongeladoDetalleProcesoTemp);
		atcDescongeladoDetalleProcesoTemp.setAtcUsuario(this);

		return atcDescongeladoDetalleProcesoTemp;
	}

	public AtcDescongeladoDetalleProcesoTemp removeAtcDescongeladoDetalleProcesoTemp(AtcDescongeladoDetalleProcesoTemp atcDescongeladoDetalleProcesoTemp) {
		getAtcDescongeladoDetalleProcesoTemps().remove(atcDescongeladoDetalleProcesoTemp);
		atcDescongeladoDetalleProcesoTemp.setAtcUsuario(null);

		return atcDescongeladoDetalleProcesoTemp;
	}


	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcDescongeladoDetalleProcesoTempIng> getAtcDescongeladoDetalleProcesoTempIngs() {
		return this.atcDescongeladoDetalleProcesoTempIngs;
	}

	public void setAtcDescongeladoDetalleProcesoTempIngs(List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs) {
		this.atcDescongeladoDetalleProcesoTempIngs = atcDescongeladoDetalleProcesoTempIngs;
	}

	public AtcDescongeladoDetalleProcesoTempIng addAtcDescongeladoDetalleProcesoTempIng(AtcDescongeladoDetalleProcesoTempIng atcDescongeladoDetalleProcesoTempIng) {
		getAtcDescongeladoDetalleProcesoTempIngs().add(atcDescongeladoDetalleProcesoTempIng);
		atcDescongeladoDetalleProcesoTempIng.setAtcUsuario(this);

		return atcDescongeladoDetalleProcesoTempIng;
	}

	public AtcDescongeladoDetalleProcesoTempIng removeAtcDescongeladoDetalleProcesoTempIng(AtcDescongeladoDetalleProcesoTempIng atcDescongeladoDetalleProcesoTempIng) {
		getAtcDescongeladoDetalleProcesoTempIngs().remove(atcDescongeladoDetalleProcesoTempIng);
		atcDescongeladoDetalleProcesoTempIng.setAtcUsuario(null);

		return atcDescongeladoDetalleProcesoTempIng;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public AtcEvisceradoDetalleProcesoLote addAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().add(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcUsuario(this);

		return atcEvisceradoDetalleProcesoLote;
	}

	public AtcEvisceradoDetalleProcesoLote removeAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().remove(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcUsuario(null);

		return atcEvisceradoDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public AtcEvisceradoDetalleTempPanza addAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().add(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcUsuario(this);

		return atcEvisceradoDetalleTempPanza;
	}

	public AtcEvisceradoDetalleTempPanza removeAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().remove(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcUsuario(null);

		return atcEvisceradoDetalleTempPanza;
	}


	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public AtcEvisceradoSubproductoCrudo addAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().add(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcUsuario(this);

		return atcEvisceradoSubproductoCrudo;
	}

	public AtcEvisceradoSubproductoCrudo removeAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().remove(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcUsuario(null);

		return atcEvisceradoSubproductoCrudo;
	}


	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

	public AtcEvisceradoTempPanza addAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().add(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcUsuario(this);

		return atcEvisceradoTempPanza;
	}

	public AtcEvisceradoTempPanza removeAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().remove(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcUsuario(null);

		return atcEvisceradoTempPanza;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcUsuario(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcUsuario(null);

		return atcLimpiezaDetalleBandeja;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public AtcLimpiezaDetalleProcesoLote addAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().add(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcUsuario(this);

		return atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaDetalleProcesoLote removeAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().remove(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcUsuario(null);

		return atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public AtcLimpiezaDetalleTempAguaLav addAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().add(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcUsuario(this);

		return atcLimpiezaDetalleTempAguaLav;
	}

	public AtcLimpiezaDetalleTempAguaLav removeAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().remove(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcUsuario(null);

		return atcLimpiezaDetalleTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public AtcLimpiezaDetalleTempLomo addAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().add(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcUsuario(this);

		return atcLimpiezaDetalleTempLomo;
	}

	public AtcLimpiezaDetalleTempLomo removeAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().remove(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcUsuario(null);

		return atcLimpiezaDetalleTempLomo;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public AtcLimpiezaProceso addAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().add(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcUsuario(this);

		return atcLimpiezaProceso;
	}

	public AtcLimpiezaProceso removeAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().remove(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcUsuario(null);

		return atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public AtcLimpiezaProcesoEmpleado addAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().add(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcUsuario(this);

		return atcLimpiezaProcesoEmpleado;
	}

	public AtcLimpiezaProcesoEmpleado removeAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().remove(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcUsuario(null);

		return atcLimpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

	public AtcLimpiezaSubproductoCrudo addAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().add(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setAtcUsuario(this);

		return atcLimpiezaSubproductoCrudo;
	}

	public AtcLimpiezaSubproductoCrudo removeAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().remove(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setAtcUsuario(null);

		return atcLimpiezaSubproductoCrudo;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public AtcLimpiezaTempAguaLav addAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().add(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcUsuario(this);

		return atcLimpiezaTempAguaLav;
	}

	public AtcLimpiezaTempAguaLav removeAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().remove(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcUsuario(null);

		return atcLimpiezaTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

	public AtcLimpiezaTempLomo addAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().add(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcUsuario(this);

		return atcLimpiezaTempLomo;
	}

	public AtcLimpiezaTempLomo removeAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().remove(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcUsuario(null);

		return atcLimpiezaTempLomo;
	}


	//bi-directional many-to-one association to AtcProduccionArchivoCargaLote
	@OneToMany(mappedBy="atcUsuario")
	public List<AtcProduccionArchivoCargaLote> getAtcProduccionArchivoCargaLotes() {
		return this.atcProduccionArchivoCargaLotes;
	}

	public void setAtcProduccionArchivoCargaLotes(List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes) {
		this.atcProduccionArchivoCargaLotes = atcProduccionArchivoCargaLotes;
	}

	public AtcProduccionArchivoCargaLote addAtcProduccionArchivoCargaLote(AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote) {
		getAtcProduccionArchivoCargaLotes().add(atcProduccionArchivoCargaLote);
		atcProduccionArchivoCargaLote.setAtcUsuario(this);

		return atcProduccionArchivoCargaLote;
	}

	public AtcProduccionArchivoCargaLote removeAtcProduccionArchivoCargaLote(AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote) {
		getAtcProduccionArchivoCargaLotes().remove(atcProduccionArchivoCargaLote);
		atcProduccionArchivoCargaLote.setAtcUsuario(null);

		return atcProduccionArchivoCargaLote;
	}


	//bi-directional many-to-one association to AtcGrupo
	@ManyToOne
	@JoinColumn(name="idatcgrupo")
	public AtcGrupo getAtcGrupo() {
		return this.atcGrupo;
	}

	public void setAtcGrupo(AtcGrupo atcGrupo) {
		this.atcGrupo = atcGrupo;
	}

}