package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the descongelado_ducha_apertura_cierre_detalle database table.
 * 
 */
@Entity
@Table(name="descongelado_ducha_apertura_cierre_detalle")
@NamedQuery(name="DescongeladoDuchaAperturaCierreDetalle.findAll", query="SELECT d FROM DescongeladoDuchaAperturaCierreDetalle d")
public class DescongeladoDuchaAperturaCierreDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladoduchaaperturacierredetalle;
	private Integer estado;
	private Integer estadoduchada;
	private Integer finproceso;
	private Timestamp horaaperturaducha;
	private Timestamp horacierreducha;
	private Timestamp horafindescongelado;
	private Timestamp horainiciodescongelado;
	private double horastranscurridas;
	private double minutostranscurridos;
	private Integer numeroduchada;
	private Integer numeroduchadageneral;
	private String observacion;
	private double segundostranscurridos;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions1;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions2;
	private List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas;
	private List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos1;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos2;
	private List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados;
	private DescongeladoDucha descongeladoDucha;
	private Produccion produccion;
	private Usuario usuario;

	public DescongeladoDuchaAperturaCierreDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladoduchaaperturacierredetalle() {
		return this.iddescongeladoduchaaperturacierredetalle;
	}

	public void setIddescongeladoduchaaperturacierredetalle(Long iddescongeladoduchaaperturacierredetalle) {
		this.iddescongeladoduchaaperturacierredetalle = iddescongeladoduchaaperturacierredetalle;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getEstadoduchada() {
		return this.estadoduchada;
	}

	public void setEstadoduchada(Integer estadoduchada) {
		this.estadoduchada = estadoduchada;
	}


	public Integer getFinproceso() {
		return this.finproceso;
	}

	public void setFinproceso(Integer finproceso) {
		this.finproceso = finproceso;
	}


	public Timestamp getHoraaperturaducha() {
		return this.horaaperturaducha;
	}

	public void setHoraaperturaducha(Timestamp horaaperturaducha) {
		this.horaaperturaducha = horaaperturaducha;
	}


	public Timestamp getHoracierreducha() {
		return this.horacierreducha;
	}

	public void setHoracierreducha(Timestamp horacierreducha) {
		this.horacierreducha = horacierreducha;
	}


	public Timestamp getHorafindescongelado() {
		return this.horafindescongelado;
	}

	public void setHorafindescongelado(Timestamp horafindescongelado) {
		this.horafindescongelado = horafindescongelado;
	}


	public Timestamp getHorainiciodescongelado() {
		return this.horainiciodescongelado;
	}

	public void setHorainiciodescongelado(Timestamp horainiciodescongelado) {
		this.horainiciodescongelado = horainiciodescongelado;
	}


	public double getHorastranscurridas() {
		return this.horastranscurridas;
	}

	public void setHorastranscurridas(double horastranscurridas) {
		this.horastranscurridas = horastranscurridas;
	}


	public double getMinutostranscurridos() {
		return this.minutostranscurridos;
	}

	public void setMinutostranscurridos(double minutostranscurridos) {
		this.minutostranscurridos = minutostranscurridos;
	}


	public Integer getNumeroduchada() {
		return this.numeroduchada;
	}

	public void setNumeroduchada(Integer numeroduchada) {
		this.numeroduchada = numeroduchada;
	}


	public Integer getNumeroduchadageneral() {
		return this.numeroduchadageneral;
	}

	public void setNumeroduchadageneral(Integer numeroduchadageneral) {
		this.numeroduchadageneral = numeroduchadageneral;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public double getSegundostranscurridos() {
		return this.segundostranscurridos;
	}

	public void setSegundostranscurridos(double segundostranscurridos) {
		this.segundostranscurridos = segundostranscurridos;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle1")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions1() {
		return this.descongeladoCajonModificacions1;
	}

	public void setDescongeladoCajonModificacions1(List<DescongeladoCajonModificacion> descongeladoCajonModificacions1) {
		this.descongeladoCajonModificacions1 = descongeladoCajonModificacions1;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacions1(DescongeladoCajonModificacion descongeladoCajonModificacions1) {
		getDescongeladoCajonModificacions1().add(descongeladoCajonModificacions1);
		descongeladoCajonModificacions1.setDescongeladoDuchaAperturaCierreDetalle1(this);

		return descongeladoCajonModificacions1;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacions1(DescongeladoCajonModificacion descongeladoCajonModificacions1) {
		getDescongeladoCajonModificacions1().remove(descongeladoCajonModificacions1);
		descongeladoCajonModificacions1.setDescongeladoDuchaAperturaCierreDetalle1(null);

		return descongeladoCajonModificacions1;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle2")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions2() {
		return this.descongeladoCajonModificacions2;
	}

	public void setDescongeladoCajonModificacions2(List<DescongeladoCajonModificacion> descongeladoCajonModificacions2) {
		this.descongeladoCajonModificacions2 = descongeladoCajonModificacions2;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacions2(DescongeladoCajonModificacion descongeladoCajonModificacions2) {
		getDescongeladoCajonModificacions2().add(descongeladoCajonModificacions2);
		descongeladoCajonModificacions2.setDescongeladoDuchaAperturaCierreDetalle2(this);

		return descongeladoCajonModificacions2;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacions2(DescongeladoCajonModificacion descongeladoCajonModificacions2) {
		getDescongeladoCajonModificacions2().remove(descongeladoCajonModificacions2);
		descongeladoCajonModificacions2.setDescongeladoDuchaAperturaCierreDetalle2(null);

		return descongeladoCajonModificacions2;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle")
	public List<DescongeladoDetalleDuchaAperturaTalla> getDescongeladoDetalleDuchaAperturaTallas() {
		return this.descongeladoDetalleDuchaAperturaTallas;
	}

	public void setDescongeladoDetalleDuchaAperturaTallas(List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas) {
		this.descongeladoDetalleDuchaAperturaTallas = descongeladoDetalleDuchaAperturaTallas;
	}

	public DescongeladoDetalleDuchaAperturaTalla addDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().add(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setDescongeladoDuchaAperturaCierreDetalle(this);

		return descongeladoDetalleDuchaAperturaTalla;
	}

	public DescongeladoDetalleDuchaAperturaTalla removeDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().remove(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setDescongeladoDuchaAperturaCierreDetalle(null);

		return descongeladoDetalleDuchaAperturaTalla;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaTallaMonitoreo
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle")
	public List<DescongeladoDetalleDuchaTallaMonitoreo> getDescongeladoDetalleDuchaTallaMonitoreos() {
		return this.descongeladoDetalleDuchaTallaMonitoreos;
	}

	public void setDescongeladoDetalleDuchaTallaMonitoreos(List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos) {
		this.descongeladoDetalleDuchaTallaMonitoreos = descongeladoDetalleDuchaTallaMonitoreos;
	}

	public DescongeladoDetalleDuchaTallaMonitoreo addDescongeladoDetalleDuchaTallaMonitoreo(DescongeladoDetalleDuchaTallaMonitoreo descongeladoDetalleDuchaTallaMonitoreo) {
		getDescongeladoDetalleDuchaTallaMonitoreos().add(descongeladoDetalleDuchaTallaMonitoreo);
		descongeladoDetalleDuchaTallaMonitoreo.setDescongeladoDuchaAperturaCierreDetalle(this);

		return descongeladoDetalleDuchaTallaMonitoreo;
	}

	public DescongeladoDetalleDuchaTallaMonitoreo removeDescongeladoDetalleDuchaTallaMonitoreo(DescongeladoDetalleDuchaTallaMonitoreo descongeladoDetalleDuchaTallaMonitoreo) {
		getDescongeladoDetalleDuchaTallaMonitoreos().remove(descongeladoDetalleDuchaTallaMonitoreo);
		descongeladoDetalleDuchaTallaMonitoreo.setDescongeladoDuchaAperturaCierreDetalle(null);

		return descongeladoDetalleDuchaTallaMonitoreo;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle1")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos1() {
		return this.descongeladoDetalleProcesos1;
	}

	public void setDescongeladoDetalleProcesos1(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos1) {
		this.descongeladoDetalleProcesos1 = descongeladoDetalleProcesos1;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProcesos1(DescongeladoDetalleProceso descongeladoDetalleProcesos1) {
		getDescongeladoDetalleProcesos1().add(descongeladoDetalleProcesos1);
		descongeladoDetalleProcesos1.setDescongeladoDuchaAperturaCierreDetalle1(this);

		return descongeladoDetalleProcesos1;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProcesos1(DescongeladoDetalleProceso descongeladoDetalleProcesos1) {
		getDescongeladoDetalleProcesos1().remove(descongeladoDetalleProcesos1);
		descongeladoDetalleProcesos1.setDescongeladoDuchaAperturaCierreDetalle1(null);

		return descongeladoDetalleProcesos1;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle2")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos2() {
		return this.descongeladoDetalleProcesos2;
	}

	public void setDescongeladoDetalleProcesos2(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos2) {
		this.descongeladoDetalleProcesos2 = descongeladoDetalleProcesos2;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProcesos2(DescongeladoDetalleProceso descongeladoDetalleProcesos2) {
		getDescongeladoDetalleProcesos2().add(descongeladoDetalleProcesos2);
		descongeladoDetalleProcesos2.setDescongeladoDuchaAperturaCierreDetalle2(this);

		return descongeladoDetalleProcesos2;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProcesos2(DescongeladoDetalleProceso descongeladoDetalleProcesos2) {
		getDescongeladoDetalleProcesos2().remove(descongeladoDetalleProcesos2);
		descongeladoDetalleProcesos2.setDescongeladoDuchaAperturaCierreDetalle2(null);

		return descongeladoDetalleProcesos2;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoFinForzado
	@OneToMany(mappedBy="descongeladoDuchaAperturaCierreDetalle")
	public List<DescongeladoDetalleProcesoFinForzado> getDescongeladoDetalleProcesoFinForzados() {
		return this.descongeladoDetalleProcesoFinForzados;
	}

	public void setDescongeladoDetalleProcesoFinForzados(List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados) {
		this.descongeladoDetalleProcesoFinForzados = descongeladoDetalleProcesoFinForzados;
	}

	public DescongeladoDetalleProcesoFinForzado addDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().add(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setDescongeladoDuchaAperturaCierreDetalle(this);

		return descongeladoDetalleProcesoFinForzado;
	}

	public DescongeladoDetalleProcesoFinForzado removeDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().remove(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setDescongeladoDuchaAperturaCierreDetalle(null);

		return descongeladoDetalleProcesoFinForzado;
	}


	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="idducha")
	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
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