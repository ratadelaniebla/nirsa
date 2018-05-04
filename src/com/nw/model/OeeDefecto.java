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
@NamedQuery(name="OeeDefecto.findAll", query="SELECT o FROM OeeDefecto o")
public class OeeDefecto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOeeDefectos;
	private String abreviacion;
	private String descripcionDefecto;
	private Proceso proceso;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	public OeeDefecto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_defectos")
	public Integer getIdOeeDefectos() {
		return this.idOeeDefectos;
	}

	public void setIdOeeDefectos(Integer idOeeDefectos) {
		this.idOeeDefectos = idOeeDefectos;
	}


	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}


	@Column(name="descripcion_defecto")
	public String getDescripcionDefecto() {
		return this.descripcionDefecto;
	}

	public void setDescripcionDefecto(String descripcionDefecto) {
		this.descripcionDefecto = descripcionDefecto;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="oeeDefecto")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setOeeDefecto(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setOeeDefecto(null);

		return oeeDetalleMediosConDefecto;
	}

}