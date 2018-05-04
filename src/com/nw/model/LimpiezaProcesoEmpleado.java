package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado")
@NamedQuery(name="LimpiezaProcesoEmpleado.findAll", query="SELECT l FROM LimpiezaProcesoEmpleado l")
public class LimpiezaProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaprocesoempleado;
	private Integer estado;
	private Timestamp fechaingreso;
	private Timestamp fechareg;
	private Timestamp fechasalidamarcacion;
	private Integer idlimpiezacargo;
	private Boolean masivo;
	private String tarjetapersonalinea;
	private Integer ubicacion;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;
	private Empleado empleado;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaLineaGrupo limpiezaLineaGrupo;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;
	private List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;

	public LimpiezaProcesoEmpleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaprocesoempleado() {
		return this.idlimpiezaprocesoempleado;
	}

	public void setIdlimpiezaprocesoempleado(Long idlimpiezaprocesoempleado) {
		this.idlimpiezaprocesoempleado = idlimpiezaprocesoempleado;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFechasalidamarcacion() {
		return this.fechasalidamarcacion;
	}

	public void setFechasalidamarcacion(Timestamp fechasalidamarcacion) {
		this.fechasalidamarcacion = fechasalidamarcacion;
	}


	public Integer getIdlimpiezacargo() {
		return this.idlimpiezacargo;
	}

	public void setIdlimpiezacargo(Integer idlimpiezacargo) {
		this.idlimpiezacargo = idlimpiezacargo;
	}


	public Boolean getMasivo() {
		return this.masivo;
	}

	public void setMasivo(Boolean masivo) {
		this.masivo = masivo;
	}


	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}


	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaProcesoEmpleado(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaProcesoEmpleado(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public LimpiezaDetalleDesperdicio addLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().add(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setLimpiezaProcesoEmpleado(this);

		return limpiezaDetalleDesperdicio;
	}

	public LimpiezaDetalleDesperdicio removeLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().remove(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setLimpiezaProcesoEmpleado(null);

		return limpiezaDetalleDesperdicio;
	}


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public LimpiezaDetallePesoDespellejadoT addLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().add(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setLimpiezaProcesoEmpleado(this);

		return limpiezaDetallePesoDespellejadoT;
	}

	public LimpiezaDetallePesoDespellejadoT removeLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().remove(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setLimpiezaProcesoEmpleado(null);

		return limpiezaDetallePesoDespellejadoT;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaProcesoEmpleado(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaProcesoEmpleado(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaProcesoEmpleado(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setLimpiezaProcesoEmpleado(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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


	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezalineagrupo")
	public LimpiezaLineaGrupo getLimpiezaLineaGrupo() {
		return this.limpiezaLineaGrupo;
	}

	public void setLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		this.limpiezaLineaGrupo = limpiezaLineaGrupo;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
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


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoBonificacionPonchada
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<LimpiezaProcesoEmpleadoBonificacionPonchada> getLimpiezaProcesoEmpleadoBonificacionPonchadas() {
		return this.limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public void setLimpiezaProcesoEmpleadoBonificacionPonchadas(List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas) {
		this.limpiezaProcesoEmpleadoBonificacionPonchadas = limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public LimpiezaProcesoEmpleadoBonificacionPonchada addLimpiezaProcesoEmpleadoBonificacionPonchada(LimpiezaProcesoEmpleadoBonificacionPonchada limpiezaProcesoEmpleadoBonificacionPonchada) {
		getLimpiezaProcesoEmpleadoBonificacionPonchadas().add(limpiezaProcesoEmpleadoBonificacionPonchada);
		limpiezaProcesoEmpleadoBonificacionPonchada.setLimpiezaProcesoEmpleado(this);

		return limpiezaProcesoEmpleadoBonificacionPonchada;
	}

	public LimpiezaProcesoEmpleadoBonificacionPonchada removeLimpiezaProcesoEmpleadoBonificacionPonchada(LimpiezaProcesoEmpleadoBonificacionPonchada limpiezaProcesoEmpleadoBonificacionPonchada) {
		getLimpiezaProcesoEmpleadoBonificacionPonchadas().remove(limpiezaProcesoEmpleadoBonificacionPonchada);
		limpiezaProcesoEmpleadoBonificacionPonchada.setLimpiezaProcesoEmpleado(null);

		return limpiezaProcesoEmpleadoBonificacionPonchada;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setLimpiezaProcesoEmpleado(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setLimpiezaProcesoEmpleado(null);

		return oeeDetalleMediosConDefecto;
	}


	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

	public OeeDetalleParadaLimpieza addOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().add(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setLimpiezaProcesoEmpleado(this);

		return oeeDetalleParadaLimpieza;
	}

	public OeeDetalleParadaLimpieza removeOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().remove(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setLimpiezaProcesoEmpleado(null);

		return oeeDetalleParadaLimpieza;
	}

}