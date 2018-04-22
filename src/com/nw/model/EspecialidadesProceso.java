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
public class EspecialidadesProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idespecialidadesproceso;

	private Timestamp fechareg;

	private Long ordenproduccion;

	//bi-directional many-to-one association to EspecialidadesReceta
	@ManyToOne
	@JoinColumn(name="idespecialidadesreceta")
	private EspecialidadesReceta especialidadesReceta;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="especialidadesProceso")
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;

	public EspecialidadesProceso() {
	}

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

	public EspecialidadesReceta getEspecialidadesReceta() {
		return this.especialidadesReceta;
	}

	public void setEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		this.especialidadesReceta = especialidadesReceta;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

}