package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the desperdicio_control_desperdicio database table.
 * 
 */
@Entity
@Table(name="desperdicio_control_desperdicio")
@NamedQuery(name="DesperdicioControlDesperdicio.findAll", query="SELECT d FROM DesperdicioControlDesperdicio d")
public class DesperdicioControlDesperdicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcontroldesperdicio;

	public DesperdicioControlDesperdicio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcontroldesperdicio() {
		return this.idcontroldesperdicio;
	}

	public void setIdcontroldesperdicio(Integer idcontroldesperdicio) {
		this.idcontroldesperdicio = idcontroldesperdicio;
	}

}