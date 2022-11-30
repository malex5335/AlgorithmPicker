package com.example.algorythmpicker;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class AlgorithmHelper {

	public static Set<String> getRandomAlgorithms(String category, LocalDate date, int amount) throws IOException {
		var selection = new LinkedHashSet<String>();
		var algorithms = getAlgorithms(category);
		var random = new Random(date.toEpochDay());
		for (int i = 0; i < Math.min(amount, algorithms.size()); i++) {
			do {
				selection.add(algorithms.get(random.nextInt(algorithms.size())));
			} while (selection.size() < i + 1);
		}
		return selection;
	}

	private static List<String> getAlgorithms(String category) throws IOException {
		if ("all".equals(category)) {
			return getAlgorithmsByKind().values().stream()
					.flatMap(Collection::stream)
					.toList();
		}
		if(!getAlgorithmsByKind().containsKey(category))
			throw new IllegalArgumentException("Category not found");
		return getAlgorithmsByKind().get(category);
	}

	private static Map<String, List<String>> getAlgorithmsByKind() throws IOException {
		var json = new String(Files.readAllBytes(Paths.get("src/main/resources/algorithms.json")));
		return new Gson().fromJson(json, Map.class);
	}

}
