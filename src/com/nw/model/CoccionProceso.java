package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_proceso database table.
 * 
 */
@Entity
@Table(name="coccion_proceso")
public class CoccionProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcoccionproceso;

	private Integer estado;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="coccionProceso")
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;

	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	private ObservacionesProceso observacionesProceso;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CoccionProceso() {
	}

	public Long getIdcoccionproceso() {
		return this.idcoccionproceso;
	}

	public void setIdcoccionproceso(Long idcoccionproceso) {
		this.idcoccionproceso = idcoccionproceso;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}