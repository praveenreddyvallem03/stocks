package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.ChartlinkProject;

public class chartlinkStepDefinition {

@Given("Enter The Application Url of chartlink")
public void enter_the_application_url_of_chartlink() throws InterruptedException {
	ChartlinkProject.stocksActivechartlinkurl();
}

@When("Click On Most Active Futures Data in chartlink")
public void click_on_most_active_futures_data_in_chartlink() throws InterruptedException {
	ChartlinkProject.Chartlinkdata();
}

}
