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
package com.avante.core;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

/**
 * Workspace for the user. One workspace per userSession. <br>
 * <br>
 * Every logged in user have his own workspace. <br>
 * Here are stored several properties for the user. <br>
 * <br>
 * 1. Access the rights that the user have. <br>
 * 2. The office for that the user are logged in. <br>
 * 
 * @author bbruhns
 * @author sgerth
 * 
 */
public class UserWorkspace implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(UserWorkspace.class);

	/*

	static private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
*/
	/**
	 * Get a logged-in users WorkSpace which holds all necessary vars. <br>
	 * 
	 * @return the users WorkSpace
	 * @deprecated Sollte gegen Spring getauscht werden also Konfiguriert und
	 *             nicht über diese Methode!
	@Deprecated
	public static UserWorkspace getInstance() {
		return (UserWorkspace) SpringUtil.getBean("userWorkspace");
	}
	 */


	/**
	 * Default Constructor
	 */
	public UserWorkspace() {
		if (log.isDebugEnabled()) {
			log.debug("create new Workspace [" + this + "]");
		}

		// speed up the ModalDialogs while disabling the animation
		Window.setDefaultActionOnShow("");
	}

	/**
	 * Logout with the spring-security logout action-URL.<br>
	 * Therefore we make a sendRedirect() to the logout uri we <br>
	 * have configured in the spring-config.br>
	 */
	public void doLogout() {
		destroy();

		/* ++++++ Kills the Http session ++++++ */
		// HttpSession s = (HttpSession)
		// Sessions.getCurrent().getNativeSession();
		// s.invalidate();
		/* ++++++ Kills the zk session +++++ */
		// Sessions.getCurrent().invalidate();
		Executions.sendRedirect("/j_spring_logout");

	}


	public void destroy() {

		if (log.isDebugEnabled()) {
			log.debug("destroy Workspace [" + this + "]");
		}
	}

}
