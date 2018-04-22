package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the eviscerado_detalle_proceso database table.
 * 
 */
@Entity
@Table(name="eviscerado_detalle_proceso")
public class EvisceradoDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradodetalleproceso;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Timestamp fechafin;

	private Timestamp fechafinrackeo;

	private Timestamp fechainicio;

	private Timestamp fechainiciorackeo;

	private Timestamp fechareg;

	private Integer finrackeomanual;

	private String idusuarioactualizacion;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;

	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	private EvisceradoProceso evisceradoProceso;

	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;

	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;

	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;

	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<RociadoCicloDetalle> rociadoCicloDetalles;

	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public EvisceradoDetalleProceso() {
	}

	public Long getIdevisceradodetalleproceso() {
		return this.idevisceradodetalleproceso;
	}

	public void setIdevisceradodetalleproceso(Long idevisceradodetalleproceso) {
		this.idevisceradodetalleproceso = idevisceradodetalleproceso;
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

	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
	}

	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

}