package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_detalle_proceso_modificacion database table.
 * 
 */
@Entity
@Table(name="eviscerado_detalle_proceso_modificacion")
@NamedQuery(name="EvisceradoDetalleProcesoModificacion.findAll", query="SELECT e FROM EvisceradoDetalleProcesoModificacion e")
public class EvisceradoDetalleProcesoModificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradodetalleprocesomodificacion;
	private Integer estado;
	private Timestamp fechaactualizacion;
	private Timestamp fechafin;
	private Timestamp fechafinrackeo;
	private Timestamp fechainicio;
	private Timestamp fechainiciorackeo;
	private Timestamp fechareg;
	private Integer finrackeomanual;
	private String idusuarioactualizacion;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private EvisceradoProceso evisceradoProceso;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private Usuario usuario;

	public EvisceradoDetalleProcesoModificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradodetalleprocesomodificacion() {
		return this.idevisceradodetalleprocesomodificacion;
	}

	public void setIdevisceradodetalleprocesomodificacion(Long idevisceradodetalleprocesomodificacion) {
		this.idevisceradodetalleprocesomodificacion = idevisceradodetalleprocesomodificacion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}


	public Timestamp getFechafinrackeo() {
		return this.fechafinrackeo;
	}

	public void setFechafinrackeo(Timestamp fechafinrackeo) {
		this.fechafinrackeo = fechafinrackeo;
	}


	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}


	public Timestamp getFechainiciorackeo() {
		return this.fechainiciorackeo;
	}

	public void setFechainiciorackeo(Timestamp fechainiciorackeo) {
		this.fechainiciorackeo = fechainiciorackeo;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getFinrackeomanual() {
		return this.finrackeomanual;
	}

	public void setFinrackeomanual(Integer finrackeomanual) {
		this.finrackeomanual = finrackeomanual;
	}


	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
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