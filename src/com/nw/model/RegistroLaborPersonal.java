package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registro_labor_personal database table.
 * 
 */
@Entity
@Table(name="registro_labor_personal")
public class RegistroLaborPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idregistrolaborpersonal;

	private Long codigoordenfabricacion;

	private Integer idbarco;

	public RegistroLaborPersonal() {
	}

	public Long getIdregistrolaborpersonal() {
		return this.idregistrolaborpersonal;
	}

	public void setIdregistrolaborpersonal(Long idregistrolaborpersonal) {
		this.idregistrolaborpersonal = idregistrolaborpersonal;
	}

	public Long getCodigoordenfabricacion() {
		return this.codigoordenfabricacion;
	}

	public void setCodigoordenfabricacion(Long codigoordenfabricacion) {
		this.codigoordenfabricacion = codigoordenfabricacion;
	}

	public Integer getIdbarco() {
		return this.idbarco;
	}

	public void setIdbarco(Integer idbarco) {
		this.idbarco = idbarco;
	}

}