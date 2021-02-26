package com.dhaval.ec.training.HelloWorldJasper;

import java.io.IOException;
import java.net.URISyntaxException;

import net.sf.jasperreports.engine.JRException;

public class HelloWorldController {

	public static void main(String[] args) throws URISyntaxException, JRException, IOException {
		
		HelloWorldService helloWorldService = new HelloWorldService();
		
		String desPath = helloWorldService.startGenerateingPDF();

		System.out.println("PDF is created at path : " + desPath);
		
	}

}
