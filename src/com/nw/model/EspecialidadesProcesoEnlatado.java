package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the especialidades_proceso_enlatado database table.
 * 
 */
@Entity
@Table(name="especialidades_proceso_enlatado")
public class EspecialidadesProcesoEnlatado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idespecialidadesprocesollenado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Integer total;

	//bi-directional many-to-one association to EspecialidadesIncidenciaEnlatado
	@OneToMany(mappedBy="especialidadesProcesoEnlatado")
	private List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados;

	//bi-directional many-to-one association to EspecialidadesProceso
	@ManyToOne
	@JoinColumn(name="idespecialidadesproceso")
	private EspecialidadesProceso especialidadesProceso;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	private ProduccionDetalleLote produccionDetalleLote;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public EspecialidadesProcesoEnlatado() {
	}

	public Long getIdespecialidadesprocesollenado() {
		return this.idespecialidadesprocesollenado;
	}

	public void setIdespecialidadesprocesollenado(Long idespecialidadesprocesollenado) {
		this.idespecialidadesprocesollenado = idespecialidadesprocesollenado;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<EspecialidadesIncidenciaEnlatado> getEspecialidadesIncidenciaEnlatados() {
		return this.especialidadesIncidenciaEnlatados;
	}

	public void setEspecialidadesIncidenciaEnlatados(List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados) {
		this.especialidadesIncidenciaEnlatados = especialidadesIncidenciaEnlatados;
	}

	public EspecialidadesProceso getEspecialidadesProceso() {
		return this.especialidadesProceso;
	}

	public void setEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		this.especialidadesProceso = especialidadesProceso;
	}

	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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