package pageLocators;

import org.openqa.selenium.By;

public interface ActiveFutureContractsPageLocators {
	static String mostActiveFutureContractsUrl="https://www.nseindia.com/market-data/most-active-contracts";
	By btnMostActiveFutureContracts=By.xpath("//option[text()='Most Active Future Contracts']");
	By getMostActiveFuturesData=By.xpath("//table[@id=\"MACEquityTable\"]//tbody//tr[1]//following::td[text()='Stock Futures']//parent::tr");

}
