package fr.form.SpringBoot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TriService {
	@GetMapping("/tri/image/search/{year}/{month}/{day}")
	@ResponseBody
	public String tri(@RequestParam(name = "sort", required = false) String sort, @PathVariable int year,
			@PathVariable int month, @PathVariable int day) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
		LocalDate loc = LocalDate.of(year, month, day);

		return "Liste des images du " + loc.format(formatter) + " triées par " + sort;
	}
}
