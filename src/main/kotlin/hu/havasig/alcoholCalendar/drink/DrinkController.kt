package hu.havasig.alcoholCalendar.drink

import hu.havasig.alcoholCalendar.model.Drink
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drink")
class DrinkController(val drinkService: DrinkService) {
	@PostMapping("")
	fun addDrink(@RequestBody newDrink: Drink, @RequestBody userId: Int) {
		drinkService.addDrink(newDrink, userId)
	}

	@GetMapping("")
	fun getDrinks(@RequestBody userId: Int): List<Drink> {
		return drinkService.getDrinks(userId)
	}

	@PostMapping("/list")
	fun addDrinkList(@RequestBody myDrinks: List<Drink>, @RequestBody userId: Int) {
		drinkService.addDrinkList(myDrinks, userId)
	}
}