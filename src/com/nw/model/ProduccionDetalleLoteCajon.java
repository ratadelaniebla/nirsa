package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produccion_detalle_lote_cajon database table.
 * 
 */
@Entity
@Table(name="produccion_detalle_lote_cajon")
public class ProduccionDetalleLoteCajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproducciondetallelotecajon;

	private Integer estado;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;

	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	private ProduccionDetalleLote produccionDetalleLote;

	public ProduccionDetalleLoteCajon() {
	}

	public Long getIdproducciondetallelotecajon() {
		return this.idproducciondetallelotecajon;
	}

	public void setIdproducciondetallelotecajon(Long idproducciondetallelotecajon) {
		this.idproducciondetallelotecajon = idproducciondetallelotecajon;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
	}

}