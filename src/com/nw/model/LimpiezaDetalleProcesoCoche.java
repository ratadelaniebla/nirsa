package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_proceso_coche")
@NamedQuery(name="LimpiezaDetalleProcesoCoche.findAll", query="SELECT l FROM LimpiezaDetalleProcesoCoche l")
public class LimpiezaDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalleprocesocoche;
	private Timestamp fechaactualizacion;
	private Timestamp fechareg;
	private Timestamp fecharegtara;
	private Integer idtallaAjustada;
	private String idusuarioactualizacion;
	private String idusuariotara;
	private double peso;
	private double tara;
	private String tipoingreso;
	private String tipoingresotara;
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LimpiezaLinea limpiezaLinea;
	private Turno turno;
	private Usuario usuario;
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;

	public LimpiezaDetalleProcesoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetalleprocesocoche() {
		return this.idlimpiezadetalleprocesocoche;
	}

	public void setIdlimpiezadetalleprocesocoche(Long idlimpiezadetalleprocesocoche) {
		this.idlimpiezadetalleprocesocoche = idlimpiezadetalleprocesocoche;
	}


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegtara() {
		return this.fecharegtara;
	}

	public void setFecharegtara(Timestamp fecharegtara) {
		this.fecharegtara = fecharegtara;
	}


	@Column(name="idtalla_ajustada")
	public Integer getIdtallaAjustada() {
		return this.idtallaAjustada;
	}

	public void setIdtallaAjustada(Integer idtallaAjustada) {
		this.idtallaAjustada = idtallaAjustada;
	}


	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}


	public String getIdusuariotara() {
		return this.idusuariotara;
	}

	public void setIdusuariotara(String idusuariotara) {
		this.idusuariotara = idusuariotara;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}


	public String getTipoingresotara() {
		return this.tipoingresotara;
	}

	public void setTipoingresotara(String tipoingresotara) {
		this.tipoingresotara = tipoingresotara;
	}


	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public LimpiezaAsignacionCanastilla addLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().add(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setLimpiezaDetalleProcesoCoche(this);

		return limpiezaAsignacionCanastilla;
	}

	public LimpiezaAsignacionCanastilla removeLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().remove(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setLimpiezaDetalleProcesoCoche(null);

		return limpiezaAsignacionCanastilla;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().add(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaDetalleProcesoCoche(this);

		return limpiezaCocheModificacion;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().remove(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setLimpiezaDetalleProcesoCoche(null);

		return limpiezaCocheModificacion;
	}


	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones() {
		return this.limpiezaCocheObservaciones;
	}

	public void setLimpiezaCocheObservaciones(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones) {
		this.limpiezaCocheObservaciones = limpiezaCocheObservaciones;
	}

	public LimpiezaCocheObservacione addLimpiezaCocheObservacione(LimpiezaCocheObservacione limpiezaCocheObservacione) {
		getLimpiezaCocheObservaciones().add(limpiezaCocheObservacione);
		limpiezaCocheObservacione.setLimpiezaDetalleProcesoCoche(this);

		return limpiezaCocheObservacione;
	}

	public LimpiezaCocheObservacione removeLimpiezaCocheObservacione(LimpiezaCocheObservacione limpiezaCocheObservacione) {
		getLimpiezaCocheObservaciones().remove(limpiezaCocheObservacione);
		limpiezaCocheObservacione.setLimpiezaDetalleProcesoCoche(null);

		return limpiezaCocheObservacione;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="evisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
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


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch addLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().add(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setLimpiezaDetalleProcesoCoche(this);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch removeLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().remove(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setLimpiezaDetalleProcesoCoche(null);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}

}