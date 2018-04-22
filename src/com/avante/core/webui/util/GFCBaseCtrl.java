/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package com.avante.core.webui.util;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.zkoss.zk.ui.event.CreateEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Window;

import com.avante.core.UserWorkspace;

/**
 * Base controller for creating the controllers of the zul files with the spring
 * framework.
 * 
 * @author bbruhns
 * @author sgerth
 */
abstract public class GFCBaseCtrl extends GenericForwardComposer implements Serializable {

	private static final long serialVersionUID = -1171206258809472640L;
	@SuppressWarnings("unused")
	private transient static final Log log = LogFactory.getLog(GFCBaseCtrl.class);
	
	protected transient AnnotateDataBinder binder;

	protected transient Map<String, Object> args;

	/**
	 * Get the params map that are overhanded at creation time. <br>
	 * Reading the params that are binded to the createEvent.<br>
	 * 
	 * @param event
	 * @return params map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCreationArgsMap(Event event) {
		CreateEvent ce = (CreateEvent) ((ForwardEvent) event).getOrigin();
		return ce.getArg();
	}

	public void doSetComposerName(Window w) throws Exception {
		w.setVariable("controller", this, false); // make models visible for the
													// databinder
//		binder = new AnnotateDataBinder(w);
//		binder.loadAll();
	}

	public void doOnCreateCommon(Window w) throws Exception {
		binder = new AnnotateDataBinder(w);
		binder.loadAll();
	}

	@SuppressWarnings("unchecked")
	public void doOnCreateCommon(Window w, Event fe) throws Exception {
		doOnCreateCommon(w);
		CreateEvent ce = (CreateEvent) ((ForwardEvent) fe).getOrigin();
		args = ce.getArg();
	}

	private transient UserWorkspace userWorkspace;

	final protected UserWorkspace getUserWorkspace() {
		return userWorkspace;
	}

	public void setUserWorkspace(UserWorkspace userWorkspace) {
		this.userWorkspace = userWorkspace;
	}
	
	//private Toolbarbutton btnEnviar;
	//private Toolbarbutton btnLimpiar;

    public void onClick$btnEnviar(Event event) { 

    }

    public void onClick$btnLimpiar(Event event) { 

    }
    
}

