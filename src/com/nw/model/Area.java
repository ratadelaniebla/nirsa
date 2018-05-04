package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idarea;
	private Integer desperdicio;
	private String nombre;
	private Planta planta;
	private Procedencia procedencia;
	private List<AreaProceso> areaProcesos;
	private List<AreaSubproducto> areaSubproductos;
	private List<Balanza> balanzas;
	private List<Cajon> cajons;
	private List<ControlFichaBatch> controlFichaBatches;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<Lugar> lugars;
	private List<LugarDetalle> lugarDetalles;
	private List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas;
	private List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas;
	private List<TurnoGestionDetalle> turnoGestionDetalles;
	private List<Usuario> usuarios;

	public Area() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdarea() {
		return this.idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}


	public Integer getDesperdicio() {
		return this.desperdicio;
	}

	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Planta
	@ManyToOne
	@JoinColumn(name="idplanta")
	public Planta getPlanta() {
		return this.planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}


	//bi-directional many-to-one association to Procedencia
	@ManyToOne
	@JoinColumn(name="idprocedencia")
	public Procedencia getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}


	//bi-directional many-to-one association to AreaProceso
	@OneToMany(mappedBy="area")
	public List<AreaProceso> getAreaProcesos() {
		return this.areaProcesos;
	}

	public void setAreaProcesos(List<AreaProceso> areaProcesos) {
		this.areaProcesos = areaProcesos;
	}

	public AreaProceso addAreaProceso(AreaProceso areaProceso) {
		getAreaProcesos().add(areaProceso);
		areaProceso.setArea(this);

		return areaProceso;
	}

	public AreaProceso removeAreaProceso(AreaProceso areaProceso) {
		getAreaProcesos().remove(areaProceso);
		areaProceso.setArea(null);

		return areaProceso;
	}


	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="area")
	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
	}

	public AreaSubproducto addAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().add(areaSubproducto);
		areaSubproducto.setArea(this);

		return areaSubproducto;
	}

	public AreaSubproducto removeAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().remove(areaSubproducto);
		areaSubproducto.setArea(null);

		return areaSubproducto;
	}


	//bi-directional many-to-one association to Balanza
	@OneToMany(mappedBy="area")
	public List<Balanza> getBalanzas() {
		return this.balanzas;
	}

	public void setBalanzas(List<Balanza> balanzas) {
		this.balanzas = balanzas;
	}

	public Balanza addBalanza(Balanza balanza) {
		getBalanzas().add(balanza);
		balanza.setArea(this);

		return balanza;
	}

	public Balanza removeBalanza(Balanza balanza) {
		getBalanzas().remove(balanza);
		balanza.setArea(null);

		return balanza;
	}


	//bi-directional many-to-one association to Cajon
	@OneToMany(mappedBy="area")
	public List<Cajon> getCajons() {
		return this.cajons;
	}

	public void setCajons(List<Cajon> cajons) {
		this.cajons = cajons;
	}

	public Cajon addCajon(Cajon cajon) {
		getCajons().add(cajon);
		cajon.setArea(this);

		return cajon;
	}

	public Cajon removeCajon(Cajon cajon) {
		getCajons().remove(cajon);
		cajon.setArea(null);

		return cajon;
	}


	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="area")
	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public ControlFichaBatch addControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().add(controlFichaBatch);
		controlFichaBatch.setArea(this);

		return controlFichaBatch;
	}

	public ControlFichaBatch removeControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().remove(controlFichaBatch);
		controlFichaBatch.setArea(null);

		return controlFichaBatch;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="area")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().add(desperdicioCajonHarina);
		desperdicioCajonHarina.setArea(this);

		return desperdicioCajonHarina;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().remove(desperdicioCajonHarina);
		desperdicioCajonHarina.setArea(null);

		return desperdicioCajonHarina;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="area")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setArea(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setArea(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="area")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setArea(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setArea(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to Lugar
	@OneToMany(mappedBy="area")
	public List<Lugar> getLugars() {
		return this.lugars;
	}

	public void setLugars(List<Lugar> lugars) {
		this.lugars = lugars;
	}

	public Lugar addLugar(Lugar lugar) {
		getLugars().add(lugar);
		lugar.setArea(this);

		return lugar;
	}

	public Lugar removeLugar(Lugar lugar) {
		getLugars().remove(lugar);
		lugar.setArea(null);

		return lugar;
	}


	//bi-directional many-to-one association to LugarDetalle
	@OneToMany(mappedBy="area")
	public List<LugarDetalle> getLugarDetalles() {
		return this.lugarDetalles;
	}

	public void setLugarDetalles(List<LugarDetalle> lugarDetalles) {
		this.lugarDetalles = lugarDetalles;
	}

	public LugarDetalle addLugarDetalle(LugarDetalle lugarDetalle) {
		getLugarDetalles().add(lugarDetalle);
		lugarDetalle.setArea(this);

		return lugarDetalle;
	}

	public LugarDetalle removeLugarDetalle(LugarDetalle lugarDetalle) {
		getLugarDetalles().remove(lugarDetalle);
		lugarDetalle.setArea(null);

		return lugarDetalle;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLimpieza
	@OneToMany(mappedBy="area")
	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoLimpiezas() {
		return this.oeeDetalleMediosConDefectoLimpiezas;
	}

	public void setOeeDetalleMediosConDefectoLimpiezas(List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas) {
		this.oeeDetalleMediosConDefectoLimpiezas = oeeDetalleMediosConDefectoLimpiezas;
	}

	public OeeDetalleMediosConDefectoLimpieza addOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().add(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setArea(this);

		return oeeDetalleMediosConDefectoLimpieza;
	}

	public OeeDetalleMediosConDefectoLimpieza removeOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().remove(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setArea(null);

		return oeeDetalleMediosConDefectoLimpieza;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLonja
	@OneToMany(mappedBy="area")
	public List<OeeDetalleMediosConDefectoLonja> getOeeDetalleMediosConDefectoLonjas() {
		return this.oeeDetalleMediosConDefectoLonjas;
	}

	public void setOeeDetalleMediosConDefectoLonjas(List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas) {
		this.oeeDetalleMediosConDefectoLonjas = oeeDetalleMediosConDefectoLonjas;
	}

	public OeeDetalleMediosConDefectoLonja addOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().add(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setArea(this);

		return oeeDetalleMediosConDefectoLonja;
	}

	public OeeDetalleMediosConDefectoLonja removeOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().remove(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setArea(null);

		return oeeDetalleMediosConDefectoLonja;
	}


	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="area")
	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

	public TurnoGestionDetalle addTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().add(turnoGestionDetalle);
		turnoGestionDetalle.setArea(this);

		return turnoGestionDetalle;
	}

	public TurnoGestionDetalle removeTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().remove(turnoGestionDetalle);
		turnoGestionDetalle.setArea(null);

		return turnoGestionDetalle;
	}


	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="area")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setArea(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setArea(null);

		return usuario;
	}

}