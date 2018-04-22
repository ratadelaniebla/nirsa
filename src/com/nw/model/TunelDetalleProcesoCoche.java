package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tunel_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="tunel_detalle_proceso_coche")
public class TunelDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtuneldetalleprocesocoche;

	private Boolean ajustado;

	private Integer cantidadajustada;

	private Integer cantidadfundarecibida;

	private String cliente;

	private Integer codigorecibido;

	private Integer estado;

	private Timestamp horarecepcion;

	private String numerococherecibiddo;

	private String tpesc;

	private Boolean verificado;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesococheempacado")
	private LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	private LonjasOrdenProduccion lonjasOrdenProduccion;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="tunelDetalleProcesoCoche")
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	public TunelDetalleProcesoCoche() {
	}

	public Long getIdtuneldetalleprocesocoche() {
		return this.idtuneldetalleprocesocoche;
	}

	public void setIdtuneldetalleprocesocoche(Long idtuneldetalleprocesocoche) {
		this.idtuneldetalleprocesocoche = idtuneldetalleprocesocoche;
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

	public Integer getCantidadfundarecibida() {
		return this.cantidadfundarecibida;
	}

	public void setCantidadfundarecibida(Integer cantidadfundarecibida) {
		this.cantidadfundarecibida = cantidadfundarecibida;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getCodigorecibido() {
		return this.codigorecibido;
	}

	public void setCodigorecibido(Integer codigorecibido) {
		this.codigorecibido = codigorecibido;
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

	public String getNumerococherecibiddo() {
		return this.numerococherecibiddo;
	}

	public void setNumerococherecibiddo(String numerococherecibiddo) {
		this.numerococherecibiddo = numerococherecibiddo;
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

	public LonjasDetalleProcesoCocheEmpacado getLonjasDetalleProcesoCocheEmpacado() {
		return this.lonjasDetalleProcesoCocheEmpacado;
	}

	public void setLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		this.lonjasDetalleProcesoCocheEmpacado = lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

}