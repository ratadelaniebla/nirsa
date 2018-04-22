package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_descongelado_temp_pescado database table.
 * 
 */
@Entity
@Table(name="calidad_descongelado_temp_pescado")
public class CalidadDescongeladoTempPescado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddescongeladotemppescado;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempPescado
	@OneToMany(mappedBy="calidadDescongeladoTempPescado")
	private List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	private DescongeladoDetalleProceso descongeladoDetalleProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadDescongeladoTempPescado() {
	}

	public Long getIdcalidaddescongeladotemppescado() {
		return this.idcalidaddescongeladotemppescado;
	}

	public void setIdcalidaddescongeladotemppescado(Long idcalidaddescongeladotemppescado) {
		this.idcalidaddescongeladotemppescado = idcalidaddescongeladotemppescado;
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

	public List<CalidadDescongeladoDetalleTempPescado> getCalidadDescongeladoDetalleTempPescados() {
		return this.calidadDescongeladoDetalleTempPescados;
	}

	public void setCalidadDescongeladoDetalleTempPescados(List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados) {
		this.calidadDescongeladoDetalleTempPescados = calidadDescongeladoDetalleTempPescados;
	}

	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
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