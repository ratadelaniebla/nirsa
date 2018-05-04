package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the panzas_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="panzas_detalle_proceso_coche")
@NamedQuery(name="PanzasDetalleProcesoCoche.findAll", query="SELECT p FROM PanzasDetalleProcesoCoche p")
public class PanzasDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpanzasdetalleprocesocoche;
	private Integer codbarra;
	private Integer estado;
	private Timestamp fecharegistro;
	private String observacion;
	private double temperatura;
	private Cocina cocina;
	private Usuario usuario;
	private List<PanzasDetalleProcesoCocheDetalle> panzasDetalleProcesoCocheDetalles;

	public PanzasDetalleProcesoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpanzasdetalleprocesocoche() {
		return this.idpanzasdetalleprocesocoche;
	}

	public void setIdpanzasdetalleprocesocoche(Long idpanzasdetalleprocesocoche) {
		this.idpanzasdetalleprocesocoche = idpanzasdetalleprocesocoche;
	}


	public Integer getCodbarra() {
		return this.codbarra;
	}

	public void setCodbarra(Integer codbarra) {
		this.codbarra = codbarra;
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


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
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


	//bi-directional many-to-one association to PanzasDetalleProcesoCocheDetalle
	@OneToMany(mappedBy="panzasDetalleProcesoCoche")
	public List<PanzasDetalleProcesoCocheDetalle> getPanzasDetalleProcesoCocheDetalles() {
		return this.panzasDetalleProcesoCocheDetalles;
	}

	public void setPanzasDetalleProcesoCocheDetalles(List<PanzasDetalleProcesoCocheDetalle> panzasDetalleProcesoCocheDetalles) {
		this.panzasDetalleProcesoCocheDetalles = panzasDetalleProcesoCocheDetalles;
	}

	public PanzasDetalleProcesoCocheDetalle addPanzasDetalleProcesoCocheDetalle(PanzasDetalleProcesoCocheDetalle panzasDetalleProcesoCocheDetalle) {
		getPanzasDetalleProcesoCocheDetalles().add(panzasDetalleProcesoCocheDetalle);
		panzasDetalleProcesoCocheDetalle.setPanzasDetalleProcesoCoche(this);

		return panzasDetalleProcesoCocheDetalle;
	}

	public PanzasDetalleProcesoCocheDetalle removePanzasDetalleProcesoCocheDetalle(PanzasDetalleProcesoCocheDetalle panzasDetalleProcesoCocheDetalle) {
		getPanzasDetalleProcesoCocheDetalles().remove(panzasDetalleProcesoCocheDetalle);
		panzasDetalleProcesoCocheDetalle.setPanzasDetalleProcesoCoche(null);

		return panzasDetalleProcesoCocheDetalle;
	}

}