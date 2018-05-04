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
@NamedQuery(name="HarinaRecepcionPescaComprobante.findAll", query="SELECT h FROM HarinaRecepcionPescaComprobante h")
public class HarinaRecepcionPescaComprobante implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idharinarecepcionpescacomprobante;
	private Integer estado;
	private Timestamp fechacreacion;
	private Date fecharecepcion;
	private String observaciones;
	private String origen;
	private double pesoentrada;
	private double pesosalida;
	private String placa;
	private List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies;
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;
	private Chofer chofer;
	private HarinaClasificacionTipoPesca harinaClasificacionTipoPesca;
	private Proveedor proveedor;
	private Turno turno;
	private Usuario usuario;

	public HarinaRecepcionPescaComprobante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Temporal(TemporalType.DATE)
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


	//bi-directional many-to-one association to HarinaComprobanteDetalleGrupoEspecie
	@OneToMany(mappedBy="harinaRecepcionPescaComprobante")
	public List<HarinaComprobanteDetalleGrupoEspecie> getHarinaComprobanteDetalleGrupoEspecies() {
		return this.harinaComprobanteDetalleGrupoEspecies;
	}

	public void setHarinaComprobanteDetalleGrupoEspecies(List<HarinaComprobanteDetalleGrupoEspecie> harinaComprobanteDetalleGrupoEspecies) {
		this.harinaComprobanteDetalleGrupoEspecies = harinaComprobanteDetalleGrupoEspecies;
	}

	public HarinaComprobanteDetalleGrupoEspecie addHarinaComprobanteDetalleGrupoEspecy(HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecy) {
		getHarinaComprobanteDetalleGrupoEspecies().add(harinaComprobanteDetalleGrupoEspecy);
		harinaComprobanteDetalleGrupoEspecy.setHarinaRecepcionPescaComprobante(this);

		return harinaComprobanteDetalleGrupoEspecy;
	}

	public HarinaComprobanteDetalleGrupoEspecie removeHarinaComprobanteDetalleGrupoEspecy(HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecy) {
		getHarinaComprobanteDetalleGrupoEspecies().remove(harinaComprobanteDetalleGrupoEspecy);
		harinaComprobanteDetalleGrupoEspecy.setHarinaRecepcionPescaComprobante(null);

		return harinaComprobanteDetalleGrupoEspecy;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaRecepcionPescaComprobante")
	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public HarinaRecepcionDetallePescaComprobante addHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().add(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setHarinaRecepcionPescaComprobante(this);

		return harinaRecepcionDetallePescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante removeHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().remove(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setHarinaRecepcionPescaComprobante(null);

		return harinaRecepcionDetallePescaComprobante;
	}


	//bi-directional many-to-one association to Chofer
	@ManyToOne
	@JoinColumn(name="idchofer")
	public Chofer getChofer() {
		return this.chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}


	//bi-directional many-to-one association to HarinaClasificacionTipoPesca
	@ManyToOne
	@JoinColumn(name="idharinaclasificaciontipopesca")
	public HarinaClasificacionTipoPesca getHarinaClasificacionTipoPesca() {
		return this.harinaClasificacionTipoPesca;
	}

	public void setHarinaClasificacionTipoPesca(HarinaClasificacionTipoPesca harinaClasificacionTipoPesca) {
		this.harinaClasificacionTipoPesca = harinaClasificacionTipoPesca;
	}


	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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