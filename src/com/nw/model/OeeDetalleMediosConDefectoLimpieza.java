package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_medios_con_defecto_limpieza database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto_limpieza")
public class OeeDetalleMediosConDefectoLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto_limpieza")
	private Long idOeeDetalleMediosConDefectoLimpieza;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_detalle_medios_con_defecto")
	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	public OeeDetalleMediosConDefectoLimpieza() {
	}

	public Long getIdOeeDetalleMediosConDefectoLimpieza() {
		return this.idOeeDetalleMediosConDefectoLimpieza;
	}

	public void setIdOeeDetalleMediosConDefectoLimpieza(Long idOeeDetalleMediosConDefectoLimpieza) {
		this.idOeeDetalleMediosConDefectoLimpieza = idOeeDetalleMediosConDefectoLimpieza;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public OeeDetalleMediosConDefecto getOeeDetalleMediosConDefecto() {
		return this.oeeDetalleMediosConDefecto;
	}

	public void setOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		this.oeeDetalleMediosConDefecto = oeeDetalleMediosConDefecto;
	}

}