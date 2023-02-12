package com.liferay;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @skip",
        plugin = {"pretty", "json:target/cucumber.json"},
        features = {
                "src/test/resources/FormFeatureFile.feature"
        })

public class TestRunner {

}






