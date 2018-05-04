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
@NamedQuery(name="ProduccionDetalleLoteCajon.findAll", query="SELECT p FROM ProduccionDetalleLoteCajon p")
public class ProduccionDetalleLoteCajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproducciondetallelotecajon;
	private Integer estado;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;
	private CamaraCajon camaraCajon;
	private ProduccionDetalleLote produccionDetalleLote;

	public ProduccionDetalleLoteCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setProduccionDetalleLoteCajon(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setProduccionDetalleLoteCajon(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setProduccionDetalleLoteCajon(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setProduccionDetalleLoteCajon(null);

		return descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public EvisceradoDetalleProceso addEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().add(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setProduccionDetalleLoteCajon(this);

		return evisceradoDetalleProceso;
	}

	public EvisceradoDetalleProceso removeEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().remove(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setProduccionDetalleLoteCajon(null);

		return evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public EvisceradoDetalleProcesoModificacion addEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().add(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setProduccionDetalleLoteCajon(this);

		return evisceradoDetalleProcesoModificacion;
	}

	public EvisceradoDetalleProcesoModificacion removeEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().remove(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setProduccionDetalleLoteCajon(null);

		return evisceradoDetalleProcesoModificacion;
	}


	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="produccionDetalleLoteCajon")
	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

	public EvisceradoRackeoLote addEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().add(evisceradoRackeoLote);
		evisceradoRackeoLote.setProduccionDetalleLoteCajon(this);

		return evisceradoRackeoLote;
	}

	public EvisceradoRackeoLote removeEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().remove(evisceradoRackeoLote);
		evisceradoRackeoLote.setProduccionDetalleLoteCajon(null);

		return evisceradoRackeoLote;
	}


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
	}

}