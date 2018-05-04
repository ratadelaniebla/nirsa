package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cajon_detalle_barco_descarga database table.
 * 
 */
@Entity
@Table(name="cajon_detalle_barco_descarga")
@NamedQuery(name="CajonDetalleBarcoDescarga.findAll", query="SELECT c FROM CajonDetalleBarcoDescarga c")
public class CajonDetalleBarcoDescarga implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcajondetallebarcodescarga;
	private Integer estadorevolteo;
	private Banda banda;
	private BarcoDescarga barcoDescarga;
	private Cajon cajon;
	private EspecieTalla especieTalla;
	private List<CajonDetalleMuestreo> cajonDetalleMuestreos;

	public CajonDetalleBarcoDescarga() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcajondetallebarcodescarga() {
		return this.idcajondetallebarcodescarga;
	}

	public void setIdcajondetallebarcodescarga(Long idcajondetallebarcodescarga) {
		this.idcajondetallebarcodescarga = idcajondetallebarcodescarga;
	}


	public Integer getEstadorevolteo() {
		return this.estadorevolteo;
	}

	public void setEstadorevolteo(Integer estadorevolteo) {
		this.estadorevolteo = estadorevolteo;
	}


	//bi-directional many-to-one association to Banda
	@ManyToOne
	@JoinColumn(name="idbanda")
	public Banda getBanda() {
		return this.banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}


	//bi-directional many-to-one association to CajonDetalleMuestreo
	@OneToMany(mappedBy="cajonDetalleBarcoDescarga")
	public List<CajonDetalleMuestreo> getCajonDetalleMuestreos() {
		return this.cajonDetalleMuestreos;
	}

	public void setCajonDetalleMuestreos(List<CajonDetalleMuestreo> cajonDetalleMuestreos) {
		this.cajonDetalleMuestreos = cajonDetalleMuestreos;
	}

	public CajonDetalleMuestreo addCajonDetalleMuestreo(CajonDetalleMuestreo cajonDetalleMuestreo) {
		getCajonDetalleMuestreos().add(cajonDetalleMuestreo);
		cajonDetalleMuestreo.setCajonDetalleBarcoDescarga(this);

		return cajonDetalleMuestreo;
	}

	public CajonDetalleMuestreo removeCajonDetalleMuestreo(CajonDetalleMuestreo cajonDetalleMuestreo) {
		getCajonDetalleMuestreos().remove(cajonDetalleMuestreo);
		cajonDetalleMuestreo.setCajonDetalleBarcoDescarga(null);

		return cajonDetalleMuestreo;
	}

}