package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_reanudacion_sec_coche database table.
 * 
 */
@Entity
@Table(name="eviscerado_reanudacion_sec_coche")
public class EvisceradoReanudacionSecCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevisceradoreanudacionseccoche;

	private Integer estado;

	private Timestamp fechadeshabilita;

	private Timestamp fechahabilita;

	private String idusuariodeshabilita;

	private Integer secuenciafin;

	private Integer secuenciainicio;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariohabilita")
	private Usuario usuario;

	public EvisceradoReanudacionSecCoche() {
	}

	public Integer getIdevisceradoreanudacionseccoche() {
		return this.idevisceradoreanudacionseccoche;
	}

	public void setIdevisceradoreanudacionseccoche(Integer idevisceradoreanudacionseccoche) {
		this.idevisceradoreanudacionseccoche = idevisceradoreanudacionseccoche;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechadeshabilita() {
		return this.fechadeshabilita;
	}

	public void setFechadeshabilita(Timestamp fechadeshabilita) {
		this.fechadeshabilita = fechadeshabilita;
	}

	public Timestamp getFechahabilita() {
		return this.fechahabilita;
	}

	public void setFechahabilita(Timestamp fechahabilita) {
		this.fechahabilita = fechahabilita;
	}

	public String getIdusuariodeshabilita() {
		return this.idusuariodeshabilita;
	}

	public void setIdusuariodeshabilita(String idusuariodeshabilita) {
		this.idusuariodeshabilita = idusuariodeshabilita;
	}

	public Integer getSecuenciafin() {
		return this.secuenciafin;
	}

	public void setSecuenciafin(Integer secuenciafin) {
		this.secuenciafin = secuenciafin;
	}

	public Integer getSecuenciainicio() {
		return this.secuenciainicio;
	}

	public void setSecuenciainicio(Integer secuenciainicio) {
		this.secuenciainicio = secuenciainicio;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}