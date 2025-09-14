package pageLocators;

import org.openqa.selenium.By;

public interface StocksPutsPageLocators {
	static String mostActiveStocksPutUrl="https://www.nseindia.com/market-data/most-active-contracts";
	By btnOfMostActiveStocks=By.xpath("//option[text()='Most Active Stocks Puts']");
	By btnOfRowsDataOfMostActive=By.xpath("//table[@id='MACEquityTable']//tbody//tr");

}
