package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int retryCount1 = 0;
	private static final int maxRetryCount1 = 5; // retry 3 times

	
	public boolean retry(ITestResult result) {
		if (retryCount1 < maxRetryCount1) {
			retryCount1++;
			System.out.println("Retrying test " + result.getName() + " for the " + retryCount1 + " time(s).");
			return true;
		}
		return false;
}
}
