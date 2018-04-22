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
public class CajonDetalleBarcoDescarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcajondetallebarcodescarga;

	private Integer estadorevolteo;

	//bi-directional many-to-one association to Banda
	@ManyToOne
	@JoinColumn(name="idbanda")
	private Banda banda;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	//bi-directional many-to-one association to CajonDetalleMuestreo
	@OneToMany(mappedBy="cajonDetalleBarcoDescarga")
	private List<CajonDetalleMuestreo> cajonDetalleMuestreos;

	public CajonDetalleBarcoDescarga() {
	}

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

	public Banda getBanda() {
		return this.banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

	public List<CajonDetalleMuestreo> getCajonDetalleMuestreos() {
		return this.cajonDetalleMuestreos;
	}

	public void setCajonDetalleMuestreos(List<CajonDetalleMuestreo> cajonDetalleMuestreos) {
		this.cajonDetalleMuestreos = cajonDetalleMuestreos;
	}

}