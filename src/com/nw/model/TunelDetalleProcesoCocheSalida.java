package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tunel_detalle_proceso_coche_salida database table.
 * 
 */
@Entity
@Table(name="tunel_detalle_proceso_coche_salida")
@NamedQuery(name="TunelDetalleProcesoCocheSalida.findAll", query="SELECT t FROM TunelDetalleProcesoCocheSalida t")
public class TunelDetalleProcesoCocheSalida implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idtuneldetalleprocesocochesalida;
	private Boolean ajustado;
	private Integer cantidadajustada;
	private Integer cantidadfundasalida;
	private String cliente;
	private Integer codigosalido;
	private Integer estado;
	private Timestamp horarecepcion;
	private String numerocochesalido;
	private String tpesc;
	private Boolean verificado;
	private LonjasOrdenProduccion lonjasOrdenProduccion;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private TunelDetalleProcesoCoche tunelDetalleProcesoCoche;
	private Usuario usuario;

	public TunelDetalleProcesoCocheSalida() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdtuneldetalleprocesocochesalida() {
		return this.idtuneldetalleprocesocochesalida;
	}

	public void setIdtuneldetalleprocesocochesalida(Long idtuneldetalleprocesocochesalida) {
		this.idtuneldetalleprocesocochesalida = idtuneldetalleprocesocochesalida;
	}


	public Boolean getAjustado() {
		return this.ajustado;
	}

	public void setAjustado(Boolean ajustado) {
		this.ajustado = ajustado;
	}


	public Integer getCantidadajustada() {
		return this.cantidadajustada;
	}

	public void setCantidadajustada(Integer cantidadajustada) {
		this.cantidadajustada = cantidadajustada;
	}


	public Integer getCantidadfundasalida() {
		return this.cantidadfundasalida;
	}

	public void setCantidadfundasalida(Integer cantidadfundasalida) {
		this.cantidadfundasalida = cantidadfundasalida;
	}


	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public Integer getCodigosalido() {
		return this.codigosalido;
	}

	public void setCodigosalido(Integer codigosalido) {
		this.codigosalido = codigosalido;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getHorarecepcion() {
		return this.horarecepcion;
	}

	public void setHorarecepcion(Timestamp horarecepcion) {
		this.horarecepcion = horarecepcion;
	}


	public String getNumerocochesalido() {
		return this.numerocochesalido;
	}

	public void setNumerocochesalido(String numerocochesalido) {
		this.numerocochesalido = numerocochesalido;
	}


	public String getTpesc() {
		return this.tpesc;
	}

	public void setTpesc(String tpesc) {
		this.tpesc = tpesc;
	}


	public Boolean getVerificado() {
		return this.verificado;
	}

	public void setVerificado(Boolean verificado) {
		this.verificado = verificado;
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


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idtuneldetalleprocesocoche")
	public TunelDetalleProcesoCoche getTunelDetalleProcesoCoche() {
		return this.tunelDetalleProcesoCoche;
	}

	public void setTunelDetalleProcesoCoche(TunelDetalleProcesoCoche tunelDetalleProcesoCoche) {
		this.tunelDetalleProcesoCoche = tunelDetalleProcesoCoche;
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