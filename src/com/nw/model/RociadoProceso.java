package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rociado_proceso database table.
 * 
 */
@Entity
@Table(name="rociado_proceso")
public class RociadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadoproceso;

	private Integer estado;

	private Timestamp fechareg;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="rociadoProceso")
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="rociadoProceso")
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;

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

	public RociadoProceso() {
	}

	public Long getIdrociadoproceso() {
		return this.idrociadoproceso;
	}

	public void setIdrociadoproceso(Long idrociadoproceso) {
		this.idrociadoproceso = idrociadoproceso;
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

	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public List<RociadoMuestreoTempCoche> getRociadoMuestreoTempCoches() {
		return this.rociadoMuestreoTempCoches;
	}

	public void setRociadoMuestreoTempCoches(List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches) {
		this.rociadoMuestreoTempCoches = rociadoMuestreoTempCoches;
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