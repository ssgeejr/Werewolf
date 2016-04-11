package com.rmc.oss.werewolf;

import java.io.*;
import java.util.Properties;

 public class BlackKnight {

	private String SID = null;
	private String TKN = null;
	private String NUM = null;
	
	
	public BlackKnight() {
		try {
			String SYSTEM_OS = System.getProperty("os.name").toLowerCase().trim();
//			System.out.println("OS: " + SYSTEM_OS);
			java.util.Properties prop = new Properties();
			String path = "~\\.ssh\\twillio.xml";
			//This works for Winblows but might not work for Linux
			if(SYSTEM_OS.startsWith("windows"))
				if (path.startsWith("~" + File.separator)) {
				    path = System.getProperty("user.home") + path.substring(1);
				}
			prop.loadFromXML(new FileInputStream(path));
//			System.out.println(prop.getProperty("sid"));
			SID = prop.getProperty("sid");
			TKN = prop.getProperty("token");
			NUM = prop.getProperty("num");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
//	protected	public
	protected String getSID(){return SID;}
	protected String getToken(){return TKN;}
	protected String getNumber(){return NUM;}

//	public static void main(String args[]) {
//		new BlackKnight();
//	}

}
