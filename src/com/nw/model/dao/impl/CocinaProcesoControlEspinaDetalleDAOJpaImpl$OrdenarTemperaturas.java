package com.nw.model.dao.impl;

//import com.nw.model.CocinaProcesoControlEspina;
import com.nw.model.CocinaProcesoControlEspinaDetalle;
import java.util.Comparator;

class CocinaProcesoControlEspinaDetalleDAOJpaImpl$OrdenarTemperaturas implements
		Comparator<CocinaProcesoControlEspinaDetalle> {
	public int compare(CocinaProcesoControlEspinaDetalle e1,
			CocinaProcesoControlEspinaDetalle e2) {
		if (e2.getCocinaProcesoControlEspina().getNumeroespina().intValue() < e1
				.getCocinaProcesoControlEspina().getNumeroespina().intValue()) {
			return 1;
		}
		return -1;
	}
}