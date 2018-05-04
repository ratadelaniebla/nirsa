package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produccion_orden_pedido database table.
 * 
 */
@Entity
@Table(name="produccion_orden_pedido")
@NamedQuery(name="ProduccionOrdenPedido.findAll", query="SELECT p FROM ProduccionOrdenPedido p")
public class ProduccionOrdenPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccionordenpedido;
	private String aceite;
	private double aceitexlata;
	private String agua;
	private double cajas;
	private String cerradora;
	private String cliente;
	private String destino;
	private double drenado;
	private String envase;
	private String especie;
	private double fill;
	private double fillpor;
	private double flakeporcentaje;
	private double formato;
	private Integer item;
	private double latas;
	private String luthi;
	private String marca;
	private Integer materialfert;
	private Integer materialhalb;
	private String observaciones;
	private String orden;
	private Integer ordenfert;
	private Integer ordenhalb;
	private String posicion;
	private String presentacion;
	private Integer presentacionind;
	private String producto;
	private String tapa;
	private double toneladas;
	private String video;
	private List<PouchProceso> pouchProcesos;
	private Produccion produccion;
	private Turno turno;

	public ProduccionOrdenPedido() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdproduccionordenpedido() {
		return this.idproduccionordenpedido;
	}

	public void setIdproduccionordenpedido(Long idproduccionordenpedido) {
		this.idproduccionordenpedido = idproduccionordenpedido;
	}


	public String getAceite() {
		return this.aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
	}


	public double getAceitexlata() {
		return this.aceitexlata;
	}

	public void setAceitexlata(double aceitexlata) {
		this.aceitexlata = aceitexlata;
	}


	public String getAgua() {
		return this.agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}


	public double getCajas() {
		return this.cajas;
	}

	public void setCajas(double cajas) {
		this.cajas = cajas;
	}


	public String getCerradora() {
		return this.cerradora;
	}

	public void setCerradora(String cerradora) {
		this.cerradora = cerradora;
	}


	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}


	public double getDrenado() {
		return this.drenado;
	}

	public void setDrenado(double drenado) {
		this.drenado = drenado;
	}


	public String getEnvase() {
		return this.envase;
	}

	public void setEnvase(String envase) {
		this.envase = envase;
	}


	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public double getFill() {
		return this.fill;
	}

	public void setFill(double fill) {
		this.fill = fill;
	}


	public double getFillpor() {
		return this.fillpor;
	}

	public void setFillpor(double fillpor) {
		this.fillpor = fillpor;
	}


	public double getFlakeporcentaje() {
		return this.flakeporcentaje;
	}

	public void setFlakeporcentaje(double flakeporcentaje) {
		this.flakeporcentaje = flakeporcentaje;
	}


	public double getFormato() {
		return this.formato;
	}

	public void setFormato(double formato) {
		this.formato = formato;
	}


	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}


	public double getLatas() {
		return this.latas;
	}

	public void setLatas(double latas) {
		this.latas = latas;
	}


	public String getLuthi() {
		return this.luthi;
	}

	public void setLuthi(String luthi) {
		this.luthi = luthi;
	}


	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getMaterialfert() {
		return this.materialfert;
	}

	public void setMaterialfert(Integer materialfert) {
		this.materialfert = materialfert;
	}


	public Integer getMaterialhalb() {
		return this.materialhalb;
	}

	public void setMaterialhalb(Integer materialhalb) {
		this.materialhalb = materialhalb;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}


	public Integer getOrdenfert() {
		return this.ordenfert;
	}

	public void setOrdenfert(Integer ordenfert) {
		this.ordenfert = ordenfert;
	}


	public Integer getOrdenhalb() {
		return this.ordenhalb;
	}

	public void setOrdenhalb(Integer ordenhalb) {
		this.ordenhalb = ordenhalb;
	}


	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	public Integer getPresentacionind() {
		return this.presentacionind;
	}

	public void setPresentacionind(Integer presentacionind) {
		this.presentacionind = presentacionind;
	}


	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getTapa() {
		return this.tapa;
	}

	public void setTapa(String tapa) {
		this.tapa = tapa;
	}


	public double getToneladas() {
		return this.toneladas;
	}

	public void setToneladas(double toneladas) {
		this.toneladas = toneladas;
	}


	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="produccionOrdenPedido")
	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public PouchProceso addPouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().add(pouchProceso);
		pouchProceso.setProduccionOrdenPedido(this);

		return pouchProceso;
	}

	public PouchProceso removePouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().remove(pouchProceso);
		pouchProceso.setProduccionOrdenPedido(null);

		return pouchProceso;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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

}