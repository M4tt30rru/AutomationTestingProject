package com.liferay;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

public class TestContext {

    private WebDriver webDriver;
    private String browserName = "chrome";
    private ScenarioContext scenarioContext;
    private String scenarioName;

    @Before
    public void setUp(Scenario scenario){
      System.out.println("\n\t" + scenario.getName().toUpperCase() + "\n");
      System.setProperty("scenario", scenario.getName());
      scenarioContext = new ScenarioContext();
      scenarioName = scenario.getName();
      webDriver = new ChromeDriver(new ChromeOptions().addArguments("--ignore-certificate-errors"));
      webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    // --- @After commented for debugging purposes --- Please do not remove it!
//    @After
    public void tearDown(Scenario scenario){
       if (webDriver != null) {
          if(scenario.isFailed()) {
              byte[] screenshot = ((TakesScreenshot) webDriver)
                                     .getScreenshotAs(OutputType.BYTES);

              scenario.attach(screenshot, "image/png", "Screenshot");
              LogEntries entry = webDriver.manage().logs().get(LogType.BROWSER);

              // Retrieving all log
              List<LogEntry> logs= entry.getAll();

              // Print one by one
              for(LogEntry e: logs) {
                  System.out.println(e);
              }

              // Printing details separately
              for(LogEntry e: logs) {
                  System.out.println("Message is: " +e.getMessage());
                  System.out.println("Level is: " +e.getLevel());
              }

              String logsString = "";
              for (LogEntry logEntry: logs) {
                  logsString += logs + "\n";
              }

              scenario.attach(logsString,"text/csv","console log");
          }
            webDriver.quit();
        }
       // generateRunWiseReport();
   }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public ScenarioContext getScenarioContext() {
        return this.scenarioContext;
    }
}
