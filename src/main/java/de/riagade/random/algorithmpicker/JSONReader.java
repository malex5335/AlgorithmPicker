package de.riagade.random.algorithmpicker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class JSONReader {
	private static final String ALGORITHMS_JSON = "src/main/resources/algorithms.json";

	public static List<String> getAlgorithmsOf(String category) throws IOException {
		var algorithmsByCategory = getAlgorithmsByCategory();
		if("all".equals(category)) {
			return algorithmsByCategory.values().stream()
					.flatMap(Collection::stream)
					.toList();
		}
		if(!algorithmsByCategory.containsKey(category))
			throw new IllegalArgumentException("Category not found");
		return algorithmsByCategory.get(category);
	}

	private static Map<String, List<String>> getAlgorithmsByCategory() throws IOException {
		var algorithmsJsonString = new String(Files.readAllBytes(Paths.get(ALGORITHMS_JSON)));
		return new Gson().fromJson(algorithmsJsonString, new TypeToken<>() {}.getType());
	}
}
