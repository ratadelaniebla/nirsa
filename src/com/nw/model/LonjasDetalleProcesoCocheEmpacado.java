package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lonjas_detalle_proceso_coche_empacado database table.
 * 
 */
@Entity
@Table(name="lonjas_detalle_proceso_coche_empacado")
public class LonjasDetalleProcesoCocheEmpacado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasdetalleprocesococheempacado;

	private Integer cantidadfunda;

	private String cliente;

	private Integer codigo;

	private Integer estado;

	private Timestamp horaingresotunel;

	private String numerocoche;

	private String tpesc;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	private LonjasOrdenProduccion lonjasOrdenProduccion;

	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	private LonjasProceso lonjasProceso;

	//bi-directional many-to-one association to LonjasTunel
	@ManyToOne
	@JoinColumn(name="idlonjastunel")
	private LonjasTunel lonjasTunel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasDetalleProcesoCocheEmpacado")
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;

	public LonjasDetalleProcesoCocheEmpacado() {
	}

	public Long getIdlonjasdetalleprocesococheempacado() {
		return this.idlonjasdetalleprocesococheempacado;
	}

	public void setIdlonjasdetalleprocesococheempacado(Long idlonjasdetalleprocesococheempacado) {
		this.idlonjasdetalleprocesococheempacado = idlonjasdetalleprocesococheempacado;
	}

	public Integer getCantidadfunda() {
		return this.cantidadfunda;
	}

	public void setCantidadfunda(Integer cantidadfunda) {
		this.cantidadfunda = cantidadfunda;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getHoraingresotunel() {
		return this.horaingresotunel;
	}

	public void setHoraingresotunel(Timestamp horaingresotunel) {
		this.horaingresotunel = horaingresotunel;
	}

	public String getNumerocoche() {
		return this.numerocoche;
	}

	public void setNumerocoche(String numerocoche) {
		this.numerocoche = numerocoche;
	}

	public String getTpesc() {
		return this.tpesc;
	}

	public void setTpesc(String tpesc) {
		this.tpesc = tpesc;
	}

	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}

	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}

	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
	}

	public LonjasTunel getLonjasTunel() {
		return this.lonjasTunel;
	}

	public void setLonjasTunel(LonjasTunel lonjasTunel) {
		this.lonjasTunel = lonjasTunel;
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

}