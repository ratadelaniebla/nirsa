package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_medios_con_defecto_limpieza database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto_limpieza")
@NamedQuery(name="OeeDetalleMediosConDefectoLimpieza.findAll", query="SELECT o FROM OeeDetalleMediosConDefectoLimpieza o")
public class OeeDetalleMediosConDefectoLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeeDetalleMediosConDefectoLimpieza;
	private Area area;
	private LimpiezaLinea limpiezaLinea;
	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	public OeeDetalleMediosConDefectoLimpieza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto_limpieza")
	public Long getIdOeeDetalleMediosConDefectoLimpieza() {
		return this.idOeeDetalleMediosConDefectoLimpieza;
	}

	public void setIdOeeDetalleMediosConDefectoLimpieza(Long idOeeDetalleMediosConDefectoLimpieza) {
		this.idOeeDetalleMediosConDefectoLimpieza = idOeeDetalleMediosConDefectoLimpieza;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_detalle_medios_con_defecto")
	public OeeDetalleMediosConDefecto getOeeDetalleMediosConDefecto() {
		return this.oeeDetalleMediosConDefecto;
	}

	public void setOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		this.oeeDetalleMediosConDefecto = oeeDetalleMediosConDefecto;
	}

}