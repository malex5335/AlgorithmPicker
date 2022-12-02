package de.riagade.random.algorithmpicker;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class RestAPI {
	@GetMapping(value="/", produces = "application/json")
	@ResponseBody
	public String getAll(@RequestParam(value="amount", defaultValue = "3") int amount) {
		return getAlgorithmsAsJson("all", amount);
	}

	@GetMapping(value= "/{category}/**", produces = "application/json")
	@ResponseBody
	public String getCategory(@PathVariable String category, @RequestParam(value="amount", defaultValue = "3") int amount) {
		return getAlgorithmsAsJson(category, amount);
	}

	public String getAlgorithmsAsJson(String category, int amount) {
		try {
			return new Gson().toJson(RandomPicker.getAlgorithms(category, LocalDate.now(), amount));
		} catch (Exception e) {
			return String.format("{\"error\": \"%s\"}", e).replace("\\", "/");
		}
	}
}
