package hu.havasig.alcoholCalendar.drink

import hu.havasig.alcoholCalendar.model.Drink
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/drink")
class DrinkController(val drinkService: DrinkService) {
	@PostMapping("")
	fun createDrink(@RequestHeader("user-id") userId: UUID, @RequestBody drink: Drink): Drink? {
		return drinkService.createDrink(userId, drink)
	}

	@PutMapping("")
	fun updateDrink(@RequestHeader("user-id") userId: UUID, @RequestBody drink: Drink): Drink? {
		return drinkService.updateDrink(userId, drink)
	}

	@DeleteMapping("/{id}")
	fun deleteDrink(@RequestHeader("user-id") userId: UUID, @PathVariable("id") drinkId: Int): Boolean {
		return drinkService.deleteDrink(userId, drinkId)
	}

	@PutMapping("/list")
	fun updateDrinks(@RequestHeader("user-id") userId: UUID, @RequestBody drinks: List<Drink>): List<Drink>? {
		return drinkService.updateDrinks(userId, drinks)
	}
}