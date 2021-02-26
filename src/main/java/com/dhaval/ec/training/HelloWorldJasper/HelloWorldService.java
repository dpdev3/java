package com.dhaval.ec.training.HelloWorldJasper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class HelloWorldService {

	public static String destinationPath = "D:/HelloWorldJasper.pdf";
	
	public String startGenerateingPDF() throws URISyntaxException, JRException, IOException {
		
		// jrxml location path
		String jrxmlPath = getJrxmlLocationPath();
		
		// load the jasper design
		JasperDesign jasperDesign = getJasperDesign(jrxmlPath);
		
		// Jasper Compile
		JasperReport jasperReport = compileJasperDesign(jasperDesign);
		
		// parmaterMap
		Map<String, Object> paramterMap = getparameterMap();
		
		// empty Data source
		JRDataSource dataSource = getEmptyDataSource();
		
		// jasper report fill
		JasperPrint jasperPrint = buildReport(jasperReport, paramterMap, dataSource);
		
		String exportedPath = exportReportPdf(jasperPrint);
		
		return exportedPath;
		
	}

	private String exportReportPdf(JasperPrint jasperPrint) throws JRException {
		JasperExportManager.exportReportToPdfFile(jasperPrint, destinationPath);
		return destinationPath;
	}

	private JRDataSource getEmptyDataSource() {
		JRDataSource dataSource = new JREmptyDataSource();
		return dataSource;
	}

	private Map<String, Object> getparameterMap() {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		return parameterMap;
	}

	private JasperPrint buildReport(JasperReport jasperReport, Map<String, Object> paramterMap, JRDataSource dataSource) throws JRException {
		return JasperFillManager.fillReport(jasperReport, paramterMap, dataSource);
	}

	private JasperReport compileJasperDesign(JasperDesign jasperDesign) throws JRException {
		return JasperCompileManager.compileReport(jasperDesign);
	}

	private JasperDesign getJasperDesign(String jrxmlPath) throws JRException, IOException {
		
		InputStream inputStream = new FileInputStream(new File(jrxmlPath));
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		inputStream.close();
		return jasperDesign;
	}

	private String getJrxmlLocationPath() throws URISyntaxException {
		String path = getClass().getClassLoader().getResource("helloWorldJasper.jrxml").toURI().getPath();
		return path;
	}

}
