package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_lote_desperdicio database table.
 * 
 */
@Entity
@Table(name="detalle_lote_desperdicio")
public class DetalleLoteDesperdicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetallelotedesperdicio;

	private String lote;

	//bi-directional many-to-one association to DesperdicioDetalle
	@ManyToOne
	@JoinColumn(name="iddesperdiciodetalle")
	private DesperdicioDetalle desperdicioDetalle;

	public DetalleLoteDesperdicio() {
	}

	public Long getIddetallelotedesperdicio() {
		return this.iddetallelotedesperdicio;
	}

	public void setIddetallelotedesperdicio(Long iddetallelotedesperdicio) {
		this.iddetallelotedesperdicio = iddetallelotedesperdicio;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public DesperdicioDetalle getDesperdicioDetalle() {
		return this.desperdicioDetalle;
	}

	public void setDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		this.desperdicioDetalle = desperdicioDetalle;
	}

}