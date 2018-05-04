package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_lomo_limpio_coche database table.
 * 
 */
@Entity
@Table(name="limpieza_lomo_limpio_coche")
@NamedQuery(name="LimpiezaLomoLimpioCoche.findAll", query="SELECT l FROM LimpiezaLomoLimpioCoche l")
public class LimpiezaLomoLimpioCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezalomolimpiocoche;
	private Integer estado;
	private Timestamp fecharegistro;
	private String secuencia;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo;
	private Proceso proceso;
	private Usuario usuario;
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;

	public LimpiezaLomoLimpioCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezalomolimpiocoche() {
		return this.idlimpiezalomolimpiocoche;
	}

	public void setIdlimpiezalomolimpiocoche(Long idlimpiezalomolimpiocoche) {
		this.idlimpiezalomolimpiocoche = idlimpiezalomolimpiocoche;
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


	public String getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoloteactivo")
	public LimpiezaProcesoLoteActivo getLimpiezaProcesoLoteActivo() {
		return this.limpiezaProcesoLoteActivo;
	}

	public void setLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		this.limpiezaProcesoLoteActivo = limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
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


	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="limpiezaLomoLimpioCoche")
	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public LonjasDetalleProcesoCoche addLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().add(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLimpiezaLomoLimpioCoche(this);

		return lonjasDetalleProcesoCoch;
	}

	public LonjasDetalleProcesoCoche removeLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().remove(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLimpiezaLomoLimpioCoche(null);

		return lonjasDetalleProcesoCoch;
	}

}