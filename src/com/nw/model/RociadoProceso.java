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
@NamedQuery(name="RociadoProceso.findAll", query="SELECT r FROM RociadoProceso r")
public class RociadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrociadoproceso;
	private Integer estado;
	private Timestamp fechareg;
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;
	private ObservacionesProceso observacionesProceso;
	private Produccion produccion;
	private Usuario usuario;

	public RociadoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="rociadoProceso")
	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public RociadoDetalleProcesoCoche addRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().add(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setRociadoProceso(this);

		return rociadoDetalleProcesoCoch;
	}

	public RociadoDetalleProcesoCoche removeRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().remove(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setRociadoProceso(null);

		return rociadoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="rociadoProceso")
	public List<RociadoMuestreoTempCoche> getRociadoMuestreoTempCoches() {
		return this.rociadoMuestreoTempCoches;
	}

	public void setRociadoMuestreoTempCoches(List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches) {
		this.rociadoMuestreoTempCoches = rociadoMuestreoTempCoches;
	}

	public RociadoMuestreoTempCoche addRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().add(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setRociadoProceso(this);

		return rociadoMuestreoTempCoch;
	}

	public RociadoMuestreoTempCoche removeRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().remove(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setRociadoProceso(null);

		return rociadoMuestreoTempCoch;
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