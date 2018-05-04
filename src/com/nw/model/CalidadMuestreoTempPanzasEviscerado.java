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
@NamedQuery(name="CalidadMuestreoTempPanzasEviscerado.findAll", query="SELECT c FROM CalidadMuestreoTempPanzasEviscerado c")
public class CalidadMuestreoTempPanzasEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestreotemppanzaseviscerado;
	private Timestamp fechareg;
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadMuestreoTempPanzasEviscerado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="calidadMuestreoTempPanzasEviscerado")
	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado addCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().add(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setCalidadMuestreoTempPanzasEviscerado(this);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado removeCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().remove(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setCalidadMuestreoTempPanzasEviscerado(null);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
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