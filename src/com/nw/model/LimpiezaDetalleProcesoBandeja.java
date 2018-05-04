package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_detalle_proceso_bandeja database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_proceso_bandeja")
@NamedQuery(name="LimpiezaDetalleProcesoBandeja.findAll", query="SELECT l FROM LimpiezaDetalleProcesoBandeja l")
public class LimpiezaDetalleProcesoBandeja implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalleprocesobandeja;
	private Boolean automatico;
	private String codpersona;
	private String dispositivo;
	private Timestamp fechareg;
	private Integer hora;
	private Long idlimpiezadetalleprocesobandejareq;
	private Integer inouthorario;
	private Integer minutos;
	private Integer numbandejalote;
	private Integer numerobandejas;
	private Long ordenBandeja;
	private double peso;
	private double pesorallado;
	private Integer rechazado;
	private double tara;
	private String tarjetapersonalinea;
	private Integer totaltiempo;
	private Integer ubicacionpersona;
	private String unidad;
	private GrupoTalla grupoTalla;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaMaterial limpiezaMaterial1;
	private LimpiezaMaterial limpiezaMaterial2;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo;
	private LimpiezaSecuenciaOrden limpiezaSecuenciaOrden;
	private Turno turno;
	private Usuario usuario;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2;

	public LimpiezaDetalleProcesoBandeja() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetalleprocesobandeja() {
		return this.idlimpiezadetalleprocesobandeja;
	}

	public void setIdlimpiezadetalleprocesobandeja(Long idlimpiezadetalleprocesobandeja) {
		this.idlimpiezadetalleprocesobandeja = idlimpiezadetalleprocesobandeja;
	}


	public Boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}


	public String getCodpersona() {
		return this.codpersona;
	}

	public void setCodpersona(String codpersona) {
		this.codpersona = codpersona;
	}


	public String getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getHora() {
		return this.hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}


	public Long getIdlimpiezadetalleprocesobandejareq() {
		return this.idlimpiezadetalleprocesobandejareq;
	}

	public void setIdlimpiezadetalleprocesobandejareq(Long idlimpiezadetalleprocesobandejareq) {
		this.idlimpiezadetalleprocesobandejareq = idlimpiezadetalleprocesobandejareq;
	}


	public Integer getInouthorario() {
		return this.inouthorario;
	}

	public void setInouthorario(Integer inouthorario) {
		this.inouthorario = inouthorario;
	}


	public Integer getMinutos() {
		return this.minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}


	public Integer getNumbandejalote() {
		return this.numbandejalote;
	}

	public void setNumbandejalote(Integer numbandejalote) {
		this.numbandejalote = numbandejalote;
	}


	public Integer getNumerobandejas() {
		return this.numerobandejas;
	}

	public void setNumerobandejas(Integer numerobandejas) {
		this.numerobandejas = numerobandejas;
	}


	@Column(name="orden_bandeja")
	public Long getOrdenBandeja() {
		return this.ordenBandeja;
	}

	public void setOrdenBandeja(Long ordenBandeja) {
		this.ordenBandeja = ordenBandeja;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getPesorallado() {
		return this.pesorallado;
	}

	public void setPesorallado(double pesorallado) {
		this.pesorallado = pesorallado;
	}


	public Integer getRechazado() {
		return this.rechazado;
	}

	public void setRechazado(Integer rechazado) {
		this.rechazado = rechazado;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}


	public Integer getTotaltiempo() {
		return this.totaltiempo;
	}

	public void setTotaltiempo(Integer totaltiempo) {
		this.totaltiempo = totaltiempo;
	}


	public Integer getUbicacionpersona() {
		return this.ubicacionpersona;
	}

	public void setUbicacionpersona(Integer ubicacionpersona) {
		this.ubicacionpersona = ubicacionpersona;
	}


	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	//bi-directional many-to-one association to GrupoTalla
	@ManyToOne
	@JoinColumn(name="idgrupotalla")
	public GrupoTalla getGrupoTalla() {
		return this.grupoTalla;
	}

	public void setGrupoTalla(GrupoTalla grupoTalla) {
		this.grupoTalla = grupoTalla;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idlimpiezamaterial")
	public LimpiezaMaterial getLimpiezaMaterial1() {
		return this.limpiezaMaterial1;
	}

	public void setLimpiezaMaterial1(LimpiezaMaterial limpiezaMaterial1) {
		this.limpiezaMaterial1 = limpiezaMaterial1;
	}


	//bi-directional many-to-one association to LimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idlimpiezamaterial2")
	public LimpiezaMaterial getLimpiezaMaterial2() {
		return this.limpiezaMaterial2;
	}

	public void setLimpiezaMaterial2(LimpiezaMaterial limpiezaMaterial2) {
		this.limpiezaMaterial2 = limpiezaMaterial2;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
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


	//bi-directional many-to-one association to LimpiezaSecuenciaOrden
	@ManyToOne
	@JoinColumn(name="idsecuenciaorden")
	public LimpiezaSecuenciaOrden getLimpiezaSecuenciaOrden() {
		return this.limpiezaSecuenciaOrden;
	}

	public void setLimpiezaSecuenciaOrden(LimpiezaSecuenciaOrden limpiezaSecuenciaOrden) {
		this.limpiezaSecuenciaOrden = limpiezaSecuenciaOrden;
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


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoBandeja1")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions1() {
		return this.limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions1(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1) {
		this.limpiezaDetalleProcesoBandejaAprobacions1 = limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacions1(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions1) {
		getLimpiezaDetalleProcesoBandejaAprobacions1().add(limpiezaDetalleProcesoBandejaAprobacions1);
		limpiezaDetalleProcesoBandejaAprobacions1.setLimpiezaDetalleProcesoBandeja1(this);

		return limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacions1(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions1) {
		getLimpiezaDetalleProcesoBandejaAprobacions1().remove(limpiezaDetalleProcesoBandejaAprobacions1);
		limpiezaDetalleProcesoBandejaAprobacions1.setLimpiezaDetalleProcesoBandeja1(null);

		return limpiezaDetalleProcesoBandejaAprobacions1;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoBandeja2")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions2() {
		return this.limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions2(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2) {
		this.limpiezaDetalleProcesoBandejaAprobacions2 = limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacions2(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions2) {
		getLimpiezaDetalleProcesoBandejaAprobacions2().add(limpiezaDetalleProcesoBandejaAprobacions2);
		limpiezaDetalleProcesoBandejaAprobacions2.setLimpiezaDetalleProcesoBandeja2(this);

		return limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacions2(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions2) {
		getLimpiezaDetalleProcesoBandejaAprobacions2().remove(limpiezaDetalleProcesoBandejaAprobacions2);
		limpiezaDetalleProcesoBandejaAprobacions2.setLimpiezaDetalleProcesoBandeja2(null);

		return limpiezaDetalleProcesoBandejaAprobacions2;
	}

}