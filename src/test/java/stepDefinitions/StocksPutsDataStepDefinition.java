package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pageObjects.StocksPuts;

public class StocksPutsDataStepDefinition {
	

@Given("Enter The Application Url for Most Active Stocks Puts")
public void enter_the_application_url_for_most_active_stocks_puts() {
	StocksPuts.urlOfMostActiveStocksPuts();
	
}

@When("Click On Most Active Stocks Puts Data")
public void click_on_most_active_stocks_puts_data() throws InterruptedException {
	StocksPuts.mostActiveStocksPutData();
	
}

}