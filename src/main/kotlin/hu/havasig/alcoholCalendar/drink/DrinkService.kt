package hu.havasig.alcoholCalendar.drink

import hu.havasig.alcoholCalendar.model.Drink
import org.springframework.stereotype.Service

@Service
class DrinkService {
	fun addDrink(newDrink: Drink, userId: Int) {
		TODO("DrinkService addDrink not implemented. Add drink to user's drink list")
	}

	fun getDrinks(userId: Int): List<Drink> {
		TODO("DrinkService getDrinks not implemented. Return user's drink list")
	}

	fun addDrinkList(myDrinks: List<Drink>, userId: Int) {
		TODO("DrinkService addDrinkList not yet implemented")
	}
}