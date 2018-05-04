package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_medios_con_defecto_envasado database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto_envasado")
@NamedQuery(name="OeeDetalleMediosConDefectoEnvasado.findAll", query="SELECT o FROM OeeDetalleMediosConDefectoEnvasado o")
public class OeeDetalleMediosConDefectoEnvasado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idoeedetallemedioscondefectoenvasado;
	private Luthy luthy;
	private MaquinaCerradora maquinaCerradora;
	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	public OeeDetalleMediosConDefectoEnvasado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdoeedetallemedioscondefectoenvasado() {
		return this.idoeedetallemedioscondefectoenvasado;
	}

	public void setIdoeedetallemedioscondefectoenvasado(Long idoeedetallemedioscondefectoenvasado) {
		this.idoeedetallemedioscondefectoenvasado = idoeedetallemedioscondefectoenvasado;
	}


	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}


	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@ManyToOne
	@JoinColumn(name="idoeedetallemedioscondefecto")
	public OeeDetalleMediosConDefecto getOeeDetalleMediosConDefecto() {
		return this.oeeDetalleMediosConDefecto;
	}

	public void setOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		this.oeeDetalleMediosConDefecto = oeeDetalleMediosConDefecto;
	}

}