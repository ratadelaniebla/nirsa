package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_descongelado_temp_agua database table.
 * 
 */
@Entity
@Table(name="calidad_descongelado_temp_agua")
@NamedQuery(name="CalidadDescongeladoTempAgua.findAll", query="SELECT c FROM CalidadDescongeladoTempAgua c")
public class CalidadDescongeladoTempAgua implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidaddescongeladotempagua;
	private Timestamp fechareg;
	private String observacion;
	private List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas;
	private DescongeladoDetalleProceso descongeladoDetalleProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadDescongeladoTempAgua() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidaddescongeladotempagua() {
		return this.idcalidaddescongeladotempagua;
	}

	public void setIdcalidaddescongeladotempagua(Long idcalidaddescongeladotempagua) {
		this.idcalidaddescongeladotempagua = idcalidaddescongeladotempagua;
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


	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempAgua
	@OneToMany(mappedBy="calidadDescongeladoTempAgua")
	public List<CalidadDescongeladoDetalleTempAgua> getCalidadDescongeladoDetalleTempAguas() {
		return this.calidadDescongeladoDetalleTempAguas;
	}

	public void setCalidadDescongeladoDetalleTempAguas(List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas) {
		this.calidadDescongeladoDetalleTempAguas = calidadDescongeladoDetalleTempAguas;
	}

	public CalidadDescongeladoDetalleTempAgua addCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().add(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setCalidadDescongeladoTempAgua(this);

		return calidadDescongeladoDetalleTempAgua;
	}

	public CalidadDescongeladoDetalleTempAgua removeCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().remove(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setCalidadDescongeladoTempAgua(null);

		return calidadDescongeladoDetalleTempAgua;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
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