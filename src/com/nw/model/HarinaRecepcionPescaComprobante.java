package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the harina_recepcion_pesca_comprobante database table.
 * 
 */
@Entity
@Table(name="harina_recepcion_pesca_comprobante")
public class HarinaRecepcionPescaComprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinarecepcionpescacomprobante;

	private Integer estado;

	private Timestamp fechacreacion;

	@Temporal(TemporalType.DATE)
	private Date fecharecepcion;

	private String observaciones;

	private String origen;

	private double pesoentrada;

	private double pesosalida;

	private String placa;

	//bi-directional many-to-one association to HarinaComprobanteDetalleGrupoEspecie
	@OneToMany(mappedBy="harinaRecepcionPescaComprobante")
	private List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaRecepcionPescaComprobante")
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to Chofer
	@ManyToOne
	@JoinColumn(name="idchofer")
	private Chofer chofer;

	//bi-directional many-to-one association to HarinaClasificacionTipoPesca
	@ManyToOne
	@JoinColumn(name="idharinaclasificaciontipopesca")
	private HarinaClasificacionTipoPesca harinaClasificacionTipoPesca;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public HarinaRecepcionPescaComprobante() {
	}

	public Long getIdharinarecepcionpescacomprobante() {
		return this.idharinarecepcionpescacomprobante;
	}

	public void setIdharinarecepcionpescacomprobante(Long idharinarecepcionpescacomprobante) {
		this.idharinarecepcionpescacomprobante = idharinarecepcionpescacomprobante;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFecharecepcion() {
		return this.fecharecepcion;
	}

	public void setFecharecepcion(Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public double getPesoentrada() {
		return this.pesoentrada;
	}

	public void setPesoentrada(double pesoentrada) {
		this.pesoentrada = pesoentrada;
	}

	public double getPesosalida() {
		return this.pesosalida;
	}

	public void setPesosalida(double pesosalida) {
		this.pesosalida = pesosalida;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<HarinaComprobanteDetalleGrupoEspecie> getHarinaComprobanteDetalleGrupoEspecies() {
		return this.harinaComprobanteDetalleGrupoEspecies;
	}

	public void setHarinaComprobanteDetalleGrupoEspecies(List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies) {
		this.harinaComprobanteDetalleGrupoEspecies = harinaComprobanteDetalleGrupoEspecies;
	}

	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public Chofer getChofer() {
		return this.chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public HarinaClasificacionTipoPesca getHarinaClasificacionTipoPesca() {
		return this.harinaClasificacionTipoPesca;
	}

	public void setHarinaClasificacionTipoPesca(HarinaClasificacionTipoPesca harinaClasificacionTipoPesca) {
		this.harinaClasificacionTipoPesca = harinaClasificacionTipoPesca;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}