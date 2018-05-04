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
@NamedQuery(name="EspecialidadesProcesoEnlatado.findAll", query="SELECT e FROM EspecialidadesProcesoEnlatado e")
public class EspecialidadesProcesoEnlatado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idespecialidadesprocesollenado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Integer total;
	private List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados;
	private EspecialidadesProceso especialidadesProceso;
	private ProduccionDetalleLote produccionDetalleLote;
	private Turno turno;
	private Usuario usuario;

	public EspecialidadesProcesoEnlatado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EspecialidadesIncidenciaEnlatado
	@OneToMany(mappedBy="especialidadesProcesoEnlatado")
	public List<EspecialidadesIncidenciaEnlatado> getEspecialidadesIncidenciaEnlatados() {
		return this.especialidadesIncidenciaEnlatados;
	}

	public void setEspecialidadesIncidenciaEnlatados(List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados) {
		this.especialidadesIncidenciaEnlatados = especialidadesIncidenciaEnlatados;
	}

	public EspecialidadesIncidenciaEnlatado addEspecialidadesIncidenciaEnlatado(EspecialidadesIncidenciaEnlatado especialidadesIncidenciaEnlatado) {
		getEspecialidadesIncidenciaEnlatados().add(especialidadesIncidenciaEnlatado);
		especialidadesIncidenciaEnlatado.setEspecialidadesProcesoEnlatado(this);

		return especialidadesIncidenciaEnlatado;
	}

	public EspecialidadesIncidenciaEnlatado removeEspecialidadesIncidenciaEnlatado(EspecialidadesIncidenciaEnlatado especialidadesIncidenciaEnlatado) {
		getEspecialidadesIncidenciaEnlatados().remove(especialidadesIncidenciaEnlatado);
		especialidadesIncidenciaEnlatado.setEspecialidadesProcesoEnlatado(null);

		return especialidadesIncidenciaEnlatado;
	}


	//bi-directional many-to-one association to EspecialidadesProceso
	@ManyToOne
	@JoinColumn(name="idespecialidadesproceso")
	public EspecialidadesProceso getEspecialidadesProceso() {
		return this.especialidadesProceso;
	}

	public void setEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		this.especialidadesProceso = especialidadesProceso;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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