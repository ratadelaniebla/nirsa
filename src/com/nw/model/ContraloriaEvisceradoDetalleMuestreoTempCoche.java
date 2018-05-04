package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the contraloria_eviscerado_detalle_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="contraloria_eviscerado_detalle_muestreo_temp_coche")
@NamedQuery(name="ContraloriaEvisceradoDetalleMuestreoTempCoche.findAll", query="SELECT c FROM ContraloriaEvisceradoDetalleMuestreoTempCoche c")
public class ContraloriaEvisceradoDetalleMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcontraloriaevisceradodetallemuestreotempcoche;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nivel;
	private Integer nummuestralote;
	private double peso;
	private double temperatura;
	private String usuarioactualizacion;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoche;
	private Turno turno;
	private Usuario usuario;

	public ContraloriaEvisceradoDetalleMuestreoTempCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcontraloriaevisceradodetallemuestreotempcoche() {
		return this.idcontraloriaevisceradodetallemuestreotempcoche;
	}

	public void setIdcontraloriaevisceradodetallemuestreotempcoche(Long idcontraloriaevisceradodetallemuestreotempcoche) {
		this.idcontraloriaevisceradodetallemuestreotempcoche = idcontraloriaevisceradodetallemuestreotempcoche;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}


	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	public Integer getNummuestralote() {
		return this.nummuestralote;
	}

	public void setNummuestralote(Integer nummuestralote) {
		this.nummuestralote = nummuestralote;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
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


	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@ManyToOne
	@JoinColumn(name="idevisceradomuestreotempcoche")
	public EvisceradoMuestreoTempCoche getEvisceradoMuestreoTempCoche() {
		return this.evisceradoMuestreoTempCoche;
	}

	public void setEvisceradoMuestreoTempCoche(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoche) {
		this.evisceradoMuestreoTempCoche = evisceradoMuestreoTempCoche;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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