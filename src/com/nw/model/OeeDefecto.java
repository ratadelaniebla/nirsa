package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oee_defectos database table.
 * 
 */
@Entity
@Table(name="oee_defectos")
public class OeeDefecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_defectos")
	private Integer idOeeDefectos;

	@Column(name="descripcion_defecto")
	private String descripcionDefecto;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="oeeDefecto")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	public OeeDefecto() {
	}

	public Integer getIdOeeDefectos() {
		return this.idOeeDefectos;
	}

	public void setIdOeeDefectos(Integer idOeeDefectos) {
		this.idOeeDefectos = idOeeDefectos;
	}

	public String getDescripcionDefecto() {
		return this.descripcionDefecto;
	}

	public void setDescripcionDefecto(String descripcionDefecto) {
		this.descripcionDefecto = descripcionDefecto;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

}