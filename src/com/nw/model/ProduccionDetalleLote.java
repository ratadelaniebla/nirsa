package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produccion_detalle_lote database table.
 * 
 */
@Entity
@Table(name="produccion_detalle_lote")
@NamedQuery(name="ProduccionDetalleLote.findAll", query="SELECT p FROM ProduccionDetalleLote p")
public class ProduccionDetalleLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproducciondetallelote;
	private double absaceite;
	private double absagua;
	private String almacen;
	private double cant;
	private double cf;
	private double cr;
	private String destinos;
	private String destinoscliente;
	private Integer estado;
	private Integer estadoCarga;
	private Timestamp fechadescarga;
	private double firme;
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
	private double pastoso;
	private Integer pedidocamara;
	private Integer pescados;
	private double peso;
	private double rt;
	private double salmax;
	private double salmin;
	private double semifirme;
	private String statuspesca;
	private double suave;
	private double tempcocina;
	private double tempcurva;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private BarcoDescarga barcoDescarga;
	private BarcoEstibaCuba barcoEstibaCuba;
	private EspecieTalla especieTalla;
	private LimpiezaTipo limpiezaTipo;
	private Produccion produccion;
	private Turno turno;
	private List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons;

	public ProduccionDetalleLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdproducciondetallelote() {
		return this.idproducciondetallelote;
	}

	public void setIdproducciondetallelote(Long idproducciondetallelote) {
		this.idproducciondetallelote = idproducciondetallelote;
	}


	public double getAbsaceite() {
		return this.absaceite;
	}

	public void setAbsaceite(double absaceite) {
		this.absaceite = absaceite;
	}


	public double getAbsagua() {
		return this.absagua;
	}

	public void setAbsagua(double absagua) {
		this.absagua = absagua;
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


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	@Column(name="estado_carga")
	public Integer getEstadoCarga() {
		return this.estadoCarga;
	}

	public void setEstadoCarga(Integer estadoCarga) {
		this.estadoCarga = estadoCarga;
	}


	public Timestamp getFechadescarga() {
		return this.fechadescarga;
	}

	public void setFechadescarga(Timestamp fechadescarga) {
		this.fechadescarga = fechadescarga;
	}


	public double getFirme() {
		return this.firme;
	}

	public void setFirme(double firme) {
		this.firme = firme;
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


	public double getPastoso() {
		return this.pastoso;
	}

	public void setPastoso(double pastoso) {
		this.pastoso = pastoso;
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


	public double getSemifirme() {
		return this.semifirme;
	}

	public void setSemifirme(double semifirme) {
		this.semifirme = semifirme;
	}


	public String getStatuspesca() {
		return this.statuspesca;
	}

	public void setStatuspesca(String statuspesca) {
		this.statuspesca = statuspesca;
	}


	public double getSuave() {
		return this.suave;
	}

	public void setSuave(double suave) {
		this.suave = suave;
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


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="produccionDetalleLote")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setProduccionDetalleLote(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setProduccionDetalleLote(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="produccionDetalleLote")
	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public EspecialidadesProcesoEnlatado addEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().add(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setProduccionDetalleLote(this);

		return especialidadesProcesoEnlatado;
	}

	public EspecialidadesProcesoEnlatado removeEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().remove(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setProduccionDetalleLote(null);

		return especialidadesProcesoEnlatado;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="produccionDetalleLote")
	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public LimpiezaDetalleProcesoLote addLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().add(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setProduccionDetalleLote(this);

		return limpiezaDetalleProcesoLote;
	}

	public LimpiezaDetalleProcesoLote removeLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().remove(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setProduccionDetalleLote(null);

		return limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="produccionDetalleLote")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProduccionDetalleLote(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProduccionDetalleLote(null);

		return oeeDetalleMediosConDefecto;
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


	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
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


	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@OneToMany(mappedBy="produccionDetalleLote")
	public List<ProduccionDetalleLoteCajon> getProduccionDetalleLoteCajons() {
		return this.produccionDetalleLoteCajons;
	}

	public void setProduccionDetalleLoteCajons(List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons) {
		this.produccionDetalleLoteCajons = produccionDetalleLoteCajons;
	}

	public ProduccionDetalleLoteCajon addProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		getProduccionDetalleLoteCajons().add(produccionDetalleLoteCajon);
		produccionDetalleLoteCajon.setProduccionDetalleLote(this);

		return produccionDetalleLoteCajon;
	}

	public ProduccionDetalleLoteCajon removeProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		getProduccionDetalleLoteCajons().remove(produccionDetalleLoteCajon);
		produccionDetalleLoteCajon.setProduccionDetalleLote(null);

		return produccionDetalleLoteCajon;
	}

}