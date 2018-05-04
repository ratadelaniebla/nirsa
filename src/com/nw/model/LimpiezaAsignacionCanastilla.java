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
@NamedQuery(name="LimpiezaAsignacionCanastilla.findAll", query="SELECT l FROM LimpiezaAsignacionCanastilla l")
public class LimpiezaAsignacionCanastilla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaasignacioncanastilla;
	private String codigodebarras;
	private String codigoempleado;
	private Timestamp fechareg;
	private Integer pescadosporlata;
	private Integer secuencia;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;
	private Produccion produccion;
	private Usuario usuario;
	private List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados;

	public LimpiezaAsignacionCanastilla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesocoche")
	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche() {
		return this.limpiezaDetalleProcesoCoche;
	}

	public void setLimpiezaDetalleProcesoCoche(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		this.limpiezaDetalleProcesoCoche = limpiezaDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejado
	@OneToMany(mappedBy="limpiezaAsignacionCanastilla")
	public List<LimpiezaDetallePesoDespellejado> getLimpiezaDetallePesoDespellejados() {
		return this.limpiezaDetallePesoDespellejados;
	}

	public void setLimpiezaDetallePesoDespellejados(List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados) {
		this.limpiezaDetallePesoDespellejados = limpiezaDetallePesoDespellejados;
	}

	public LimpiezaDetallePesoDespellejado addLimpiezaDetallePesoDespellejado(LimpiezaDetallePesoDespellejado limpiezaDetallePesoDespellejado) {
		getLimpiezaDetallePesoDespellejados().add(limpiezaDetallePesoDespellejado);
		limpiezaDetallePesoDespellejado.setLimpiezaAsignacionCanastilla(this);

		return limpiezaDetallePesoDespellejado;
	}

	public LimpiezaDetallePesoDespellejado removeLimpiezaDetallePesoDespellejado(LimpiezaDetallePesoDespellejado limpiezaDetallePesoDespellejado) {
		getLimpiezaDetallePesoDespellejados().remove(limpiezaDetallePesoDespellejado);
		limpiezaDetallePesoDespellejado.setLimpiezaAsignacionCanastilla(null);

		return limpiezaDetallePesoDespellejado;
	}

}