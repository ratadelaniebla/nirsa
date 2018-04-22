package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_asignacion_canastilla database table.
 * 
 */
@Entity
@Table(name="limpieza_asignacion_canastilla")
public class LimpiezaAsignacionCanastilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaasignacioncanastilla;

	private String codigodebarras;

	private String codigoempleado;

	private Timestamp fechareg;

	private Integer pescadosporlata;

	private Integer secuencia;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesocoche")
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejado
	@OneToMany(mappedBy="limpiezaAsignacionCanastilla")
	private List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados;

	public LimpiezaAsignacionCanastilla() {
	}

	public Long getIdlimpiezaasignacioncanastilla() {
		return this.idlimpiezaasignacioncanastilla;
	}

	public void setIdlimpiezaasignacioncanastilla(Long idlimpiezaasignacioncanastilla) {
		this.idlimpiezaasignacioncanastilla = idlimpiezaasignacioncanastilla;
	}

	public String getCodigodebarras() {
		return this.codigodebarras;
	}

	public void setCodigodebarras(String codigodebarras) {
		this.codigodebarras = codigodebarras;
	}

	public String getCodigoempleado() {
		return this.codigoempleado;
	}

	public void setCodigoempleado(String codigoempleado) {
		this.codigoempleado = codigoempleado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getPescadosporlata() {
		return this.pescadosporlata;
	}

	public void setPescadosporlata(Integer pescadosporlata) {
		this.pescadosporlata = pescadosporlata;
	}

	public Integer getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche() {
		return this.limpiezaDetalleProcesoCoche;
	}

	public void setLimpiezaDetalleProcesoCoche(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		this.limpiezaDetalleProcesoCoche = limpiezaDetalleProcesoCoche;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaDetallePesoDespellejado> getLimpiezaDetallePesoDespellejados() {
		return this.limpiezaDetallePesoDespellejados;
	}

	public void setLimpiezaDetallePesoDespellejados(List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados) {
		this.limpiezaDetallePesoDespellejados = limpiezaDetallePesoDespellejados;
	}

}