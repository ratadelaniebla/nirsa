package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the esterilizado_proceso_parada database table.
 * 
 */
@Entity
@Table(name="esterilizado_proceso_parada")
@NamedQuery(name="EsterilizadoProcesoParada.findAll", query="SELECT e FROM EsterilizadoProcesoParada e")
public class EsterilizadoProcesoParada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idesterilizadoprocesoparada;
	private Integer blider;
	private Integer estado;
	private Timestamp horacerradoventeo;
	private Timestamp horainiciovapor;
	private Timestamp fechareg;
	private Long numerografica;
	private Integer numparada;
	private double presionmanometro;
	private double temperaturacerradoventeo;
	private double temperaturagrafica;
	private double temperaturainicial;
	private double temperaturamercurio;
	private Autoclave autoclave;
	private EsterilizadoProceso esterilizadoProceso;
	private Usuario usuario;
	private Produccion produccion;
	private List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches;

	public EsterilizadoProcesoParada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdesterilizadoprocesoparada() {
		return this.idesterilizadoprocesoparada;
	}

	public void setIdesterilizadoprocesoparada(Long idesterilizadoprocesoparada) {
		this.idesterilizadoprocesoparada = idesterilizadoprocesoparada;
	}


	public Integer getBlider() {
		return this.blider;
	}

	public void setBlider(Integer blider) {
		this.blider = blider;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getHoracerradoventeo() {
		return this.horacerradoventeo;
	}

	public void setHoracerradoventeo(Timestamp horacerradoventeo) {
		this.horacerradoventeo = horacerradoventeo;
	}


	public Timestamp getHorainiciovapor() {
		return this.horainiciovapor;
	}

	public void setHorainiciovapor(Timestamp horainiciovapor) {
		this.horainiciovapor = horainiciovapor;
	}

	
	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}
	

	public Long getNumerografica() {
		return this.numerografica;
	}

	public void setNumerografica(Long numerografica) {
		this.numerografica = numerografica;
	}


	public Integer getNumparada() {
		return this.numparada;
	}

	public void setNumparada(Integer numparada) {
		this.numparada = numparada;
	}


	public double getPresionmanometro() {
		return this.presionmanometro;
	}

	public void setPresionmanometro(double presionmanometro) {
		this.presionmanometro = presionmanometro;
	}


	public double getTemperaturacerradoventeo() {
		return this.temperaturacerradoventeo;
	}

	public void setTemperaturacerradoventeo(double temperaturacerradoventeo) {
		this.temperaturacerradoventeo = temperaturacerradoventeo;
	}


	public double getTemperaturagrafica() {
		return this.temperaturagrafica;
	}

	public void setTemperaturagrafica(double temperaturagrafica) {
		this.temperaturagrafica = temperaturagrafica;
	}


	public double getTemperaturainicial() {
		return this.temperaturainicial;
	}

	public void setTemperaturainicial(double temperaturainicial) {
		this.temperaturainicial = temperaturainicial;
	}


	public double getTemperaturamercurio() {
		return this.temperaturamercurio;
	}

	public void setTemperaturamercurio(double temperaturamercurio) {
		this.temperaturamercurio = temperaturamercurio;
	}


	//bi-directional many-to-one association to Autoclave
	@ManyToOne
	@JoinColumn(name="idautoclave")
	public Autoclave getAutoclave() {
		return this.autoclave;
	}

	public void setAutoclave(Autoclave autoclave) {
		this.autoclave = autoclave;
	}


	//bi-directional many-to-one association to EsterilizadoProceso
	@ManyToOne
	@JoinColumn(name="idesterilizadoproceso")
	public EsterilizadoProceso getEsterilizadoProceso() {
		return this.esterilizadoProceso;
	}

	public void setEsterilizadoProceso(EsterilizadoProceso esterilizadoProceso) {
		this.esterilizadoProceso = esterilizadoProceso;
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
		
	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}
	
	//bi-directional many-to-one association to EsterilizadoProcesoParadaCoche
	@OneToMany(mappedBy="esterilizadoProcesoParada")
	public List<EsterilizadoProcesoParadaCoche> getEsterilizadoProcesoParadaCoches() {
		return this.esterilizadoProcesoParadaCoches;
	}

	public void setEsterilizadoProcesoParadaCoches(List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches) {
		this.esterilizadoProcesoParadaCoches = esterilizadoProcesoParadaCoches;
	}

	public EsterilizadoProcesoParadaCoche addEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().add(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoProcesoParada(this);

		return esterilizadoProcesoParadaCoch;
	}

	public EsterilizadoProcesoParadaCoche removeEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().remove(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoProcesoParada(null);

		return esterilizadoProcesoParadaCoch;
	}

}