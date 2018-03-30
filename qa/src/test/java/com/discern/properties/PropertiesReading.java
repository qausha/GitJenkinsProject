package com.discern.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReading{
	public static final String DRIVER="com.mysql.jdbc.Driver";
	static Properties properties = null; // new Properties();

	public static void main(String arg[]) {

		System.out.println(getValue("Website"));

	}

	static {
		properties = new Properties();

		try {
			InputStream inputStream = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\qa\\src\\test\\java\\com\\discern\\properties\\config.properties");
			
			properties.load(inputStream);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in Static");

	}

	public static String getValue(String a) { // Website
		String value = properties.getProperty(a);
		return value; // baseurl
	}
	}
