package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the descongelado_semaforo_control database table.
 * 
 */
@Entity
@Table(name="descongelado_semaforo_control")
public class DescongeladoSemaforoControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddescongeladosemaforocontrol;

	private String codigocolor;

	private String descripcion;

	//bi-directional many-to-one association to DescongeladoDetalleDuchaTallaMonitoreo
	@OneToMany(mappedBy="descongeladoSemaforoControl")
	private List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos;

	public DescongeladoSemaforoControl() {
	}

	public Integer getIddescongeladosemaforocontrol() {
		return this.iddescongeladosemaforocontrol;
	}

	public void setIddescongeladosemaforocontrol(Integer iddescongeladosemaforocontrol) {
		this.iddescongeladosemaforocontrol = iddescongeladosemaforocontrol;
	}

	public String getCodigocolor() {
		return this.codigocolor;
	}

	public void setCodigocolor(String codigocolor) {
		this.codigocolor = codigocolor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DescongeladoDetalleDuchaTallaMonitoreo> getDescongeladoDetalleDuchaTallaMonitoreos() {
		return this.descongeladoDetalleDuchaTallaMonitoreos;
	}

	public void setDescongeladoDetalleDuchaTallaMonitoreos(List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos) {
		this.descongeladoDetalleDuchaTallaMonitoreos = descongeladoDetalleDuchaTallaMonitoreos;
	}

}