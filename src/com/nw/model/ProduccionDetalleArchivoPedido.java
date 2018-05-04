package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produccion_detalle_archivo_pedidos database table.
 * 
 */
@Entity
@Table(name="produccion_detalle_archivo_pedidos")
@NamedQuery(name="ProduccionDetalleArchivoPedido.findAll", query="SELECT p FROM ProduccionDetalleArchivoPedido p")
public class ProduccionDetalleArchivoPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long producciondetallearchivopedidos;
	private String aceite;
	private double aceitexlata;
	private String agua;
	private double cajas;
	private double cajas2;
	private double cajasprograma;
	private String cerradora;
	private String cliente;
	private double crudo;
	private String destino;
	private double drenado;
	private double empacado;
	private String envase;
	private String especie;
	private double fill;
	private double fillpor;
	private double flakeenproceso;
	private double flakeporcentaje;
	private double formato;
	private Integer item;
	private double latas;
	private double lomolimpio;
	private String luthi;
	private String marca;
	private Integer materialfert;
	private Integer materialhalb;
	private String orden;
	private Integer ordenfert;
	private Integer ordenhalb;
	private String origen;
	private double pescaprograma;
	private String posicion;
	private String presentacion;
	private Integer presentacionind;
	private String producto;
	private double ralladoempacado;
	private double rendimiento;
	private String tapa;
	private double toneladas;
	private double totalaceite;
	private double totallomolimpio;
	private double totalpescadocrudo;
	private double unidades;
	private String video;
	private ProduccionCargaArchivoPedido produccionCargaArchivoPedido;

	public ProduccionDetalleArchivoPedido() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getProducciondetallearchivopedidos() {
		return this.producciondetallearchivopedidos;
	}

	public void setProducciondetallearchivopedidos(Long producciondetallearchivopedidos) {
		this.producciondetallearchivopedidos = producciondetallearchivopedidos;
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


	public double getCajas2() {
		return this.cajas2;
	}

	public void setCajas2(double cajas2) {
		this.cajas2 = cajas2;
	}


	public double getCajasprograma() {
		return this.cajasprograma;
	}

	public void setCajasprograma(double cajasprograma) {
		this.cajasprograma = cajasprograma;
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


	public double getCrudo() {
		return this.crudo;
	}

	public void setCrudo(double crudo) {
		this.crudo = crudo;
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


	public double getEmpacado() {
		return this.empacado;
	}

	public void setEmpacado(double empacado) {
		this.empacado = empacado;
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


	public double getFlakeenproceso() {
		return this.flakeenproceso;
	}

	public void setFlakeenproceso(double flakeenproceso) {
		this.flakeenproceso = flakeenproceso;
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


	public double getLomolimpio() {
		return this.lomolimpio;
	}

	public void setLomolimpio(double lomolimpio) {
		this.lomolimpio = lomolimpio;
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


	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public double getPescaprograma() {
		return this.pescaprograma;
	}

	public void setPescaprograma(double pescaprograma) {
		this.pescaprograma = pescaprograma;
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


	public double getRalladoempacado() {
		return this.ralladoempacado;
	}

	public void setRalladoempacado(double ralladoempacado) {
		this.ralladoempacado = ralladoempacado;
	}


	public double getRendimiento() {
		return this.rendimiento;
	}

	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
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


	public double getTotalaceite() {
		return this.totalaceite;
	}

	public void setTotalaceite(double totalaceite) {
		this.totalaceite = totalaceite;
	}


	public double getTotallomolimpio() {
		return this.totallomolimpio;
	}

	public void setTotallomolimpio(double totallomolimpio) {
		this.totallomolimpio = totallomolimpio;
	}


	public double getTotalpescadocrudo() {
		return this.totalpescadocrudo;
	}

	public void setTotalpescadocrudo(double totalpescadocrudo) {
		this.totalpescadocrudo = totalpescadocrudo;
	}


	public double getUnidades() {
		return this.unidades;
	}

	public void setUnidades(double unidades) {
		this.unidades = unidades;
	}


	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	//bi-directional many-to-one association to ProduccionCargaArchivoPedido
	@ManyToOne
	@JoinColumn(name="idproduccioncargaarchivopedidos")
	public ProduccionCargaArchivoPedido getProduccionCargaArchivoPedido() {
		return this.produccionCargaArchivoPedido;
	}

	public void setProduccionCargaArchivoPedido(ProduccionCargaArchivoPedido produccionCargaArchivoPedido) {
		this.produccionCargaArchivoPedido = produccionCargaArchivoPedido;
	}

}