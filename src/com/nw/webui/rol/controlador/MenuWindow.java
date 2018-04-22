package com.nw.webui.rol.controlador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.*;
import org.zkoss.zul.*;

import com.avante.core.webui.util.GFCBaseCtrl;
import com.nw.util.AreaMarco;

public class MenuWindow extends GFCBaseCtrl{

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(IndexWindow.class);
	public AreaMarco area;
	protected Window winMenu; // autowired
	public MenuWindow() {
		super();

		if (log.isDebugEnabled()) {
			log.debug("--> super()");
		}
	}
	public void onCreate() throws InterruptedException {
		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		winMenu.setWidth(area.ancho); winMenu.setHeight(area.alto);
		//winMenu.setStyle("color:blue;font-size:18px;font-weight:bold");
	}
}
