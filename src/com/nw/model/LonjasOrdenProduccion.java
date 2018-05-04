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
@NamedQuery(name="LonjasOrdenProduccion.findAll", query="SELECT l FROM LonjasOrdenProduccion l")
public class LonjasOrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasordenproduccion;
	private String cliente;
	private Integer estado;
	private Timestamp fecharegistro;
	private String idtipoempaque;
	private String ordendeproduccion;
	private String ordenfabricacionfunda;
	private double pesofunda;
	private String producto;
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private LonjasProceso lonjasProceso;
	private Usuario usuario;
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	public LonjasOrdenProduccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public LonjasDetalleProcesoCocheEmpacado addLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().add(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasOrdenProduccion(this);

		return lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasDetalleProcesoCocheEmpacado removeLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().remove(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasOrdenProduccion(null);

		return lonjasDetalleProcesoCocheEmpacado;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasOrdenProduccion(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasOrdenProduccion(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasOrdenProduccion(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasOrdenProduccion(null);

		return lonjasDetalleProcesoEmpaque;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasOrdenProduccion(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasOrdenProduccion(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
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


	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public TunelDetalleProcesoCoche addTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().add(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setLonjasOrdenProduccion(this);

		return tunelDetalleProcesoCoch;
	}

	public TunelDetalleProcesoCoche removeTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().remove(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setLonjasOrdenProduccion(null);

		return tunelDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="lonjasOrdenProduccion")
	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

	public TunelDetalleProcesoCocheSalida addTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().add(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setLonjasOrdenProduccion(this);

		return tunelDetalleProcesoCocheSalida;
	}

	public TunelDetalleProcesoCocheSalida removeTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().remove(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setLonjasOrdenProduccion(null);

		return tunelDetalleProcesoCocheSalida;
	}

}