package com.avante.core.jpa;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;
/**
 * 
 * @author Owner
 */
public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer {

   /**
     * Get a dataSource connection and set it on the session with lookupType=STRING_LOOKUP
     */
    @SuppressWarnings("unused")
	public void customize(Session session) throws Exception {
        JNDIConnector connector = null;
       
        Context context = null;
        try {
            context = new InitialContext();
            if (null == context) {
                throw new Exception("JPAEclipseLinkSessionCustomizer: Context is null");
            }
           connector = (JNDIConnector) session.getLogin().getConnector(); // possible CCE
            // Change from Composite to String_Lookup
            connector.setLookupType(JNDIConnector.STRING_LOOKUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
