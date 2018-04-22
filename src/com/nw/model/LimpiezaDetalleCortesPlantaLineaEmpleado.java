package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limpieza_detalle_cortes_planta_linea_empleados database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_cortes_planta_linea_empleados")
public class LimpiezaDetalleCortesPlantaLineaEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetallecortesplantalineaempleados;

	private Integer corte;

	@Column(name="numero_empleados")
	private Integer numeroEmpleados;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezacabeceracortesplantalineaempleados")
	private LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaDetalleCortesPlantaLineaEmpleado() {
	}

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

	public Integer getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public LimpiezaCabeceraCortesPlantaLineaEmpleado getLimpiezaCabeceraCortesPlantaLineaEmpleado() {
		return this.limpiezaCabeceraCortesPlantaLineaEmpleado;
	}

	public void setLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		this.limpiezaCabeceraCortesPlantaLineaEmpleado = limpiezaCabeceraCortesPlantaLineaEmpleado;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}