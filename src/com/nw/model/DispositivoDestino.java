package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dispositivo_destino database table.
 * 
 */
@Entity
@Table(name="dispositivo_destino")
public class DispositivoDestino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddispositivodestino;

	private String descripciondispotivodestino;

	private Integer estadodispositivo;

	private String ipdispositivo;

	private String proveedordispositivo;

	private String puertdispositivo;

	private String serie;

	private String tiempoesperadispositivo;

	//bi-directional many-to-one association to Dispositivo
	@ManyToOne
	@JoinColumn(name="iddispositivo")
	private Dispositivo dispositivo;

	//bi-directional many-to-one association to DispositivoLado
	@ManyToOne
	@JoinColumn(name="iddispositivolado")
	private DispositivoLado dispositivoLado;

	//bi-directional many-to-one association to DispositivoPuestoTrabajo
	@ManyToOne
	@JoinColumn(name="iddispositivopuestotrabajo")
	private DispositivoPuestoTrabajo dispositivoPuestoTrabajo;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	public DispositivoDestino() {
	}

	public Long getIddispositivodestino() {
		return this.iddispositivodestino;
	}

	public void setIddispositivodestino(Long iddispositivodestino) {
		this.iddispositivodestino = iddispositivodestino;
	}

	public String getDescripciondispotivodestino() {
		return this.descripciondispotivodestino;
	}

	public void setDescripciondispotivodestino(String descripciondispotivodestino) {
		this.descripciondispotivodestino = descripciondispotivodestino;
	}

	public Integer getEstadodispositivo() {
		return this.estadodispositivo;
	}

	public void setEstadodispositivo(Integer estadodispositivo) {
		this.estadodispositivo = estadodispositivo;
	}

	public String getIpdispositivo() {
		return this.ipdispositivo;
	}

	public void setIpdispositivo(String ipdispositivo) {
		this.ipdispositivo = ipdispositivo;
	}

	public String getProveedordispositivo() {
		return this.proveedordispositivo;
	}

	public void setProveedordispositivo(String proveedordispositivo) {
		this.proveedordispositivo = proveedordispositivo;
	}

	public String getPuertdispositivo() {
		return this.puertdispositivo;
	}

	public void setPuertdispositivo(String puertdispositivo) {
		this.puertdispositivo = puertdispositivo;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTiempoesperadispositivo() {
		return this.tiempoesperadispositivo;
	}

	public void setTiempoesperadispositivo(String tiempoesperadispositivo) {
		this.tiempoesperadispositivo = tiempoesperadispositivo;
	}

	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public DispositivoLado getDispositivoLado() {
		return this.dispositivoLado;
	}

	public void setDispositivoLado(DispositivoLado dispositivoLado) {
		this.dispositivoLado = dispositivoLado;
	}

	public DispositivoPuestoTrabajo getDispositivoPuestoTrabajo() {
		return this.dispositivoPuestoTrabajo;
	}

	public void setDispositivoPuestoTrabajo(DispositivoPuestoTrabajo dispositivoPuestoTrabajo) {
		this.dispositivoPuestoTrabajo = dispositivoPuestoTrabajo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}