package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.RORIBullish;


public class BullishStocksTradStepDefinition {
	
	@Given("Enter The Application Url for Rise In OI Rise In Price")
	public void enter_the_application_url_for_rise_in_oi_rise_in_price() {
		RORIBullish.urlOfRiseInOIRiseInPrice();
		
		
	}

	@When("Click On Rise In OI Rise In Price for Stocks Data")
	public void click_on_rise_in_oi_rise_in_price_for_stocks_data() throws InterruptedException {
	
		RORIBullish.riseInOiandRiseInPrice();
		
	}


}
