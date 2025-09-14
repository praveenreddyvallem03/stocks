package pageObjects;

import java.util.ArrayList;
import java.util.List;

public class TestDataStorage {
	private static List<String> dataList = new ArrayList<>();

	public static void addData(String data) {
		dataList.add(data);
	}

	public static List<String> getData() {
		return dataList;
	}

	public static void clearData() {
		dataList.clear();
	}
}
