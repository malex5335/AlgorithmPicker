package de.riagade.random.algorithmpicker;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class RandomPicker {

	public static Set<String> getAlgorithms(String category, LocalDate date, int amount) throws IOException {
		var algorithmsOfCategory = JSONReader.getAlgorithmsOf(category);
		var randomOfDay = new Random(date.toEpochDay());
		var maxAmount = Math.min(amount, algorithmsOfCategory.size());
		return pickRandomAlgorithms(maxAmount, algorithmsOfCategory, randomOfDay);
	}

	private static Set<String> pickRandomAlgorithms(int amount, List<String> toChooseFrom, Random random) {
		var randomSelection = new LinkedHashSet<String>();
		var toChooseFromSize = toChooseFrom.size();
		while (randomSelection.size() < amount) {
			var randomIndex = random.nextInt(toChooseFromSize);
			randomSelection.add(toChooseFrom.get(randomIndex));
		}
		return randomSelection;
	}

}
