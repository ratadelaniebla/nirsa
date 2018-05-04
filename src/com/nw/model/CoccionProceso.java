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
@NamedQuery(name="CoccionProceso.findAll", query="SELECT c FROM CoccionProceso c")
public class CoccionProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcoccionproceso;
	private Integer estado;
	private Timestamp fechareg;
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;
	private ObservacionesProceso observacionesProceso;
	private Produccion produccion;
	private Usuario usuario;

	public CoccionProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="coccionProceso")
	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public CoccionDetalleProcesoCoche addCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().add(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setCoccionProceso(this);

		return coccionDetalleProcesoCoch;
	}

	public CoccionDetalleProcesoCoche removeCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().remove(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setCoccionProceso(null);

		return coccionDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}