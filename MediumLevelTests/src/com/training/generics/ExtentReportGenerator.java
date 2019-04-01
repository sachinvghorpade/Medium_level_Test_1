package com.training.generics;



import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportGenerator {
	
	public static ExtentReports generateReport()
	{
	String report_path="./report/report_RETC_Functional_Test.html";
	ExtentReports extentReport;
	extentReport=new ExtentReports(report_path,false);
	return extentReport;
	}
	

}
