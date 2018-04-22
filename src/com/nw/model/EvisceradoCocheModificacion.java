package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_coche_modificacion database table.
 * 
 */
@Entity
@Table(name="eviscerado_coche_modificacion")
public class EvisceradoCocheModificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradocochemodificacion;

	private Integer canastillas;

	private Long codbarra;

	private Integer estadoespecial;

	private Integer estadouso;

	private Timestamp fechaactualizacion;

	private Timestamp fechareg;

	private Timestamp fecharegrecepcocheconica;

	private Integer idcochedia;

	private Integer idcochelote;

	private Long idcocheprincipal;

	private Long idcocinaaperturacierredetallerecepcocheconica;

	private Integer idcocinarecepcocheconica;

	private String idusuariorecepcocheconica;

	private Integer pescadoadicional;

	private double peso;

	private double tara;

	private String tipoingreso;

	private String tipoingresocontingencia;

	private String tipoingresotara;

	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	private Cocina cocina;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to EvisceradoCorte
	@ManyToOne
	@JoinColumn(name="idevisceradocorte")
	private EvisceradoCorte evisceradoCorte;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	private EvisceradoPescadosLata evisceradoPescadosLata;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioactualizacion")
	private Usuario usuario2;

	public EvisceradoCocheModificacion() {
	}

	public Long getIdevisceradocochemodificacion() {
		return this.idevisceradocochemodificacion;
	}

	public void setIdevisceradocochemodificacion(Long idevisceradocochemodificacion) {
		this.idevisceradocochemodificacion = idevisceradocochemodificacion;
	}

	public Integer getCanastillas() {
		return this.canastillas;
	}

	public void setCanastillas(Integer canastillas) {
		this.canastillas = canastillas;
	}

	public Long getCodbarra() {
		return this.codbarra;
	}

	public void setCodbarra(Long codbarra) {
		this.codbarra = codbarra;
	}

	public Integer getEstadoespecial() {
		return this.estadoespecial;
	}

	public void setEstadoespecial(Integer estadoespecial) {
		this.estadoespecial = estadoespecial;
	}

	public Integer getEstadouso() {
		return this.estadouso;
	}

	public void setEstadouso(Integer estadouso) {
		this.estadouso = estadouso;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFecharegrecepcocheconica() {
		return this.fecharegrecepcocheconica;
	}

	public void setFecharegrecepcocheconica(Timestamp fecharegrecepcocheconica) {
		this.fecharegrecepcocheconica = fecharegrecepcocheconica;
	}

	public Integer getIdcochedia() {
		return this.idcochedia;
	}

	public void setIdcochedia(Integer idcochedia) {
		this.idcochedia = idcochedia;
	}

	public Integer getIdcochelote() {
		return this.idcochelote;
	}

	public void setIdcochelote(Integer idcochelote) {
		this.idcochelote = idcochelote;
	}

	public Long getIdcocheprincipal() {
		return this.idcocheprincipal;
	}

	public void setIdcocheprincipal(Long idcocheprincipal) {
		this.idcocheprincipal = idcocheprincipal;
	}

	public Long getIdcocinaaperturacierredetallerecepcocheconica() {
		return this.idcocinaaperturacierredetallerecepcocheconica;
	}

	public void setIdcocinaaperturacierredetallerecepcocheconica(Long idcocinaaperturacierredetallerecepcocheconica) {
		this.idcocinaaperturacierredetallerecepcocheconica = idcocinaaperturacierredetallerecepcocheconica;
	}

	public Integer getIdcocinarecepcocheconica() {
		return this.idcocinarecepcocheconica;
	}

	public void setIdcocinarecepcocheconica(Integer idcocinarecepcocheconica) {
		this.idcocinarecepcocheconica = idcocinarecepcocheconica;
	}

	public String getIdusuariorecepcocheconica() {
		return this.idusuariorecepcocheconica;
	}

	public void setIdusuariorecepcocheconica(String idusuariorecepcocheconica) {
		this.idusuariorecepcocheconica = idusuariorecepcocheconica;
	}

	public Integer getPescadoadicional() {
		return this.pescadoadicional;
	}

	public void setPescadoadicional(Integer pescadoadicional) {
		this.pescadoadicional = pescadoadicional;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public String getTipoingresocontingencia() {
		return this.tipoingresocontingencia;
	}

	public void setTipoingresocontingencia(String tipoingresocontingencia) {
		this.tipoingresocontingencia = tipoingresocontingencia;
	}

	public String getTipoingresotara() {
		return this.tipoingresotara;
	}

	public void setTipoingresotara(String tipoingresotara) {
		this.tipoingresotara = tipoingresotara;
	}

	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}

	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}

	public EvisceradoCorte getEvisceradoCorte() {
		return this.evisceradoCorte;
	}

	public void setEvisceradoCorte(EvisceradoCorte evisceradoCorte) {
		this.evisceradoCorte = evisceradoCorte;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}