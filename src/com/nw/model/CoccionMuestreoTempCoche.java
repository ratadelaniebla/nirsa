package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="coccion_muestreo_temp_coche")
@NamedQuery(name="CoccionMuestreoTempCoche.findAll", query="SELECT c FROM CoccionMuestreoTempCoche c")
public class CoccionMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcoccionmuestreotempcoche;
	private Timestamp fechareg;
	private String observacion;
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;

	public CoccionMuestreoTempCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcoccionmuestreotempcoche() {
		return this.idcoccionmuestreotempcoche;
	}

	public void setIdcoccionmuestreotempcoche(Long idcoccionmuestreotempcoche) {
		this.idcoccionmuestreotempcoche = idcoccionmuestreotempcoche;
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


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="coccionMuestreoTempCoche")
	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public CoccionDetalleMuestreoTempCoche addCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().add(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setCoccionMuestreoTempCoche(this);

		return coccionDetalleMuestreoTempCoch;
	}

	public CoccionDetalleMuestreoTempCoche removeCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().remove(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setCoccionMuestreoTempCoche(null);

		return coccionDetalleMuestreoTempCoch;
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


	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="coccionMuestreoTempCoche")
	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche addContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().add(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setCoccionMuestreoTempCoche(this);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche removeContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().remove(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setCoccionMuestreoTempCoche(null);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}

}