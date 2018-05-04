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
@NamedQuery(name="AtcLimpiezaSubproductoCrudo.findAll", query="SELECT a FROM AtcLimpiezaSubproductoCrudo a")
public class AtcLimpiezaSubproductoCrudo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezasubproductocrudo;
	private Integer cantidadmedio;
	private Timestamp fechareg;
	private double pesobruto;
	private double taracoche;
	private double taramedio;
	private String tipoingreso;
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;
	private AtcLimpiezaTipoSubproducto atcLimpiezaTipoSubproducto;
	private AtcUsuario atcUsuario;
	private Cajon cajon;

	public AtcLimpiezaSubproductoCrudo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatclimpiezadetalleprocesolote")
	public AtcLimpiezaDetalleProcesoLote getAtcLimpiezaDetalleProcesoLote() {
		return this.atcLimpiezaDetalleProcesoLote;
	}

	public void setAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		this.atcLimpiezaDetalleProcesoLote = atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcLimpiezaTipoSubproducto
	@ManyToOne
	@JoinColumn(name="idatclimpiezatiposubproducto")
	public AtcLimpiezaTipoSubproducto getAtcLimpiezaTipoSubproducto() {
		return this.atcLimpiezaTipoSubproducto;
	}

	public void setAtcLimpiezaTipoSubproducto(AtcLimpiezaTipoSubproducto atcLimpiezaTipoSubproducto) {
		this.atcLimpiezaTipoSubproducto = atcLimpiezaTipoSubproducto;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}


	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

}