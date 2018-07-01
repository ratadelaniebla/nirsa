package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the esterilizado_tipo_coche database table.
 * 
 */
@Entity
@Table(name="esterilizado_tipo_coche")
@NamedQuery(name="EsterilizadoTipoCoche.findAll", query="SELECT e FROM EsterilizadoTipoCoche e")
public class EsterilizadoTipoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idesterilizadotipocoche;
	private String codigo;
	private String descripcion;
	private List<EsterilizadoCoche> esterilizadoCoches;

	public EsterilizadoTipoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdesterilizadotipocoche() {
		return this.idesterilizadotipocoche;
	}

	public void setIdesterilizadotipocoche(Integer idesterilizadotipocoche) {
		this.idesterilizadotipocoche = idesterilizadotipocoche;
	}


	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EsterilizadoCoche
	@OneToMany(mappedBy="esterilizadoTipoCoche")
	public List<EsterilizadoCoche> getEsterilizadoCoches() {
		return this.esterilizadoCoches;
	}

	public void setEsterilizadoCoches(List<EsterilizadoCoche> esterilizadoCoches) {
		this.esterilizadoCoches = esterilizadoCoches;
	}

	public EsterilizadoCoche addEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().add(esterilizadoCoch);
		esterilizadoCoch.setEsterilizadoTipoCoche(this);

		return esterilizadoCoch;
	}

	public EsterilizadoCoche removeEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().remove(esterilizadoCoch);
		esterilizadoCoch.setEsterilizadoTipoCoche(null);

		return esterilizadoCoch;
	}

}