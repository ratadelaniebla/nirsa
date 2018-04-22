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
public class CalidadPccRemuestreoCajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadpccremuestreocajon;

	private String accion;

	private String desviacion;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="calidadPccRemuestreoCajon")
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadPccRemuestreoCajon() {
	}

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

	public List<CalidadDetallePccRemuestreoCajon> getCalidadDetallePccRemuestreoCajons() {
		return this.calidadDetallePccRemuestreoCajons;
	}

	public void setCalidadDetallePccRemuestreoCajons(List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons) {
		this.calidadDetallePccRemuestreoCajons = calidadDetallePccRemuestreoCajons;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}