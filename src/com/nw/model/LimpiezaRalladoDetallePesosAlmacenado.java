package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_rallado_detalle_pesos_almacenados database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_detalle_pesos_almacenados")
@NamedQuery(name="LimpiezaRalladoDetallePesosAlmacenado.findAll", query="SELECT l FROM LimpiezaRalladoDetallePesosAlmacenado l")
public class LimpiezaRalladoDetallePesosAlmacenado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaralladodetallepesosalmacenados;
	private Boolean automatico;
	private Timestamp fechareg;
	private double peso;
	private double tara;
	private LimpiezaProceso limpiezaProceso;

	public LimpiezaRalladoDetallePesosAlmacenado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaralladodetallepesosalmacenados() {
		return this.idlimpiezaralladodetallepesosalmacenados;
	}

	public void setIdlimpiezaralladodetallepesosalmacenados(Long idlimpiezaralladodetallepesosalmacenados) {
		this.idlimpiezaralladodetallepesosalmacenados = idlimpiezaralladodetallepesosalmacenados;
	}


	public Boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
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


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

}