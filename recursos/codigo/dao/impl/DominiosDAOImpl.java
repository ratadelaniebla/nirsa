package com.wm.model.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.wm.model.Dominios;
import com.wm.model.dao.DominiosDAO;

public class DominiosDAOImpl implements DominiosDAO{

	private static final List<Dominios> RECURSOS;
	static {
		List<Dominios> recursos = new ArrayList<Dominios>(3);
		recursos.add(new Dominios(-1, "", ""));
		recursos.add(new Dominios(1, "S1", "Supervisor 1"));
		recursos.add(new Dominios(2, "S2", "Supervisor 2"));
		recursos.add(new Dominios(3, "S4", "Supervisor 4"));
		recursos.add(new Dominios(4, "IA", "Inspector/Ayudante"));
		recursos.add(new Dominios(5, "M", "Montacarguista"));
		recursos.add(new Dominios(6, "O2", "Obrero 2"));
		recursos.add(new Dominios(7, "SD", "Sist Descongelado"));
		recursos.add(new Dominios(7, "SE", "Sist Eviscerado"));
		recursos.add(new Dominios(8, "SC", "Sist Cocción"));
		recursos.add(new Dominios(9, "SN", "Sist Nebulizado"));
		recursos.add(new Dominios(9, "SL", "Sist Limpieza"));
		
		RECURSOS = Collections.unmodifiableList(recursos);
	}

	private static final List<Dominios> COCINAS;
	static {
		List<Dominios> cocinas = new ArrayList<Dominios>(3);
		cocinas.add(new Dominios(-1, "", ""));
		cocinas.add(new Dominios(1, "C1", "Cocina 1"));
		cocinas.add(new Dominios(2, "C2", "Cocina 2"));
		cocinas.add(new Dominios(3, "C3", "Cocina 3"));
		cocinas.add(new Dominios(4, "C4", "Cocina 4"));
		cocinas.add(new Dominios(5, "C5", "Panzero"));

		COCINAS = Collections.unmodifiableList(cocinas);
	}

	
	private static final List<Dominios> COCINADAS;
	static {
		List<Dominios> cocinadas = new ArrayList<Dominios>(3);
		cocinadas.add(new Dominios(-1, "", ""));
		cocinadas.add(new Dominios(1, "C1", "Cocinada 1"));
		cocinadas.add(new Dominios(2, "C2", "Cocinada 2"));
		cocinadas.add(new Dominios(3, "C3", "Cocinada 3"));
		cocinadas.add(new Dominios(4, "C4", "Cocinada 4"));
		cocinadas.add(new Dominios(5, "C5", "Cocinada 5"));
		cocinadas.add(new Dominios(6, "C6", "Cocinada 6"));
		cocinadas.add(new Dominios(7, "C7", "Cocinada 7"));
		cocinadas.add(new Dominios(8, "C8", "Cocinada 8"));
		cocinadas.add(new Dominios(9, "C9", "Cocinada 9"));
		cocinadas.add(new Dominios(10, "C10", "Cocinada 10"));
		cocinadas.add(new Dominios(11, "C11", "Cocinada 11"));
		cocinadas.add(new Dominios(12, "C12", "Cocinada 12"));
		cocinadas.add(new Dominios(13, "C13", "Cocinada 13"));
		cocinadas.add(new Dominios(14, "C14", "Cocinada 14"));
		cocinadas.add(new Dominios(15, "C15", "Cocinada 15"));
		cocinadas.add(new Dominios(16, "C16", "Cocinada 16"));
		cocinadas.add(new Dominios(17, "C17", "Cocinada 17"));
		cocinadas.add(new Dominios(18, "C18", "Cocinada 18"));
		cocinadas.add(new Dominios(19, "C19", "Cocinada 19"));
		cocinadas.add(new Dominios(20, "C20", "Cocinada 20"));
		cocinadas.add(new Dominios(21, "C21", "Cocinada 21"));
		cocinadas.add(new Dominios(22, "C22", "Cocinada 22"));
		cocinadas.add(new Dominios(23, "C23", "Cocinada 23"));
		cocinadas.add(new Dominios(24, "C24", "Cocinada 24"));
		cocinadas.add(new Dominios(25, "C25", "Cocinada 25"));
		cocinadas.add(new Dominios(26, "C26", "Cocinada 26"));
		cocinadas.add(new Dominios(27, "C27", "Cocinada 27"));
		cocinadas.add(new Dominios(28, "C28", "Cocinada 28"));
		cocinadas.add(new Dominios(29, "C29", "Cocinada 29"));
		cocinadas.add(new Dominios(30, "C30", "Cocinada 30"));
		
		COCINADAS = Collections.unmodifiableList(cocinadas);
	}
	
	private static final List<Dominios> MESAS;
	static {
		List<Dominios> mesas = new ArrayList<Dominios>(3);
		mesas.add(new Dominios(-1, "", ""));
		mesas.add(new Dominios(1, "1", "Mesa 1"));
		mesas.add(new Dominios(2, "2", "Mesa 2"));
		mesas.add(new Dominios(3, "3", "Mesa 3"));
		mesas.add(new Dominios(4, "4", "Mesa 4"));
		mesas.add(new Dominios(5, "5", "Mesa 5"));

		MESAS = Collections.unmodifiableList(mesas);
	}

	private static final List<Dominios> FACTOR;
	static {
		List<Dominios> factor = new ArrayList<Dominios>(3);
		factor.add(new Dominios(-1, "", ""));
		factor.add(new Dominios(1, "1", "10"));
		factor.add(new Dominios(2, "2", "7.5"));

		FACTOR = Collections.unmodifiableList(factor);
	}

	
	
