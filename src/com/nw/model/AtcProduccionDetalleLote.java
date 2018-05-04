package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_produccion_detalle_lote database table.
 * 
 */
@Entity
@Table(name="atc_produccion_detalle_lote")
@NamedQuery(name="AtcProduccionDetalleLote.findAll", query="SELECT a FROM AtcProduccionDetalleLote a")
public class AtcProduccionDetalleLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcproducciondetallelote;
	private String almacen;
	private double cant;
	private double cf;
	private double cr;
	private String destinos;
	private String destinoscliente;
	private Timestamp fechadescarga;
	private String hic;
	private String hsc;
	private Integer idcliente;
	private Integer idlote;
	private Integer idproducto;
	private Integer itemprograma;
	private String observaciones;
	private String ordenfileteado;
	private String ordenprecocido;
	private String origen;
	private Integer pedidocamara;
	private Integer pescados;
	private double peso;
	private double rt;
	private double salmax;
	private double salmin;
	private String statuspesca;
	private double tempcocina;
	private double tempcurva;
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;
	private AtcProduccion atcProduccion;
	private AtcTurno atcTurno;
	private BarcoDescarga barcoDescarga;
	private BarcoEstibaCuba barcoEstibaCuba;
	private EspecieTalla especieTalla;
	private List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons;

	public AtcProduccionDetalleLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcproducciondetallelote() {
		return this.idatcproducciondetallelote;
	}

	public void setIdatcproducciondetallelote(Long idatcproducciondetallelote) {
		this.idatcproducciondetallelote = idatcproducciondetallelote;
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


	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}


	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}


	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}


	public Integer getItemprograma() {
		return this.itemprograma;
	}

	public void setItemprograma(Integer itemprograma) {
		this.itemprograma = itemprograma;
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


	public Integer getPedidocamara() {
		return this.pedidocamara;
	}

	public void setPedidocamara(Integer pedidocamara) {
		this.pedidocamara = pedidocamara;
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcProduccionDetalleLote")
	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public AtcLimpiezaDetalleProcesoLote addAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().add(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcProduccionDetalleLote(this);

		return atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaDetalleProcesoLote removeAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().remove(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcProduccionDetalleLote(null);

		return atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}


	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@OneToMany(mappedBy="atcProduccionDetalleLote")
	public List<AtcProduccionDetalleLoteCajon> getAtcProduccionDetalleLoteCajons() {
		return this.atcProduccionDetalleLoteCajons;
	}

	public void setAtcProduccionDetalleLoteCajons(List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons) {
		this.atcProduccionDetalleLoteCajons = atcProduccionDetalleLoteCajons;
	}

	public AtcProduccionDetalleLoteCajon addAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		getAtcProduccionDetalleLoteCajons().add(atcProduccionDetalleLoteCajon);
		atcProduccionDetalleLoteCajon.setAtcProduccionDetalleLote(this);

		return atcProduccionDetalleLoteCajon;
	}

	public AtcProduccionDetalleLoteCajon removeAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		getAtcProduccionDetalleLoteCajons().remove(atcProduccionDetalleLoteCajon);
		atcProduccionDetalleLoteCajon.setAtcProduccionDetalleLote(null);

		return atcProduccionDetalleLoteCajon;
	}

}