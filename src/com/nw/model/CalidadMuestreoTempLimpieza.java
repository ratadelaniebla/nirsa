package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestreo_temp_limpieza database table.
 * 
 */
@Entity
@Table(name="calidad_muestreo_temp_limpieza")
@NamedQuery(name="CalidadMuestreoTempLimpieza.findAll", query="SELECT c FROM CalidadMuestreoTempLimpieza c")
public class CalidadMuestreoTempLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestreotemplimpieza;
	private Timestamp fechareg;
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;
	private LimpiezaProceso limpiezaProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadMuestreoTempLimpieza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadmuestreotemplimpieza() {
		return this.idcalidadmuestreotemplimpieza;
	}

	public void setIdcalidadmuestreotemplimpieza(Long idcalidadmuestreotemplimpieza) {
		this.idcalidadmuestreotemplimpieza = idcalidadmuestreotemplimpieza;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="calidadMuestreoTempLimpieza")
	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public CalidadDetalleMuestreoTempLimpieza addCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().add(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setCalidadMuestreoTempLimpieza(this);

		return calidadDetalleMuestreoTempLimpieza;
	}

	public CalidadDetalleMuestreoTempLimpieza removeCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().remove(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setCalidadMuestreoTempLimpieza(null);

		return calidadDetalleMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
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

}