package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_medios_con_defecto_lonjas database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto_lonjas")
public class OeeDetalleMediosConDefectoLonja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto_lonjas")
	private Long idOeeDetalleMediosConDefectoLonjas;

	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	private LonjasLinea lonjasLinea;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_detalle_medios_con_defecto")
	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	public OeeDetalleMediosConDefectoLonja() {
	}

	public Long getIdOeeDetalleMediosConDefectoLonjas() {
		return this.idOeeDetalleMediosConDefectoLonjas;
	}

	public void setIdOeeDetalleMediosConDefectoLonjas(Long idOeeDetalleMediosConDefectoLonjas) {
		this.idOeeDetalleMediosConDefectoLonjas = idOeeDetalleMediosConDefectoLonjas;
	}

	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}

	public OeeDetalleMediosConDefecto getOeeDetalleMediosConDefecto() {
		return this.oeeDetalleMediosConDefecto;
	}

	public void setOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		this.oeeDetalleMediosConDefecto = oeeDetalleMediosConDefecto;
	}

}