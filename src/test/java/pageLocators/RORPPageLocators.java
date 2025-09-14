package pageLocators;

import org.openqa.selenium.By;

public interface RORPPageLocators {
	static String riseInOiAndRiseInPricePath="https://www.nseindia.com/market-data/oi-spurts";
	By clickRiseInOiRisePriceBtn=By.xpath("//option[@value='Rise-in-OI-Rise']");
	By getRowsData=By.xpath("//table[@id='oiSpurtsTable']//tbody/tr//following::td[text()='Stock Futures']/parent::tr");
	

}
