package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the especialidades_proceso database table.
 * 
 */
@Entity
@Table(name="especialidades_proceso")
@NamedQuery(name="EspecialidadesProceso.findAll", query="SELECT e FROM EspecialidadesProceso e")
public class EspecialidadesProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idespecialidadesproceso;
	private Timestamp fechareg;
	private Long ordenproduccion;
	private EspecialidadesReceta especialidadesReceta;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Usuario usuario;
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;

	public EspecialidadesProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdespecialidadesproceso() {
		return this.idespecialidadesproceso;
	}

	public void setIdespecialidadesproceso(Long idespecialidadesproceso) {
		this.idespecialidadesproceso = idespecialidadesproceso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Long getOrdenproduccion() {
		return this.ordenproduccion;
	}

	public void setOrdenproduccion(Long ordenproduccion) {
		this.ordenproduccion = ordenproduccion;
	}


	//bi-directional many-to-one association to EspecialidadesReceta
	@ManyToOne
	@JoinColumn(name="idespecialidadesreceta")
	public EspecialidadesReceta getEspecialidadesReceta() {
		return this.especialidadesReceta;
	}

	public void setEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		this.especialidadesReceta = especialidadesReceta;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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


	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="especialidadesProceso")
	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public EspecialidadesProcesoEnlatado addEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().add(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setEspecialidadesProceso(this);

		return especialidadesProcesoEnlatado;
	}

	public EspecialidadesProcesoEnlatado removeEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().remove(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setEspecialidadesProceso(null);

		return especialidadesProcesoEnlatado;
	}

}