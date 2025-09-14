package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pageObjects.StocksCalls;

public class StocksCallStepDefiniton {

@Given("Enter The Application Url for Most Active Stocks")
public void enter_the_application_url_for_most_active_stocks() {
	StocksCalls.enterUrlForMostActive();

}

@When("Click On Most Active Stocks Calls Data")
public void click_on_most_active_stocks_calls_data() throws InterruptedException {
	StocksCalls.extarctStocksCallsData();
}




}
