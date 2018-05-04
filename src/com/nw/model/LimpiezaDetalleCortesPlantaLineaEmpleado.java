package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limpieza_detalle_cortes_planta_linea_empleados database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_cortes_planta_linea_empleados")
@NamedQuery(name="LimpiezaDetalleCortesPlantaLineaEmpleado.findAll", query="SELECT l FROM LimpiezaDetalleCortesPlantaLineaEmpleado l")
public class LimpiezaDetalleCortesPlantaLineaEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetallecortesplantalineaempleados;
	private Integer corte;
	private Integer numeroEmpleados;
	private LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado;
	private LimpiezaLinea limpiezaLinea;
	private Usuario usuario;

	public LimpiezaDetalleCortesPlantaLineaEmpleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetallecortesplantalineaempleados() {
		return this.idlimpiezadetallecortesplantalineaempleados;
	}

	public void setIdlimpiezadetallecortesplantalineaempleados(Long idlimpiezadetallecortesplantalineaempleados) {
		this.idlimpiezadetallecortesplantalineaempleados = idlimpiezadetallecortesplantalineaempleados;
	}


	public Integer getCorte() {
		return this.corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}


	@Column(name="numero_empleados")
	public Integer getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezacabeceracortesplantalineaempleados")
	public LimpiezaCabeceraCortesPlantaLineaEmpleado getLimpiezaCabeceraCortesPlantaLineaEmpleado() {
		return this.limpiezaCabeceraCortesPlantaLineaEmpleado;
	}

	public void setLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		this.limpiezaCabeceraCortesPlantaLineaEmpleado = limpiezaCabeceraCortesPlantaLineaEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
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