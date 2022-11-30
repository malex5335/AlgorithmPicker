package com.example.algorithmpicker;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.example.algorithmpicker.PickerUtil.*;

@RestController
@SpringBootApplication
public class AlgorithmPickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmPickerApplication.class, args);
	}

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
			return new Gson().toJson(getRandomAlgorithms(category, LocalDate.now(), amount));
		} catch (Exception e) {
			return String.format("{\"error\": \"%s\"}", e).replace("\\", "/");
		}
	}
}
