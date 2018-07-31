package com.djcps.api.mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MailConfig {
	private static final String MailConfigFile="mailConfig.properties";
	public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static Properties properties;
    static {
    	init();
    }
    private static void init() {

    	properties=new Properties();
    	InputStream inputstream=MailConfig.class.getClassLoader().getResourceAsStream(MailConfigFile);
    	System.out.println(inputstream);
    	try {
    		if(inputstream != null) {
    			properties.load(inputstream);
    		}else {
    			System.out.println("对象为空");
    		}
			
			inputstream.close();
	    	host=properties.getProperty("mailHost");
	    	port = Integer.parseInt(properties.getProperty("mailPort"));
	        userName = properties.getProperty("mailUsername");
	        passWord = properties.getProperty("mailPassword");
	        emailForm = properties.getProperty("mailFrom");
	        timeout = properties.getProperty("mailTimeout");
	        personal = "自动化测试团队";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

   
    }
}
