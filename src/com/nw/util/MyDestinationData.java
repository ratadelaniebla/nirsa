package com.nw.util;

public class MyDestinationData {
 
    public static final String APPLICATION_SERVER = "APPLICATION_SERVER";
    public static final String MESSAGE_SERVER = "MESSAGE_SERVER";
 
	private String type;
    private String client;
    private String user;
    private String password;
    private String language;
    private String host;
    private String systemNumber;
    private String systemID;
    private String groupName;
 
    public String getType() {
        return type;
    }
 
    public String getClient() {
        return client;
    }
 
    public String getUser() {
        return user;
    }
 
    public String getPassword() {
        return password;
    }
 
    public String getLanguage() {
        return language;
    }
 
    public String getHost() {
        return host;
    }
 
    public String getSystemNumber() {
        return systemNumber;
    }
 
    public String getSystemID() {
        return systemID;
    }
 
    public String getGroupName() {
        return groupName;
    }
 
    public MyDestinationData(String client, String user, String password, String language, String host, String systemNumber) {
        this.client = client;
        this.user = user;
        this.password = password;
        this.language = language;
        this.host = host;
        this.systemNumber = systemNumber;
        this.type = APPLICATION_SERVER;
    }
 
    public MyDestinationData(String client, String user, String password, String language, String host, String systemID,
            String groupName) {
        this.client = client;
        this.user = user;
        this.password = password;
        this.language = language;
        this.host = host;
        this.systemID = systemID;
        this.groupName = groupName;
        this.type = MESSAGE_SERVER;
    }
}