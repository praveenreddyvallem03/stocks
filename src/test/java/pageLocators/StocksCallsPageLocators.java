package pageLocators;

import org.openqa.selenium.By;

public interface StocksCallsPageLocators {
	
	static String MostActieStocksCalls="https://www.nseindia.com/market-data/most-active-contracts";
	By btnOfMostActiveStockCalls=By.xpath("//option[text()='Most Active Stocks Calls']");
	By getMostActiveStocksData=By.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Options']");
	

}
