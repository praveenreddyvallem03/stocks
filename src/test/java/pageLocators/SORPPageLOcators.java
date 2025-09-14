package pageLocators;

import org.openqa.selenium.By;

public interface SORPPageLOcators {
	
	static String SlideInOiRiseInPicePath="https://www.nseindia.com/market-data/oi-spurts";
	By shortCoveringPath=By.xpath("//option[text()='Slide in OI and Rise in Price']");
	By riseInOIRowsDataPath=By.xpath("//table[@id='oiSpurtsTable']//tbody/tr//following::td[text()='Stock Futures']//parent::tr| //table[@id='oiSpurtsTable']//tbody/tr//following::td[text()='Stock Options']//parent::tr");
	

}
