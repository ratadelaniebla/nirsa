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
 * The persistent class for the esterilizado_coche database table.
 * 
 */
@Entity
@Table(name="esterilizado_coche")
@NamedQuery(name="EsterilizadoCoche.findAll", query="SELECT e FROM EsterilizadoCoche e")
public class EsterilizadoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idesterilizadocoche;
	private Integer codbarra;
	private Integer estado;
	private Timestamp fechainiciollenado; 
	private Timestamp fechareg;
	private Timestamp horaselladolata;
	private Timestamp fecharegcantidadmuestras;
	private String idusuariomuestras;
	private Integer cantidadmuestras;
	private String observacion;
	private EsterilizadoProceso esterilizadoProceso;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private Turno turno;
	private Usuario usuario;
	private EnvasadoTamanoEnvase envasadoTamanoEnvase;
	private List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches;
	private EsterilizadoTipoCoche esterilizadoTipoCoche;
	private MaquinaCerradora maquinaCerradora;

	public EsterilizadoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdesterilizadocoche() {
		return this.idesterilizadocoche;
	}

	public void setIdesterilizadocoche(Long idesterilizadocoche) {
		this.idesterilizadocoche = idesterilizadocoche;
	}
	
	
	public Integer getCodbarra() {
		return this.codbarra;
	}

	public void setCodbarra(Integer codbarra) {
		this.codbarra = codbarra;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechainiciollenado() {
		return this.fechainiciollenado;
	}

	public void setFechainiciollenado(Timestamp fechainiciollenado) {
		this.fechainiciollenado = fechainiciollenado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	
	public Timestamp getHoraselladolata() {
		return this.horaselladolata;
	}

	public void setHoraselladolata(Timestamp horaselladolata) {
		this.horaselladolata = horaselladolata;
	}
	

	public Timestamp getFecharegcantidadmuestras() {
		return fecharegcantidadmuestras;
	}


	public void setFecharegcantidadmuestras(Timestamp fecharegcantidadmuestras) {
		this.fecharegcantidadmuestras = fecharegcantidadmuestras;
	}


	public String getIdusuariomuestras() {
		return idusuariomuestras;
	}


	public void setIdusuariomuestras(String idusuariomuestras) {
		this.idusuariomuestras = idusuariomuestras;
	}


	public Integer getCantidadmuestras() {
		return cantidadmuestras;
	}


	public void setCantidadmuestras(Integer cantidadmuestras) {
		this.cantidadmuestras = cantidadmuestras;
	}

	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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


	//bi-directional many-to-one association to EnvasadoTamanoEnvase
	@ManyToOne
	@JoinColumn(name="idenvasadotamanoenvase")
	public EnvasadoTamanoEnvase getEnvasadoTamanoEnvase() {
		return this.envasadoTamanoEnvase;
	}

	public void setEnvasadoTamanoEnvase(EnvasadoTamanoEnvase envasadoTamanoEnvase) {
		this.envasadoTamanoEnvase = envasadoTamanoEnvase;
	}
		
		
	//bi-directional many-to-one association to ProduccionDetalleOrden
	@ManyToOne
	@JoinColumn(name="idproducciondetalleorden")
	public ProduccionDetalleOrden getProduccionDetalleOrden() {
		return this.produccionDetalleOrden;
	}

	public void setProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		this.produccionDetalleOrden = produccionDetalleOrden;
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
	

	//bi-directional many-to-one association to EsterilizadoTipoCoche
	@ManyToOne
	@JoinColumn(name="idesterilizadotipocoche")
	public EsterilizadoTipoCoche getEsterilizadoTipoCoche() {
		return this.esterilizadoTipoCoche;
	}

	public void setEsterilizadoTipoCoche(EsterilizadoTipoCoche esterilizadoTipoCoche) {
		this.esterilizadoTipoCoche = esterilizadoTipoCoche;
	}

	
	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}
	

	//bi-directional many-to-one association to EsterilizadoProcesoParadaCoche
	@OneToMany(mappedBy="esterilizadoCoche")
	public List<EsterilizadoProcesoParadaCoche> getEsterilizadoProcesoParadaCoches() {
		return this.esterilizadoProcesoParadaCoches;
	}

	public void setEsterilizadoProcesoParadaCoches(List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches) {
		this.esterilizadoProcesoParadaCoches = esterilizadoProcesoParadaCoches;
	}

	public EsterilizadoProcesoParadaCoche addEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().add(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoCoche(this);

		return esterilizadoProcesoParadaCoch;
	}

	public EsterilizadoProcesoParadaCoche removeEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().remove(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoCoche(null);

		return esterilizadoProcesoParadaCoch;
	}

}