package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the desperdicio_control_desperdicio database table.
 * 
 */
@Entity
@Table(name="desperdicio_control_desperdicio")
public class DesperdicioControlDesperdicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcontroldesperdicio;

	public DesperdicioControlDesperdicio() {
	}

	public Integer getIdcontroldesperdicio() {
		return this.idcontroldesperdicio;
	}

	public void setIdcontroldesperdicio(Integer idcontroldesperdicio) {
		this.idcontroldesperdicio = idcontroldesperdicio;
	}

}