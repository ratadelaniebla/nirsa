package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_detalle_muestreo_temp_coche database table.
 * 
 */
@Entity
@Table(name="coccion_detalle_muestreo_temp_coche")
@NamedQuery(name="CoccionDetalleMuestreoTempCoche.findAll", query="SELECT c FROM CoccionDetalleMuestreoTempCoche c")
public class CoccionDetalleMuestreoTempCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocciondetallemuestreotempcoche;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double peso;
	private double temperatura;
	private String usuarioactualizacion;
	private CoccionMuestreoTempCoche coccionMuestreoTempCoche;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private Turno turno;
	private Usuario usuario;
	private List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics;

	public CoccionDetalleMuestreoTempCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcocciondetallemuestreotempcoche() {
		return this.idcocciondetallemuestreotempcoche;
	}

	public void setIdcocciondetallemuestreotempcoche(Long idcocciondetallemuestreotempcoche) {
		this.idcocciondetallemuestreotempcoche = idcocciondetallemuestreotempcoche;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}


	public Integer getNummuestralote() {
		return this.nummuestralote;
	}

	public void setNummuestralote(Integer nummuestralote) {
		this.nummuestralote = nummuestralote;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@ManyToOne
	@JoinColumn(name="idcoccionmuestreotempcoche")
	public CoccionMuestreoTempCoche getCoccionMuestreoTempCoche() {
		return this.coccionMuestreoTempCoche;
	}

	public void setCoccionMuestreoTempCoche(CoccionMuestreoTempCoche coccionMuestreoTempCoche) {
		this.coccionMuestreoTempCoche = coccionMuestreoTempCoche;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
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


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheAdic
	@OneToMany(mappedBy="coccionDetalleMuestreoTempCoche")
	public List<CoccionDetalleMuestreoTempCocheAdic> getCoccionDetalleMuestreoTempCocheAdics() {
		return this.coccionDetalleMuestreoTempCocheAdics;
	}

	public void setCoccionDetalleMuestreoTempCocheAdics(List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics) {
		this.coccionDetalleMuestreoTempCocheAdics = coccionDetalleMuestreoTempCocheAdics;
	}

	public CoccionDetalleMuestreoTempCocheAdic addCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().add(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setCoccionDetalleMuestreoTempCoche(this);

		return coccionDetalleMuestreoTempCocheAdic;
	}

	public CoccionDetalleMuestreoTempCocheAdic removeCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().remove(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setCoccionDetalleMuestreoTempCoche(null);

		return coccionDetalleMuestreoTempCocheAdic;
	}

}