package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_cajon_modificacion database table.
 * 
 */
@Entity
@Table(name="descongelado_cajon_modificacion")
@NamedQuery(name="DescongeladoCajonModificacion.findAll", query="SELECT d FROM DescongeladoCajonModificacion d")
public class DescongeladoCajonModificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladocajonmodificacion;
	private String cajonrevolteo;
	private Boolean checkpermitirpesodiferencia;
	private Integer checkpesocamara;
	private Boolean checkpesodividido;
	private Integer estado;
	private Timestamp fechaactualizacion;
	private Integer finforzado;
	private Integer finproceso;
	private Timestamp horafin;
	private Timestamp horafindescongelado;
	private Timestamp horafinforzado;
	private Timestamp horaingreso;
	private Timestamp horainicio;
	private Timestamp horapesocajon;
	private double horastranscurridas;
	private String idusuarioactualizacion;
	private String idusuarioingreso;
	private String idusuariopesocajon;
	private String idusuariosalida;
	private double minutostranscurridos;
	private Integer numeroduchadageneral;
	private String observaciones;
	private double peso;
	private double pesocomparativodiferenciacamara;
	private double pesodiferenciacamara;
	private double segundostranscurridos;
	private double tara;
	private String tipoingreso;
	private Integer ultimaidducha;
	private DescongeladoDetalleProceso descongeladoDetalleProceso;
	private DescongeladoDucha descongeladoDucha;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2;
	private DescongeladoProceso descongeladoProceso;
	private DuchaAperturaCierreDetalle duchaAperturaCierreDetalle;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private Turno turno;
	private Usuario usuario;

	public DescongeladoCajonModificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladocajonmodificacion() {
		return this.iddescongeladocajonmodificacion;
	}

	public void setIddescongeladocajonmodificacion(Long iddescongeladocajonmodificacion) {
		this.iddescongeladocajonmodificacion = iddescongeladocajonmodificacion;
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


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Integer getFinforzado() {
		return this.finforzado;
	}

	public void setFinforzado(Integer finforzado) {
		this.finforzado = finforzado;
	}


	public Integer getFinproceso() {
		return this.finproceso;
	}

	public void setFinproceso(Integer finproceso) {
		this.finproceso = finproceso;
	}


	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}


	public Timestamp getHorafindescongelado() {
		return this.horafindescongelado;
	}

	public void setHorafindescongelado(Timestamp horafindescongelado) {
		this.horafindescongelado = horafindescongelado;
	}


	public Timestamp getHorafinforzado() {
		return this.horafinforzado;
	}

	public void setHorafinforzado(Timestamp horafinforzado) {
		this.horafinforzado = horafinforzado;
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


	public Timestamp getHorapesocajon() {
		return this.horapesocajon;
	}

	public void setHorapesocajon(Timestamp horapesocajon) {
		this.horapesocajon = horapesocajon;
	}


	public double getHorastranscurridas() {
		return this.horastranscurridas;
	}

	public void setHorastranscurridas(double horastranscurridas) {
		this.horastranscurridas = horastranscurridas;
	}


	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}


	public String getIdusuarioingreso() {
		return this.idusuarioingreso;
	}

	public void setIdusuarioingreso(String idusuarioingreso) {
		this.idusuarioingreso = idusuarioingreso;
	}


	public String getIdusuariopesocajon() {
		return this.idusuariopesocajon;
	}

	public void setIdusuariopesocajon(String idusuariopesocajon) {
		this.idusuariopesocajon = idusuariopesocajon;
	}


	public String getIdusuariosalida() {
		return this.idusuariosalida;
	}

	public void setIdusuariosalida(String idusuariosalida) {
		this.idusuariosalida = idusuariosalida;
	}


	public double getMinutostranscurridos() {
		return this.minutostranscurridos;
	}

	public void setMinutostranscurridos(double minutostranscurridos) {
		this.minutostranscurridos = minutostranscurridos;
	}


	public Integer getNumeroduchadageneral() {
		return this.numeroduchadageneral;
	}

	public void setNumeroduchadageneral(Integer numeroduchadageneral) {
		this.numeroduchadageneral = numeroduchadageneral;
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


	public double getSegundostranscurridos() {
		return this.segundostranscurridos;
	}

	public void setSegundostranscurridos(double segundostranscurridos) {
		this.segundostranscurridos = segundostranscurridos;
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


	public Integer getUltimaidducha() {
		return this.ultimaidducha;
	}

	public void setUltimaidducha(Integer ultimaidducha) {
		this.ultimaidducha = ultimaidducha;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="idducha")
	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="ultimoiddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle1() {
		return this.descongeladoDuchaAperturaCierreDetalle1;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle1(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1) {
		this.descongeladoDuchaAperturaCierreDetalle1 = descongeladoDuchaAperturaCierreDetalle1;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle2() {
		return this.descongeladoDuchaAperturaCierreDetalle2;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle2(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2) {
		this.descongeladoDuchaAperturaCierreDetalle2 = descongeladoDuchaAperturaCierreDetalle2;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladoproceso")
	public DescongeladoProceso getDescongeladoProceso() {
		return this.descongeladoProceso;
	}

	public void setDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		this.descongeladoProceso = descongeladoProceso;
	}


	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idduchaaperturacierredetalle")
	public DuchaAperturaCierreDetalle getDuchaAperturaCierreDetalle() {
		return this.duchaAperturaCierreDetalle;
	}

	public void setDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		this.duchaAperturaCierreDetalle = duchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
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