package Testrunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Project\\project1.feature",
				glue={"Stepdefinations"},	
				
//					plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","junit:target/JUnitReports/report.xml","json:target/JSONReports/report.json","html:target/HtmlReports/repot.html"},
				monochrome=true,
				dryRun=false
)




public class testrunner {

}
