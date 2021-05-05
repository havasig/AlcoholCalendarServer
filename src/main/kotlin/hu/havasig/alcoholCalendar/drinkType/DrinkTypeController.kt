package hu.havasig.alcoholCalendar.drinkType

import hu.havasig.alcoholCalendar.model.Drink
import hu.havasig.alcoholCalendar.model.DrinkType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/drink-type")
class DrinkTypeController(val drinkTypeService: DrinkTypeService) {
	@GetMapping("")
	fun getDrinkTypes(@RequestHeader("user-id") userId: UUID): List<DrinkType>? {
		return drinkTypeService.getDrinkTypes(userId)
	}

	@PostMapping("")
	fun createDrinkTypes(@RequestHeader("user-id") userId: UUID, @RequestBody drinkType: DrinkType): DrinkType? {
		return drinkTypeService.createDrinkTypes(userId, drinkType)
	}

	@PutMapping("")
	fun updateDrinkTypes(@RequestHeader("user-id") userId: UUID, @RequestBody drinkType: DrinkType): DrinkType? {
		return drinkTypeService.updateDrinkTypes(userId, drinkType)
	}

	@DeleteMapping("/{id}")
	fun deleteDrinkTypes(@RequestHeader("user-id") userId: UUID, @PathVariable("id") drinkTypeId: Int): Boolean {
		return drinkTypeService.deleteDrinkTypes(userId, drinkTypeId)
	}

	@GetMapping("/default")
	fun getDefaultDrinkTypes(@RequestHeader("user-id") userId: UUID): List<DrinkType>? {
		return drinkTypeService.getDefaultDrinkTypes(userId)
	}

	@PostMapping("/default")
	fun createDefaultDrinkTypes(@RequestHeader("user-id") userId: UUID, @RequestBody drinkType: DrinkType ): DrinkType? {
		return drinkTypeService.createDefaultDrinkTypes(userId, drinkType)
	}

	@PutMapping("/default")
	fun updateDefaultDrinkTypes(@RequestHeader("user-id") userId: UUID, @RequestBody drinkType: DrinkType ): DrinkType? {
		return drinkTypeService.updateDefaultDrinkTypes(userId, drinkType)
	}

	@DeleteMapping("/default/{id}")
	fun deleteDefaultDrinkTypes(@RequestHeader("user-id") userId: UUID, @PathVariable("id") drinkTypeId: Int): Boolean {
		return drinkTypeService.deleteDefaultDrinkTypes(userId, drinkTypeId)
	}
}