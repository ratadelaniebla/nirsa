package com.nw.util;

import java.util.HashMap;
import java.util.Properties;

import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class MyDestinationDataProvider  implements DestinationDataProvider{

	private HashMap<String, Properties> destinationMap;
	private static MyDestinationDataProvider provider = new MyDestinationDataProvider();

	/**
	 * Privater Konstruktor
	 */
	private MyDestinationDataProvider(){
		if(provider == null){
			destinationMap = new HashMap<String, Properties>();
		}
	}

	/**
	 * Get Singleton
	 * @return
	 */
	public static MyDestinationDataProvider getInstance(){
		return provider;
	}

	@Override
	public Properties getDestinationProperties(String destName) {
        if (destinationMap.containsKey(destName)) {
            return destinationMap.get(destName);
        } else {
            return null;
        }
	}

	@Override
	public void setDestinationDataEventListener(DestinationDataEventListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsEvents() {
		// TODO Auto-generated method stub
		return false;
	}

    public void addDestination(String destinationName, MyDestinationData myDestinationData) {
        Properties properties = new Properties();
        if (MyDestinationData.APPLICATION_SERVER.equals(myDestinationData.getType())) {
            properties.setProperty(DestinationDataProvider.JCO_USER, myDestinationData.getUser());
            properties.setProperty(DestinationDataProvider.JCO_PASSWD, myDestinationData.getPassword());
            properties.setProperty(DestinationDataProvider.JCO_LANG, myDestinationData.getLanguage());
            properties.setProperty(DestinationDataProvider.JCO_ASHOST, myDestinationData.getHost());
            properties.setProperty(DestinationDataProvider.JCO_CLIENT, myDestinationData.getClient());

            properties.setProperty(DestinationDataProvider.JCO_SYSNR, myDestinationData.getSystemNumber());

        } else if (MyDestinationData.MESSAGE_SERVER.equals(myDestinationData.getType())) {
            properties.setProperty(DestinationDataProvider.JCO_USER, myDestinationData.getUser());
            properties.setProperty(DestinationDataProvider.JCO_PASSWD, myDestinationData.getPassword());
            properties.setProperty(DestinationDataProvider.JCO_LANG, myDestinationData.getLanguage());
            properties.setProperty(DestinationDataProvider.JCO_MSHOST, myDestinationData.getHost());
            properties.setProperty(DestinationDataProvider.JCO_CLIENT, myDestinationData.getClient());

            properties.setProperty(DestinationDataProvider.JCO_R3NAME, myDestinationData.getSystemID());
            properties.setProperty(DestinationDataProvider.JCO_GROUP, myDestinationData.getGroupName());
        }
        destinationMap.put(destinationName, properties);
    }
}