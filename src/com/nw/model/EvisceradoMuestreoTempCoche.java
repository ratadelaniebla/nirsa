package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the eviscerado_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="eviscerado_muestreo_temp_coche")
@NamedQuery(name="EvisceradoMuestreoTempCoche.findAll", query="SELECT e FROM EvisceradoMuestreoTempCoche e")
public class EvisceradoMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradomuestreotempcoche;
	private Timestamp fechareg;
	private String observacion;
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public EvisceradoMuestreoTempCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradomuestreotempcoche() {
		return this.idevisceradomuestreotempcoche;
	}

	public void setIdevisceradomuestreotempcoche(Long idevisceradomuestreotempcoche) {
		this.idevisceradomuestreotempcoche = idevisceradomuestreotempcoche;
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


	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoMuestreoTempCoche")
	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche addContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().add(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setEvisceradoMuestreoTempCoche(this);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche removeContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().remove(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setEvisceradoMuestreoTempCoche(null);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="evisceradoMuestreoTempCoche")
	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public EvisceradoDetalleMuestreoTempCoche addEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().add(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setEvisceradoMuestreoTempCoche(this);

		return evisceradoDetalleMuestreoTempCoch;
	}

	public EvisceradoDetalleMuestreoTempCoche removeEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().remove(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setEvisceradoMuestreoTempCoche(null);

		return evisceradoDetalleMuestreoTempCoch;
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