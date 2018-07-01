package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the produccion_detalle_orden database table.
 * 
 */
@Entity
@Table(name="produccion_detalle_orden")
@NamedQuery(name="ProduccionDetalleOrden.findAll", query="SELECT p FROM ProduccionDetalleOrden p")
public class ProduccionDetalleOrden implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idproducciondetalleorden;
	private double ac;
	private double ag;
	private Integer cajas;
	private String cliente;
	private double crudo;
	private String destino;
	private double dre;
	private String envase;
	private String esp;
	private double fi;
	private double fill;
	private double flake;
	private Integer item;
	private double latas;
	private double lomolimpio;
	private String marca;
	private Integer materialfer;
	private Integer materialhal;
	private double mesa;
	private String observacion;
	private String orden;
	private Integer ordenfer;
	private Integer ordenhal;
	private String presentacion;
	private String producto;
	private String ps;
	private double ralladoempacado;
	private double ren;
	private Boolean reproceso;
	private Integer semana;
	private String tapa;
	private String luthy;
	private String cerradora;
	private double ton;
	private String video;
	private double formato;
	private List<EsterilizadoCoche> esterilizadoCoches;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoFichaTecnica> envasadoFichaTecnicas;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;

	public ProduccionDetalleOrden() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdproducciondetalleorden() {
		return this.idproducciondetalleorden;
	}

	public void setIdproducciondetalleorden(Integer idproducciondetalleorden) {
		this.idproducciondetalleorden = idproducciondetalleorden;
	}


	public double getAc() {
		return this.ac;
	}

	public void setAc(double ac) {
		this.ac = ac;
	}


	public double getAg() {
		return this.ag;
	}

	public void setAg(double ag) {
		this.ag = ag;
	}


	public Integer getCajas() {
		return this.cajas;
	}

	public void setCajas(Integer cajas) {
		this.cajas = cajas;
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


	public double getDre() {
		return this.dre;
	}

	public void setDre(double dre) {
		this.dre = dre;
	}


	public String getEnvase() {
		return this.envase;
	}

	public void setEnvase(String envase) {
		this.envase = envase;
	}


	public String getEsp() {
		return this.esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}


	public double getFi() {
		return this.fi;
	}

	public void setFi(double fi) {
		this.fi = fi;
	}


	public double getFill() {
		return this.fill;
	}

	public void setFill(double fill) {
		this.fill = fill;
	}


	public double getFlake() {
		return this.flake;
	}

	public void setFlake(double flake) {
		this.flake = flake;
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


	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getMaterialfer() {
		return this.materialfer;
	}

	public void setMaterialfer(Integer materialfer) {
		this.materialfer = materialfer;
	}


	public Integer getMaterialhal() {
		return this.materialhal;
	}

	public void setMaterialhal(Integer materialhal) {
		this.materialhal = materialhal;
	}


	public double getMesa() {
		return this.mesa;
	}

	public void setMesa(double mesa) {
		this.mesa = mesa;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}


	public Integer getOrdenfer() {
		return this.ordenfer;
	}

	public void setOrdenfer(Integer ordenfer) {
		this.ordenfer = ordenfer;
	}


	public Integer getOrdenhal() {
		return this.ordenhal;
	}

	public void setOrdenhal(Integer ordenhal) {
		this.ordenhal = ordenhal;
	}


	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getPs() {
		return this.ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}


	public double getRalladoempacado() {
		return this.ralladoempacado;
	}

	public void setRalladoempacado(double ralladoempacado) {
		this.ralladoempacado = ralladoempacado;
	}


	public double getRen() {
		return this.ren;
	}

	public void setRen(double ren) {
		this.ren = ren;
	}


	public Boolean getReproceso() {
		return this.reproceso;
	}

	public void setReproceso(Boolean reproceso) {
		this.reproceso = reproceso;
	}


	public Integer getSemana() {
		return this.semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}


	public String getTapa() {
		return this.tapa;
	}

	public void setTapa(String tapa) {
		this.tapa = tapa;
	}


	public double getTon() {
		return this.ton;
	}

	public void setTon(double ton) {
		this.ton = ton;
	}


	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	
	public double getFormato() {
		return formato;
	}

	public void setFormato(double formato) {
		this.formato = formato;
	}


	public String getLuthy() {
		return luthy;
	}

	public void setLuthy(String luthy) {
		this.luthy = luthy;
	}


	public String getCerradora() {
		return cerradora;
	}

	public void setCerradora(String cerradora) {
		this.cerradora = cerradora;
	}

	//bi-directional many-to-one association to EsterilizadoCoche
	@OneToMany(mappedBy="produccionDetalleOrden")
	public List<EsterilizadoCoche> getEsterilizadoCoches() {
		return this.esterilizadoCoches;
	}

	public void setEsterilizadoCoches(List<EsterilizadoCoche> esterilizadoCoches) {
		this.esterilizadoCoches = esterilizadoCoches;
	}

	public EsterilizadoCoche addEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().add(esterilizadoCoch);
		esterilizadoCoch.setProduccionDetalleOrden(this);

		return esterilizadoCoch;
	}

	public EsterilizadoCoche removeEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().remove(esterilizadoCoch);
		esterilizadoCoch.setProduccionDetalleOrden(null);

		return esterilizadoCoch;
	}
		
	
	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="produccionDetalleOrden")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setProduccionDetalleOrden(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setProduccionDetalleOrden(null);

		return envasadoControlPesoFillCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@OneToMany(mappedBy="produccionDetalleOrden")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabeceras() {
		return this.envasadoControlPesoNetoCabeceras;
	}

	public void setEnvasadoControlPesoNetoCabeceras(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras) {
		this.envasadoControlPesoNetoCabeceras = envasadoControlPesoNetoCabeceras;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setProduccionDetalleOrden(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setProduccionDetalleOrden(null);

		return envasadoControlPesoNetoCabecera;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="produccionDetalleOrden")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setProduccionDetalleOrden(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setProduccionDetalleOrden(null);

		return envasadoDetalleProcesoCambio;
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
	
	
	//bi-directional many-to-one association to EnvasadoFichaTecnica
	@OneToMany(mappedBy="produccionDetalleOrden")
	public List<EnvasadoFichaTecnica> getEnvasadoFichaTecnicas() {
		return this.envasadoFichaTecnicas;
	}

	public void setEnvasadoFichaTecnicas(List<EnvasadoFichaTecnica> envasadoFichaTecnicas) {
		this.envasadoFichaTecnicas = envasadoFichaTecnicas;
	}

	public EnvasadoFichaTecnica addEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().add(envasadoFichaTecnica);
		envasadoFichaTecnica.setProduccionDetalleOrden(this);

		return envasadoFichaTecnica;
	}

	public EnvasadoFichaTecnica removeEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().remove(envasadoFichaTecnica);
		envasadoFichaTecnica.setProduccionDetalleOrden(null);

		return envasadoFichaTecnica;
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