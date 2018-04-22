package com.nw.temp.model;

import com.nw.model.RociadoCicloDetalle;
 
public class RociadoCicloDetalleEstado {

	private RociadoCicloDetalle rociadoCicloDetalle; 
	private boolean eliminar;
//	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle; 
//	private EvisceradoDetalleProceso evisceradoDetalleProceso;
//	private RociadoCiclo rociadoCiclo;
	
	
	
	public RociadoCicloDetalleEstado() {
	 
	}

	public RociadoCicloDetalleEstado(RociadoCicloDetalle rociadoCicloDetalle, boolean eliminar) 
	{
	 this.setRociadoCicloDetalle(rociadoCicloDetalle);
	 this.setEliminar(eliminar);
	}

	public RociadoCicloDetalle getRociadoCicloDetalle() {
		return rociadoCicloDetalle;
	}

	public void setRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		this.rociadoCicloDetalle = rociadoCicloDetalle;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	
//	public RociadoCicloDetalleEstado(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle, EvisceradoDetalleProceso evisceradoDetalleProceso, RociadoCiclo rociadoCiclo) 
//	{
//	 this.setCocinaAperturaCierreDetalle(cocinaAperturaCierreDetalle);
//	 this.setEvisceradoDetalleProceso(evisceradoDetalleProceso);
//	 this.setRociadoCiclo(rociadoCiclo);
//	}

//	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
//		return cocinaAperturaCierreDetalle;
//	}
//
//	public void setCocinaAperturaCierreDetalle(
//			CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
//		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
//	}
//
//	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
//		return evisceradoDetalleProceso;
//	}
//
//	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
//		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
//	}
//
//	public RociadoCiclo getRociadoCiclo() {
//		return rociadoCiclo;
//	}
//
//	public void setRociadoCiclo(RociadoCiclo rociadoCiclo) {
//		this.rociadoCiclo = rociadoCiclo;
//	}

}
