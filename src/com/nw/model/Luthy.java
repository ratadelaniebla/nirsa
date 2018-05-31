package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the luthy database table.
 * 
 */
@Entity
@NamedQuery(name="Luthy.findAll", query="SELECT l FROM Luthy l")
public class Luthy implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idluthy;
	private Integer estado;
	private Integer numeroluthy;
	private List<EnvasadoDetalleProcesoCambiosLuthy> envasadoDetalleProcesoCambiosLuthies;
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;

	public Luthy() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdluthy() {
		return this.idluthy;
	}

	public void setIdluthy(Integer idluthy) {
		this.idluthy = idluthy;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getNumeroluthy() {
		return this.numeroluthy;
	}

	public void setNumeroluthy(Integer numeroluthy) {
		this.numeroluthy = numeroluthy;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambiosLuthy
	@OneToMany(mappedBy="luthy")
	public List<EnvasadoDetalleProcesoCambiosLuthy> getEnvasadoDetalleProcesoCambiosLuthies() {
		return this.envasadoDetalleProcesoCambiosLuthies;
	}

	public void setEnvasadoDetalleProcesoCambiosLuthies(List<EnvasadoDetalleProcesoCambiosLuthy> envasadoDetalleProcesoCambiosLuthies) {
		this.envasadoDetalleProcesoCambiosLuthies = envasadoDetalleProcesoCambiosLuthies;
	}

	public EnvasadoDetalleProcesoCambiosLuthy addEnvasadoDetalleProcesoCambiosLuthy(EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy) {
		getEnvasadoDetalleProcesoCambiosLuthies().add(envasadoDetalleProcesoCambiosLuthy);
		envasadoDetalleProcesoCambiosLuthy.setLuthy(this);

		return envasadoDetalleProcesoCambiosLuthy;
	}

	public EnvasadoDetalleProcesoCambiosLuthy removeEnvasadoDetalleProcesoCambiosLuthy(EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy) {
		getEnvasadoDetalleProcesoCambiosLuthies().remove(envasadoDetalleProcesoCambiosLuthy);
		envasadoDetalleProcesoCambiosLuthy.setLuthy(null);

		return envasadoDetalleProcesoCambiosLuthy;
	}


	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="luthy")
	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public LuthyMaquinaCerradoraEstandar addLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().add(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setLuthy(this);

		return luthyMaquinaCerradoraEstandar;
	}

	public LuthyMaquinaCerradoraEstandar removeLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().remove(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setLuthy(null);

		return luthyMaquinaCerradoraEstandar;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="luthy")
	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public OeeDetalleMediosConDefectoEnvasado addOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().add(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setLuthy(this);

		return oeeDetalleMediosConDefectoEnvasado;
	}

	public OeeDetalleMediosConDefectoEnvasado removeOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().remove(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setLuthy(null);

		return oeeDetalleMediosConDefectoEnvasado;
	}


	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="luthy")
	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora addOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().add(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setLuthy(this);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora removeOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().remove(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setLuthy(null);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}
	
	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
		@OneToMany(mappedBy="luthy")
		public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
			return this.envasadoControlPesoFillCabeceras;
		}

		public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
			this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
		}

		public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
			getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
			envasadoControlPesoFillCabecera.setLuthy(this);

			return envasadoControlPesoFillCabecera;
		}

		public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
			getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
			envasadoControlPesoFillCabecera.setLuthy(null);

			return envasadoControlPesoFillCabecera;
		}


}