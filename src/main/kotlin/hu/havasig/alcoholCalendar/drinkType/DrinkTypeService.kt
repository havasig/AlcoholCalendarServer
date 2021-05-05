package hu.havasig.alcoholCalendar.drinkType

import hu.havasig.alcoholCalendar.model.DrinkType
import org.springframework.stereotype.Service
import java.util.*

@Service
class DrinkTypeService {
	fun getDrinkTypes(userId: UUID): List<DrinkType>? {
		TODO("Not yet implemented")
	}

	fun createDrinkTypes(userId: UUID, drinkType: DrinkType): DrinkType? {
		TODO("Not yet implemented")
	}

	fun updateDrinkTypes(userId: UUID, drinkType: DrinkType): DrinkType? {
		TODO("Not yet implemented")
	}

	fun deleteDrinkTypes(userId: UUID, drinkTypeId: Int): Boolean {
		TODO("Not yet implemented")
	}

	//ADMIN
	fun getDefaultDrinkTypes(userId: UUID): List<DrinkType>? {
		TODO("Not yet implemented")
	}

	//ADMIN
	fun createDefaultDrinkTypes(userId: UUID, drinkType: DrinkType): DrinkType? {
		TODO("Not yet implemented")
	}

	//ADMIN
	fun updateDefaultDrinkTypes(userId: UUID, drinkType: DrinkType): DrinkType? {
		TODO("Not yet implemented")
	}

	//ADMIN
	fun deleteDefaultDrinkTypes(userId: UUID, drinkTypeId: Int): Boolean {
		TODO("Not yet implemented")
	}
}