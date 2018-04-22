package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_descongelado_detalle_proceso database table.
 * 
 */
@Entity
@Table(name="atc_descongelado_detalle_proceso")
public class AtcDescongeladoDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcdescongeladodetalleproceso;

	private String cajonrevolteo;

	private Boolean checkpermitirpesodiferencia;

	private Integer checkpesocamara;

	private Boolean checkpesodividido;

	private Integer estado;

	private Timestamp horafin;

	private Timestamp horaingreso;

	private Timestamp horainicio;

	private String observaciones;

	private double peso;

	private double pesocomparativodiferenciacamara;

	private double pesodiferenciacamara;

	private double tara;

	//bi-directional many-to-one association to AtcDescongeladoProceso
	@ManyToOne
	@JoinColumn(name="idatcdescongeladoproceso")
	private AtcDescongeladoProceso atcDescongeladoProceso;

	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelotecajon")
	private AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="idducha")
	private DescongeladoDucha descongeladoDucha;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTemp
	@OneToMany(mappedBy="atcDescongeladoDetalleProceso")
	private List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="atcDescongeladoDetalleProceso")
	private List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs;

	public AtcDescongeladoDetalleProceso() {
	}

	public Long getIdatcdescongeladodetalleproceso() {
		return this.idatcdescongeladodetalleproceso;
	}

	public void setIdatcdescongeladodetalleproceso(Long idatcdescongeladodetalleproceso) {
		this.idatcdescongeladodetalleproceso = idatcdescongeladodetalleproceso;
	}

	public String getCajonrevolteo() {
		return this.cajonrevolteo;
	}

	public void setCajonrevolteo(String cajonrevolteo) {
		this.cajonrevolteo = cajonrevolteo;
	}

	public Boolean getCheckpermitirpesodiferencia() {
		return this.checkpermitirpesodiferencia;
	}

	public void setCheckpermitirpesodiferencia(Boolean checkpermitirpesodiferencia) {
		this.checkpermitirpesodiferencia = checkpermitirpesodiferencia;
	}

	public Integer getCheckpesocamara() {
		return this.checkpesocamara;
	}

	public void setCheckpesocamara(Integer checkpesocamara) {
		this.checkpesocamara = checkpesocamara;
	}

	public Boolean getCheckpesodividido() {
		return this.checkpesodividido;
	}

	public void setCheckpesodividido(Boolean checkpesodividido) {
		this.checkpesodividido = checkpesodividido;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}

	public Timestamp getHoraingreso() {
		return this.horaingreso;
	}

	public void setHoraingreso(Timestamp horaingreso) {
		this.horaingreso = horaingreso;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPesocomparativodiferenciacamara() {
		return this.pesocomparativodiferenciacamara;
	}

	public void setPesocomparativodiferenciacamara(double pesocomparativodiferenciacamara) {
		this.pesocomparativodiferenciacamara = pesocomparativodiferenciacamara;
	}

	public double getPesodiferenciacamara() {
		return this.pesodiferenciacamara;
	}

	public void setPesodiferenciacamara(double pesodiferenciacamara) {
		this.pesodiferenciacamara = pesodiferenciacamara;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public AtcDescongeladoProceso getAtcDescongeladoProceso() {
		return this.atcDescongeladoProceso;
	}

	public void setAtcDescongeladoProceso(AtcDescongeladoProceso atcDescongeladoProceso) {
		this.atcDescongeladoProceso = atcDescongeladoProceso;
	}

	public AtcProduccionDetalleLoteCajon getAtcProduccionDetalleLoteCajon() {
		return this.atcProduccionDetalleLoteCajon;
	}

	public void setAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		this.atcProduccionDetalleLoteCajon = atcProduccionDetalleLoteCajon;
	}

	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
	}

	public List<AtcDescongeladoDetalleProcesoTemp> getAtcDescongeladoDetalleProcesoTemps() {
		return this.atcDescongeladoDetalleProcesoTemps;
	}

	public void setAtcDescongeladoDetalleProcesoTemps(List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps) {
		this.atcDescongeladoDetalleProcesoTemps = atcDescongeladoDetalleProcesoTemps;
	}

	public List<AtcDescongeladoDetalleProcesoTempIng> getAtcDescongeladoDetalleProcesoTempIngs() {
		return this.atcDescongeladoDetalleProcesoTempIngs;
	}

	public void setAtcDescongeladoDetalleProcesoTempIngs(List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs) {
		this.atcDescongeladoDetalleProcesoTempIngs = atcDescongeladoDetalleProcesoTempIngs;
	}

}