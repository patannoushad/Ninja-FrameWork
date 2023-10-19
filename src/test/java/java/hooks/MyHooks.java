package java.hooks;

import java.factory.DriverFactory;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;


public class MyHooks {

	@Before
	public void setup() {
		DriverFactory.initializeBrowser(ConfigReader.getPropertyValue("browser"));
    	DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));
	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ","_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioName);
		}
		//DriverFactory.getDriver().quit();
	}
}
