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
@NamedQuery(name="EvisceradoDetalleProceso.findAll", query="SELECT e FROM EvisceradoDetalleProceso e")
public class EvisceradoDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private EvisceradoProceso evisceradoProceso;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private Usuario usuario;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;
	private List<RociadoCicloDetalle> rociadoCicloDetalles;
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public EvisceradoDetalleProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado addCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().add(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setEvisceradoDetalleProceso(this);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado removeCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().remove(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setEvisceradoDetalleProceso(null);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}


	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public CuartoChillroomCocinadaDetalle addCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().add(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setEvisceradoDetalleProceso(this);

		return cuartoChillroomCocinadaDetalle;
	}

	public CuartoChillroomCocinadaDetalle removeCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().remove(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setEvisceradoDetalleProceso(null);

		return cuartoChillroomCocinadaDetalle;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoDetalleProceso(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoDetalleProceso(null);

		return evisceradoCocheModificacion;
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


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoDetalleProceso(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoDetalleProceso(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public EvisceradoDetalleProcesoModificacion addEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().add(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setEvisceradoDetalleProceso(this);

		return evisceradoDetalleProcesoModificacion;
	}

	public EvisceradoDetalleProcesoModificacion removeEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().remove(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setEvisceradoDetalleProceso(null);

		return evisceradoDetalleProcesoModificacion;
	}


	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public EvisceradoSubproductoCrudo addEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().add(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setEvisceradoDetalleProceso(this);

		return evisceradoSubproductoCrudo;
	}

	public EvisceradoSubproductoCrudo removeEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().remove(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setEvisceradoDetalleProceso(null);

		return evisceradoSubproductoCrudo;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public PanzasDetalleProcesoLote addPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().add(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setEvisceradoDetalleProceso(this);

		return panzasDetalleProcesoLote;
	}

	public PanzasDetalleProcesoLote removePanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().remove(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setEvisceradoDetalleProceso(null);

		return panzasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

	public RociadoCicloDetalle addRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().add(rociadoCicloDetalle);
		rociadoCicloDetalle.setEvisceradoDetalleProceso(this);

		return rociadoCicloDetalle;
	}

	public RociadoCicloDetalle removeRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().remove(rociadoCicloDetalle);
		rociadoCicloDetalle.setEvisceradoDetalleProceso(null);

		return rociadoCicloDetalle;
	}


	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="evisceradoDetalleProceso")
	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

	public RociadoCocinadaDetalle addRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().add(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setEvisceradoDetalleProceso(this);

		return rociadoCocinadaDetalle;
	}

	public RociadoCocinadaDetalle removeRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().remove(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setEvisceradoDetalleProceso(null);

		return rociadoCocinadaDetalle;
	}

}