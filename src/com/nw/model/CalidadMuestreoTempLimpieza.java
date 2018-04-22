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
public class CalidadMuestreoTempLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestreotemplimpieza;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="calidadMuestreoTempLimpieza")
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestreoTempLimpieza() {
	}

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

	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}