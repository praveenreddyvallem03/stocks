package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.SORPBullish;


public class ShortCoveringStocksTradStepDefinitions {

	@Given("Enter The Application Url for Short Covering Stocks")
	public void enter_the_application_url_for_short_covering_stocks() {
		SORPBullish.urlOfShortCoveringStocks();
	}

	@When("Click On Slide In Oi Rise Price Stocks Calls Data")
	public void click_on_slide_in_oi_rise_price_stocks_calls_data() throws InterruptedException {
		SORPBullish.SlideOIRisePrice();
	}

}
