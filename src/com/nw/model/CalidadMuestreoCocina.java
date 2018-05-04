package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestreo_cocina database table.
 * 
 */
@Entity
@Table(name="calidad_muestreo_cocina")
@NamedQuery(name="CalidadMuestreoCocina.findAll", query="SELECT c FROM CalidadMuestreoCocina c")
public class CalidadMuestreoCocina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestreococina;
	private Timestamp fechareg;
	private String observacion;
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadMuestreoCocina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadmuestreococina() {
		return this.idcalidadmuestreococina;
	}

	public void setIdcalidadmuestreococina(Long idcalidadmuestreococina) {
		this.idcalidadmuestreococina = idcalidadmuestreococina;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="calidadMuestreoCocina")
	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public CalidadDetalleMuestreoCocina addCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().add(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setCalidadMuestreoCocina(this);

		return calidadDetalleMuestreoCocina;
	}

	public CalidadDetalleMuestreoCocina removeCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().remove(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setCalidadMuestreoCocina(null);

		return calidadDetalleMuestreoCocina;
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