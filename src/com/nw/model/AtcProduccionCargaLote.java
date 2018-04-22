package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_produccion_carga_lote database table.
 * 
 */
@Entity
@Table(name="atc_produccion_carga_lote")
public class AtcProduccionCargaLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcproduccioncargalote;

	private String almacen;

	private double cant;

	private double cf;

	private String codigobarco;

	private double cr;

	private String destinos;

	private String destinoscliente;

	private String especietalla;

	private Timestamp fechadescarga;

	private String hic;

	private String hsc;

	private Integer idatcturno;

	private Integer idlote;

	private Integer item;

	private String nombrebarco;

	private String observaciones;

	private String ordenfileteado;

	private String ordenprecocido;

	private String origen;

	private Integer pedido;

	private Integer pescados;

	private double peso;

	private String poza;

	private Integer registro;

	private double rt;

	private double salmax;

	private double salmin;

	private String statuspesca;

	private double tempcocina;

	private double tempcurva;

	private String viaje;

	//bi-directional many-to-one association to AtcProduccionArchivoCargaLote
	@ManyToOne
	@JoinColumn(name="idatcproduccionarchivocargalote")
	private AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote;

	public AtcProduccionCargaLote() {
	}

	public Long getIdatcproduccioncargalote() {
		return this.idatcproduccioncargalote;
	}

	public void setIdatcproduccioncargalote(Long idatcproduccioncargalote) {
		this.idatcproduccioncargalote = idatcproduccioncargalote;
	}

	public String getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public double getCant() {
		return this.cant;
	}

	public void setCant(double cant) {
		this.cant = cant;
	}

	public double getCf() {
		return this.cf;
	}

	public void setCf(double cf) {
		this.cf = cf;
	}

	public String getCodigobarco() {
		return this.codigobarco;
	}

	public void setCodigobarco(String codigobarco) {
		this.codigobarco = codigobarco;
	}

	public double getCr() {
		return this.cr;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}

	public String getDestinos() {
		return this.destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}

	public String getDestinoscliente() {
		return this.destinoscliente;
	}

	public void setDestinoscliente(String destinoscliente) {
		this.destinoscliente = destinoscliente;
	}

	public String getEspecietalla() {
		return this.especietalla;
	}

	public void setEspecietalla(String especietalla) {
		this.especietalla = especietalla;
	}

	public Timestamp getFechadescarga() {
		return this.fechadescarga;
	}

	public void setFechadescarga(Timestamp fechadescarga) {
		this.fechadescarga = fechadescarga;
	}

	public String getHic() {
		return this.hic;
	}

	public void setHic(String hic) {
		this.hic = hic;
	}

	public String getHsc() {
		return this.hsc;
	}

	public void setHsc(String hsc) {
		this.hsc = hsc;
	}

	public Integer getIdatcturno() {
		return this.idatcturno;
	}

	public void setIdatcturno(Integer idatcturno) {
		this.idatcturno = idatcturno;
	}

	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getNombrebarco() {
		return this.nombrebarco;
	}

	public void setNombrebarco(String nombrebarco) {
		this.nombrebarco = nombrebarco;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOrdenfileteado() {
		return this.ordenfileteado;
	}

	public void setOrdenfileteado(String ordenfileteado) {
		this.ordenfileteado = ordenfileteado;
	}

	public String getOrdenprecocido() {
		return this.ordenprecocido;
	}

	public void setOrdenprecocido(String ordenprecocido) {
		this.ordenprecocido = ordenprecocido;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Integer getPedido() {
		return this.pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getPescados() {
		return this.pescados;
	}

	public void setPescados(Integer pescados) {
		this.pescados = pescados;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPoza() {
		return this.poza;
	}

	public void setPoza(String poza) {
		this.poza = poza;
	}

	public Integer getRegistro() {
		return this.registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public double getRt() {
		return this.rt;
	}

	public void setRt(double rt) {
		this.rt = rt;
	}

	public double getSalmax() {
		return this.salmax;
	}

	public void setSalmax(double salmax) {
		this.salmax = salmax;
	}

	public double getSalmin() {
		return this.salmin;
	}

	public void setSalmin(double salmin) {
		this.salmin = salmin;
	}

	public String getStatuspesca() {
		return this.statuspesca;
	}

	public void setStatuspesca(String statuspesca) {
		this.statuspesca = statuspesca;
	}

	public double getTempcocina() {
		return this.tempcocina;
	}

	public void setTempcocina(double tempcocina) {
		this.tempcocina = tempcocina;
	}

	public double getTempcurva() {
		return this.tempcurva;
	}

	public void setTempcurva(double tempcurva) {
		this.tempcurva = tempcurva;
	}

	public String getViaje() {
		return this.viaje;
	}

	public void setViaje(String viaje) {
		this.viaje = viaje;
	}

	public AtcProduccionArchivoCargaLote getAtcProduccionArchivoCargaLote() {
		return this.atcProduccionArchivoCargaLote;
	}

	public void setAtcProduccionArchivoCargaLote(AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote) {
		this.atcProduccionArchivoCargaLote = atcProduccionArchivoCargaLote;
	}

}