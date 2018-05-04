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
@NamedQuery(name="LonjasDetalleProcesoCocheEmpacado.findAll", query="SELECT l FROM LonjasDetalleProcesoCocheEmpacado l")
public class LonjasDetalleProcesoCocheEmpacado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasdetalleprocesococheempacado;
	private Integer cantidadfunda;
	private String cliente;
	private Integer codigo;
	private Integer estado;
	private Timestamp horaingresotunel;
	private String numerocoche;
	private String tpesc;
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;
	private LonjasOrdenProduccion lonjasOrdenProduccion;
	private LonjasProceso lonjasProceso;
	private LonjasTunel lonjasTunel;
	private Usuario usuario;
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;

	public LonjasDetalleProcesoCocheEmpacado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
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


	//bi-directional many-to-one association to LonjasTunel
	@ManyToOne
	@JoinColumn(name="idlonjastunel")
	public LonjasTunel getLonjasTunel() {
		return this.lonjasTunel;
	}

	public void setLonjasTunel(LonjasTunel lonjasTunel) {
		this.lonjasTunel = lonjasTunel;
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
	@OneToMany(mappedBy="lonjasDetalleProcesoCocheEmpacado")
	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public TunelDetalleProcesoCoche addTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().add(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setLonjasDetalleProcesoCocheEmpacado(this);

		return tunelDetalleProcesoCoch;
	}

	public TunelDetalleProcesoCoche removeTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().remove(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setLonjasDetalleProcesoCocheEmpacado(null);

		return tunelDetalleProcesoCoch;
	}

}