	private static final List<Dominios> CAMARAS;
	static {
		List<Dominios> camaras = new ArrayList<Dominios>(3);
		camaras.add(new Dominios(-1, "", ""));
		camaras.add(new Dominios(1, "C1", "Camara 1"));

		CAMARAS = Collections.unmodifiableList(camaras);
	}

	private static final List<Dominios> PROCNEBULIZADO;
	static {
		List<Dominios> camarasneb = new ArrayList<Dominios>(3);
		camarasneb.add(new Dominios(-1, "", ""));
		camarasneb.add(new Dominios(1,  "C1",  "P. Neb. 1"));
		camarasneb.add(new Dominios(2,  "C2",  "P. Neb. 2"));
		camarasneb.add(new Dominios(3,  "C3",  "P. Neb. 3"));
		camarasneb.add(new Dominios(4,  "C4",  "P. Neb. 4"));
		camarasneb.add(new Dominios(5,  "C5",  "P. Neb. 5"));
		camarasneb.add(new Dominios(6,  "C6",  "P. Neb. 6"));
		camarasneb.add(new Dominios(7,  "C7",  "P. Neb. 7"));
		camarasneb.add(new Dominios(8,  "C8",  "P. Neb. 8"));
		camarasneb.add(new Dominios(9,  "C9",  "P. Neb. 9"));
		camarasneb.add(new Dominios(10, "C10", "P. Neb. 10"));
		camarasneb.add(new Dominios(11, "C11", "P. Neb. 11"));
		camarasneb.add(new Dominios(12, "C12", "P. Neb. 12"));
		camarasneb.add(new Dominios(13, "C13", "P. Neb. 13"));
		camarasneb.add(new Dominios(14, "C14", "P. Neb. 14"));
		camarasneb.add(new Dominios(15, "C15", "P. Neb. 15"));

		PROCNEBULIZADO = Collections.unmodifiableList(camarasneb);
	}


	private static final List<Dominios> MATERIALES;
	static {
		List<Dominios> materiales = new ArrayList<Dominios>(3);
		materiales.add(new Dominios(-1, "", ""));
		materiales.add(new Dominios(1,  "LO",  "Lomo"));
		materiales.add(new Dominios(2,  "TR",  "Trozo"));
		materiales.add(new Dominios(3,  "RY",  "Rayado"));
		materiales.add(new Dominios(4,  "PZ",  "Panzas"));
		
		MATERIALES = Collections.unmodifiableList(materiales);
	}

	private static final List<Dominios> LINEASPRODUCCION;
	static {
		List<Dominios> lp = new ArrayList<Dominios>(3);
		lp.add(new Dominios(-1, "", ""));
		lp.add(new Dominios(1,  "A",  "CERRADORA DE 1/2 LIBRA. CONTINENTAL 1"));
		lp.add(new Dominios(2,  "B",  "EMBUTIDORA DE 2 Y 4 LIBRAS"));
		lp.add(new Dominios(3,  "C",  "LINEA 1/4 CLUB"));
		lp.add(new Dominios(4,  "D",  "CERRADORA DE 1/2 LIBRA. CONTINENTAL 2"));
		lp.add(new Dominios(5,  "P",  "LINEA PARA POUCH MULTIVAC(4)"));
		lp.add(new Dominios(6,  "V",  "LINEA ENVASES DE VIDRIO"));
		lp.add(new Dominios(7,  "X",  "LINEA MULTIVAC PRECOCIDO"));
		
		LINEASPRODUCCION = Collections.unmodifiableList(lp);
	}
	
	@Override
	public List<Dominios> getCocinadas() {

		return COCINADAS;
		
	}
	@Override
	public List<Dominios> getCocinas() {

		return COCINAS;

	}
	@Override
	public List<Dominios> getRecursos() {

		return RECURSOS;

	}

	@Override
	public List<Dominios> getMesas() {

		return MESAS;

	}

	@Override
	public List<Dominios> getFactor() {

		return FACTOR;

	}
	
	
	@Override
	public List<Dominios> getCamaras() {

		return CAMARAS;

	}

	@Override
	public List<Dominios> getProcesosNebulizado() {

		return PROCNEBULIZADO;

	}

	@Override
	public List<Dominios> getMateriales() {

		return MATERIALES;

	}

	@Override
	public List<Dominios> getLineasProduccion() {

		return LINEASPRODUCCION;

	}
	@Override
	public Dominios getItemRecursoById(final int item_id) {
		return (Dominios) CollectionUtils.find(RECURSOS, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}

	@Override
	public Dominios getItemCocinaById(final int item_id) {
		return (Dominios) CollectionUtils.find(COCINAS, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}
 
	@Override
	public Dominios getItemCocinadasById(final int item_id) {
		return (Dominios) CollectionUtils.find(COCINADAS, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}

	
	@Override
	public Dominios getItemMesasById(final int item_id) {
		return (Dominios) CollectionUtils.find(MESAS, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}

	@Override
	public Dominios getItemCamaraById(final int item_id) {
		return (Dominios) CollectionUtils.find(CAMARAS, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}

	@Override
	public Dominios getItemProcNebulizadoById(final int item_id) {
		return (Dominios) CollectionUtils.find(PROCNEBULIZADO, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}

	@Override
	public Dominios getMaterialById(final int item_id) {
		return (Dominios) CollectionUtils.find(MATERIALES, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}
	
	@Override
	public Dominios getLineasProduccionById(final int item_id) {
		return (Dominios) CollectionUtils.find(LINEASPRODUCCION, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return item_id == ((Dominios) object).getId();
			}
		});
	}
}
