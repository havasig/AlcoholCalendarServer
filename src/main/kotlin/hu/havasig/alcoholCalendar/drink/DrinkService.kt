package hu.havasig.alcoholCalendar.drink

import hu.havasig.alcoholCalendar.model.Drink
import hu.havasig.alcoholCalendar.user.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class DrinkService(
	val drinkRepository: DrinkRepository,
	val userRepository: UserRepository
) {
	companion object {
		private val logger = LoggerFactory.getLogger(DrinkService::class.java)
	}

	fun createDrink(userId: UUID, drink: Drink): Drink? {
		val owner = userRepository.findById(userId)
		if (owner.isPresent) {
			drink.user = owner.get()
			val result = drinkRepository.save(drink)
			logger.info("User $userId created drink ${result.id}")
			return result
		} else
			logger.error("User $userId not found")
		return null
	}

	fun updateDrink(userId: UUID, drink: Drink): Drink? {
		val drinkObject = drinkRepository.findById(drink.id)
		if (drinkObject.isPresent) {
			if (drinkObject.get().user!!.id == userId) {
				drink.user = userRepository.findById(userId).get()
				val result = drinkRepository.save(drink)
				logger.info("User $userId updated drink ${drink.id}")
				return result
			} else
				logger.error("User $userId is not owner of drink ${drink.id}")
		} else
			logger.error("Drink ${drink.id} not found")
		return null
	}

	fun updateDrinks(userId: UUID, drinks: List<Drink>): List<Drink>? {
		val updater = userRepository.findById(userId)
		val result = mutableListOf<Drink>()
		if (updater.isPresent) {
			drinks.forEach { drink ->
				val drinkObject = drinkRepository.findById(drink.id)
				if (drinkObject.isPresent) {
					if (drinkObject.get().user!!.id == userId) {
						drink.user = updater.get()
						result.add(drinkRepository.save(drink))
						logger.info("User $userId updated drink ${drink.id}")
					} else
						logger.error("User $userId is not owner of drink ${drink.id}")
				} else
					logger.error("Drink ${drink.id} not found")
			}
			return result
		} else
			logger.error("User $userId not found")
		return null
	}

	fun deleteDrink(userId: UUID, drinkId: Int): Boolean {
		val drinkObject = drinkRepository.findById(drinkId)
		val userObject = userRepository.findById(userId)
		if (drinkObject.isPresent) {
			if (userObject.isPresent && userObject.get().id == drinkObject.get().user!!.id) {
				drinkRepository.deleteById(drinkId)
				logger.info("User $userId deleted drink $drinkId")
				return true
			} else
				logger.error("User $userId is not the owner of drink $drinkId")
		} else
			logger.error("Drink $drinkId not found")
		return false
	}
}