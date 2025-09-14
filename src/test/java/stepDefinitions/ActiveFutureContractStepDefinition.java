package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.FutureContracts;


public class ActiveFutureContractStepDefinition extends FutureContracts{

	@Given("Enter The Application Url")
	public void enter_the_application_url() {
		FutureContracts.mostActiveFutureContractUrl();

	}

	@When("Click On Most Active Futures Contract Data")
	public void click_on_most_active_futures_contract_data() throws InterruptedException {
		System.out.println("Inside When Step >>> Calling Data Method");
		FutureContracts.dataOfMostActiveFutureContract();

	}

}
