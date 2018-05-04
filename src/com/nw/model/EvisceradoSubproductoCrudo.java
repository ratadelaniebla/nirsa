package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_subproducto_crudo database table.
 * 
 */
@Entity
@Table(name="eviscerado_subproducto_crudo")
@NamedQuery(name="EvisceradoSubproductoCrudo.findAll", query="SELECT e FROM EvisceradoSubproductoCrudo e")
public class EvisceradoSubproductoCrudo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradosubproductocrudo;
	private Integer cantidadmedio;
	private Timestamp fechareg;
	private double pesobruto;
	private double taracoche;
	private double taramedio;
	private String tipoingreso;
	private Cajon cajon;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private EvisceradoTipoSubproducto evisceradoTipoSubproducto;
	private Usuario usuario;

	public EvisceradoSubproductoCrudo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradosubproductocrudo() {
		return this.idevisceradosubproductocrudo;
	}

	public void setIdevisceradosubproductocrudo(Long idevisceradosubproductocrudo) {
		this.idevisceradosubproductocrudo = idevisceradosubproductocrudo;
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


	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoTipoSubproducto
	@ManyToOne
	@JoinColumn(name="idevisceradotiposubproducto")
	public EvisceradoTipoSubproducto getEvisceradoTipoSubproducto() {
		return this.evisceradoTipoSubproducto;
	}

	public void setEvisceradoTipoSubproducto(EvisceradoTipoSubproducto evisceradoTipoSubproducto) {
		this.evisceradoTipoSubproducto = evisceradoTipoSubproducto;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}