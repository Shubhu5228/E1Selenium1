package sample;

import java.io.FileInputStream;
import java.util.Properties;

public class DataDrivenFromPropeties {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream(".src\\test\\resources\\TestData\\TestData.Properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty("Url");
		System.out.println(value);  
		
	}

}