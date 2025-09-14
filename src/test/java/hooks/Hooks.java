package hooks;

import java.util.Map;
import java.util.stream.Collectors;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import pageObjects.TestDataStorage;

public class Hooks {

	@BeforeAll
	public static void beforeAll() {
		TestDataStorage.clearData();
		System.out.println("[MYLOG]"+"🔄 Cleared test data storage before execution.");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("[MYLOG]"+"✅ All Test Data Collected: " + TestDataStorage.getData());
		
		// Convert to frequency map
        Map<String, Long> frequencyMap = TestDataStorage.getData().stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        // Print frequency counts
        System.out.println("[MYLOG] 📊 Frequency Count:");
        frequencyMap.forEach((key, value) -> 
                System.out.println("[MYLOG] " + key + " - " + value));
		
	}
}
