package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_limpieza_subproducto_crudo database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_subproducto_crudo")
public class AtcLimpiezaSubproductoCrudo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezasubproductocrudo;

	private Integer cantidadmedio;

	private Timestamp fechareg;

	private double pesobruto;

	private double taracoche;

	private double taramedio;

	private String tipoingreso;

	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatclimpiezadetalleprocesolote")
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to AtcLimpiezaTipoSubproducto
	@ManyToOne
	@JoinColumn(name="idatclimpiezatiposubproducto")
	private AtcLimpiezaTipoSubproducto atcLimpiezaTipoSubproducto;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	public AtcLimpiezaSubproductoCrudo() {
	}

	public Long getIdatclimpiezasubproductocrudo() {
		return this.idatclimpiezasubproductocrudo;
	}

	public void setIdatclimpiezasubproductocrudo(Long idatclimpiezasubproductocrudo) {
		this.idatclimpiezasubproductocrudo = idatclimpiezasubproductocrudo;
	}

	public Integer getCantidadmedio() {
		return this.cantidadmedio;
	}

	public void setCantidadmedio(Integer cantidadmedio) {
		this.cantidadmedio = cantidadmedio;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public double getTaracoche() {
		return this.taracoche;
	}

	public void setTaracoche(double taracoche) {
		this.taracoche = taracoche;
	}

	public double getTaramedio() {
		return this.taramedio;
	}

	public void setTaramedio(double taramedio) {
		this.taramedio = taramedio;
	}

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public AtcLimpiezaDetalleProcesoLote getAtcLimpiezaDetalleProcesoLote() {
		return this.atcLimpiezaDetalleProcesoLote;
	}

	public void setAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		this.atcLimpiezaDetalleProcesoLote = atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaTipoSubproducto getAtcLimpiezaTipoSubproducto() {
		return this.atcLimpiezaTipoSubproducto;
	}

	public void setAtcLimpiezaTipoSubproducto(AtcLimpiezaTipoSubproducto atcLimpiezaTipoSubproducto) {
		this.atcLimpiezaTipoSubproducto = atcLimpiezaTipoSubproducto;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

}