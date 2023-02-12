package com.liferay.steps;

import com.liferay.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FormStepdefs {

    public TestContext testContext;
    public WebDriver webDriver;

    public FormStepdefs(TestContext testContext) {
        this.testContext = testContext;
        this.webDriver = testContext.getWebDriver();
    }

    @Given("A user landing on the form page")
    public void aUserLandingOnTheFormPage() {
        webDriver.navigate().to("https://forms.liferay.com/web/forms/shared/-/form/122548");
    }

    @When("the user fills in the {string} input")
    public void theUserFillsInTheFootballPlayerInput(String input) {
    }

    @And("the user clicks on the submit button")
    public void theUserClicksOnTheSubmitButton() {
    }

    @Then("A message showing the following {string} shows up")
    public void aMessageShowingTheFollowingMessageShowsUp(String message) {
    }
}
