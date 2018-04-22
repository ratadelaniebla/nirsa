package com.nw.webui.produccion;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import com.nw.util.EmailUtil;

@SuppressWarnings("serial")
public class EnviarCorreoTestWindow extends GenericForwardComposer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	
	
	
	public void onClick$btnGrabar() throws InterruptedException
	{
		String titulo = "Alerta NW";
		String mensaje = "Mensaje Temperatura";
		new EmailUtil().EnviarCorreo(titulo, mensaje);
	}
	

	
}
