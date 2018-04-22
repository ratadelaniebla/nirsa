package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lonjas_orden_produccion database table.
 * 
 */
@Entity
@Table(name="lonjas_orden_produccion")
public class LonjasOrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasordenproduccion;

	private String cliente;

	private Integer estado;

	private Timestamp fecharegistro;

	private String idtipoempaque;

	private String ordendeproduccion;

	private String ordenfabricacionfunda;

	private double pesofunda;

	private String producto;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	private LonjasProceso lonjasProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;

	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	public LonjasOrdenProduccion() {
	}

	public Long getIdlonjasordenproduccion() {
		return this.idlonjasordenproduccion;
	}

	public void setIdlonjasordenproduccion(Long idlonjasordenproduccion) {
		this.idlonjasordenproduccion = idlonjasordenproduccion;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getIdtipoempaque() {
		return this.idtipoempaque;
	}

	public void setIdtipoempaque(String idtipoempaque) {
		this.idtipoempaque = idtipoempaque;
	}

	public String getOrdendeproduccion() {
		return this.ordendeproduccion;
	}

	public void setOrdendeproduccion(String ordendeproduccion) {
		this.ordendeproduccion = ordendeproduccion;
	}

	public String getOrdenfabricacionfunda() {
		return this.ordenfabricacionfunda;
	}

	public void setOrdenfabricacionfunda(String ordenfabricacionfunda) {
		this.ordenfabricacionfunda = ordenfabricacionfunda;
	}

	public double getPesofunda() {
		return this.pesofunda;
	}

	public void setPesofunda(double pesofunda) {
		this.pesofunda = pesofunda;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

}