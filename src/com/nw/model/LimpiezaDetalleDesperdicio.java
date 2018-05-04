package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_desperdicio database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_desperdicio")
@NamedQuery(name="LimpiezaDetalleDesperdicio.findAll", query="SELECT l FROM LimpiezaDetalleDesperdicio l")
public class LimpiezaDetalleDesperdicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetalledesperdicio;
	private Timestamp fechareg;
	private double peso;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private Subproducto subproducto;
	private Usuario usuario;

	public LimpiezaDetalleDesperdicio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetalledesperdicio() {
		return this.idlimpiezadetalledesperdicio;
	}

	public void setIdlimpiezadetalledesperdicio(Long idlimpiezadetalledesperdicio) {
		this.idlimpiezadetalledesperdicio = idlimpiezadetalledesperdicio;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to Subproducto
	@ManyToOne
	@JoinColumn(name="idsubproducto")
	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
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