package com.nw.webui.produccion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.CantidadLibra;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CantidadLibraDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;

@SuppressWarnings("serial")
public class EnvasadoFormatoLatasWindow extends GenericForwardComposer {

	private Listbox lbxListaFormatos;
	private Textbox txtDescripcion;
	private Doublebox InbxPesoGramos;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;

	CantidadLibra cantidadLibra = new CantidadLibra();
	Usuario usuario = new Usuario();
	private List<CantidadLibra> listCantidadLibra;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarFormatos();
		limpiarDatos();
	}

	public void cargarFormatos() {
		listCantidadLibra = new CantidadLibraDAOJpaImpl().getFormatos();
		Util.cargarLista(CantidadLibra.class, listCantidadLibra,
				lbxListaFormatos, null, true, "CantidadLibra");
	}

	public void onSelect$lbxListaFormatos() throws InterruptedException {
		
			if (lbxListaFormatos.getSelectedIndex()== 0) {
				cantidadLibra = new CantidadLibra();
				InbxPesoGramos.setValue(null);
				txtDescripcion.setValue("");
			} 
			if (lbxListaFormatos.getSelectedIndex() > 0) {
				cantidadLibra = (CantidadLibra) lbxListaFormatos.getSelectedItem()
						.getValue();
				InbxPesoGramos.setValue(cantidadLibra.getPesoGramos());
				txtDescripcion.setValue(cantidadLibra.getDescripcion());
			}
	}

	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCampos()) {
			lbxListaFormatos.setSelectedIndex(0);
			if (new CantidadLibraDAOJpaImpl().delete(cantidadLibra))
				Sistema.mensaje("Formato Eliminado");
			else
				Sistema.mensaje("Registro en uso");
			cargarFormatos();
			limpiarDatos();
		}
	}

	/* se corrigio este grabar q no funcionaba */
	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			
			if (txtDescripcion.getValue()== null || txtDescripcion.getValue().equals("")) {
				Sistema.mensaje("Ingrese una descripcion");
				txtDescripcion.setFocus(true);
				return;
			}
			cantidadLibra.setPesoGramos(InbxPesoGramos.getValue());
			cantidadLibra.setDescripcion(txtDescripcion.getValue());
			if (cantidadLibra.getIdcantidadlibras() == null) {
				int idCantidadLibra = 1;
				if (listCantidadLibra.isEmpty()) {
					cantidadLibra.setIdcantidadlibras(idCantidadLibra);
				}else{
					idCantidadLibra = listCantidadLibra.get(
							listCantidadLibra.size() - 1).getIdcantidadlibras() + 1;
					cantidadLibra.setIdcantidadlibras(idCantidadLibra);
				}
				System.out.println("cantidad libras nuevo");
				new CantidadLibraDAOJpaImpl().saveOrUpdateNativo(cantidadLibra);
			}else{
				System.out.println("cantidad libras existente");
				new CantidadLibraDAOJpaImpl().saveOrUpdate(cantidadLibra);
				
			}
			
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			cargarFormatos();
			limpiarDatos();
		}
	}

	void limpiarDatos() {
		ChkEliminar.setChecked(false);
		txtDescripcion.setValue("");
		InbxPesoGramos.setValue(0.0);
		lbxListaFormatos.setSelectedIndex(0);
		cantidadLibra = new CantidadLibra();
	}

	private boolean validarCampos() {
		boolean flag = true;
		/*if (txtDescripcion.getValue().isEmpty()) {
			Sistema.mensaje("Ingrese descripcion");
			txtDescripcion.setFocus(true);
			flag = false;
		}*/
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			flag = false;
		}
		
		/*if (lbxListaFormatos.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione un formato");
			lbxListaFormatos.setFocus(true);
			flag = false;
		} */
		
		if (!InbxPesoGramos.isValid()) {
			Sistema.mensaje("Ingrese un valor correcto");
			InbxPesoGramos.setFocus(true);
			flag = false;
		} else if (InbxPesoGramos.getValue() == 0) {
			Sistema.mensaje("Ingrese un valor correcto");
			InbxPesoGramos.setFocus(true);
			flag = false;
		} else {
			Pattern pat = Pattern
					.compile("^(\\d{1}\\.)?(\\d+\\.?)+(,\\d{2})?$");
			Matcher mat = pat.matcher("" + InbxPesoGramos.getValue());
			if (mat.matches()) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

}
