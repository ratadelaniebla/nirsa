package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_pcc_remuestreo_cajon database table.
 * 
 */
@Entity
@Table(name="calidad_pcc_remuestreo_cajon")
@NamedQuery(name="CalidadPccRemuestreoCajon.findAll", query="SELECT c FROM CalidadPccRemuestreoCajon c")
public class CalidadPccRemuestreoCajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadpccremuestreocajon;
	private String accion;
	private String desviacion;
	private Timestamp fechareg;
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;
	private BarcoDescarga barcoDescarga;
	private Usuario usuario;

	public CalidadPccRemuestreoCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadpccremuestreocajon() {
		return this.idcalidadpccremuestreocajon;
	}

	public void setIdcalidadpccremuestreocajon(Long idcalidadpccremuestreocajon) {
		this.idcalidadpccremuestreocajon = idcalidadpccremuestreocajon;
	}


	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}


	public String getDesviacion() {
		return this.desviacion;
	}

	public void setDesviacion(String desviacion) {
		this.desviacion = desviacion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="calidadPccRemuestreoCajon")
	public List<CalidadDetallePccRemuestreoCajon> getCalidadDetallePccRemuestreoCajons() {
		return this.calidadDetallePccRemuestreoCajons;
	}

	public void setCalidadDetallePccRemuestreoCajons(List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons) {
		this.calidadDetallePccRemuestreoCajons = calidadDetallePccRemuestreoCajons;
	}

	public CalidadDetallePccRemuestreoCajon addCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().add(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setCalidadPccRemuestreoCajon(this);

		return calidadDetallePccRemuestreoCajon;
	}

	public CalidadDetallePccRemuestreoCajon removeCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().remove(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setCalidadPccRemuestreoCajon(null);

		return calidadDetallePccRemuestreoCajon;
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