package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produccion_detalle_lote_carryover database table.
 * 
 */
@Entity
@Table(name="produccion_detalle_lote_carryover")
@NamedQuery(name="ProduccionDetalleLoteCarryover.findAll", query="SELECT p FROM ProduccionDetalleLoteCarryover p")
public class ProduccionDetalleLoteCarryover implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproducciondetallelotecarryover;
	private Long idbarcodescarga;
	private Integer idcliente;
	private Integer idespecietalla;
	private Integer idlote;
	private Long idproducciondetallelote;
	private Integer idproducto;
	private Integer itemprograma;
	private Integer pedidocamara;
	private double peso;
	private double rt;
	private Produccion produccion;
	private Turno turno;

	public ProduccionDetalleLoteCarryover() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdproducciondetallelotecarryover() {
		return this.idproducciondetallelotecarryover;
	}

	public void setIdproducciondetallelotecarryover(Long idproducciondetallelotecarryover) {
		this.idproducciondetallelotecarryover = idproducciondetallelotecarryover;
	}


	public Long getIdbarcodescarga() {
		return this.idbarcodescarga;
	}

	public void setIdbarcodescarga(Long idbarcodescarga) {
		this.idbarcodescarga = idbarcodescarga;
	}


	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}


	public Integer getIdespecietalla() {
		return this.idespecietalla;
	}

	public void setIdespecietalla(Integer idespecietalla) {
		this.idespecietalla = idespecietalla;
	}


	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}


	public Long getIdproducciondetallelote() {
		return this.idproducciondetallelote;
	}

	public void setIdproducciondetallelote(Long idproducciondetallelote) {
		this.idproducciondetallelote = idproducciondetallelote;
	}


	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}


	public Integer getItemprograma() {
		return this.itemprograma;
	}

	public void setItemprograma(Integer itemprograma) {
		this.itemprograma = itemprograma;
	}


	public Integer getPedidocamara() {
		return this.pedidocamara;
	}

	public void setPedidocamara(Integer pedidocamara) {
		this.pedidocamara = pedidocamara;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getRt() {
		return this.rt;
	}

	public void setRt(double rt) {
		this.rt = rt;
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


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}