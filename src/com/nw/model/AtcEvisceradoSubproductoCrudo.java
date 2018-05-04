package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_eviscerado_subproducto_crudo database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_subproducto_crudo")
@NamedQuery(name="AtcEvisceradoSubproductoCrudo.findAll", query="SELECT a FROM AtcEvisceradoSubproductoCrudo a")
public class AtcEvisceradoSubproductoCrudo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcevisceradosubproductocrudo;
	private Integer cantidadmedio;
	private Timestamp fechareg;
	private double pesobruto;
	private double taracoche;
	private double taramedio;
	private String tipoingreso;
	private AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote;
	private AtcEvisceradoTipoSubproducto atcEvisceradoTipoSubproducto;
	private AtcUsuario atcUsuario;
	private Cajon cajon;

	public AtcEvisceradoSubproductoCrudo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcevisceradosubproductocrudo() {
		return this.idatcevisceradosubproductocrudo;
	}

	public void setIdatcevisceradosubproductocrudo(Long idatcevisceradosubproductocrudo) {
		this.idatcevisceradosubproductocrudo = idatcevisceradosubproductocrudo;
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


	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatcevisceradodetalleprocesolote")
	public AtcEvisceradoDetalleProcesoLote getAtcEvisceradoDetalleProcesoLote() {
		return this.atcEvisceradoDetalleProcesoLote;
	}

	public void setAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		this.atcEvisceradoDetalleProcesoLote = atcEvisceradoDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcEvisceradoTipoSubproducto
	@ManyToOne
	@JoinColumn(name="idatcevisceradotiposubproducto")
	public AtcEvisceradoTipoSubproducto getAtcEvisceradoTipoSubproducto() {
		return this.atcEvisceradoTipoSubproducto;
	}

	public void setAtcEvisceradoTipoSubproducto(AtcEvisceradoTipoSubproducto atcEvisceradoTipoSubproducto) {
		this.atcEvisceradoTipoSubproducto = atcEvisceradoTipoSubproducto;
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