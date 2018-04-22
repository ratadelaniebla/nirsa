package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestreo_temp_panzas_eviscerado database table.
 * 
 */
@Entity
@Table(name="calidad_muestreo_temp_panzas_eviscerado")
public class CalidadMuestreoTempPanzasEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestreotemppanzaseviscerado;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="calidadMuestreoTempPanzasEviscerado")
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;

	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	private EvisceradoProceso evisceradoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestreoTempPanzasEviscerado() {
	}

	public Long getIdcalidadmuestreotemppanzaseviscerado() {
		return this.idcalidadmuestreotemppanzaseviscerado;
	}

	public void setIdcalidadmuestreotemppanzaseviscerado(Long idcalidadmuestreotemppanzaseviscerado) {
		this.idcalidadmuestreotemppanzaseviscerado = idcalidadmuestreotemppanzaseviscerado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
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