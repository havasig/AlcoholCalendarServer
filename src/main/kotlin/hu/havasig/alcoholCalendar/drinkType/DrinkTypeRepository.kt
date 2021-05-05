package hu.havasig.alcoholCalendar.drinkType

import hu.havasig.alcoholCalendar.model.DrinkType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinkTypeRepository : CrudRepository<DrinkType, Int> {
	fun findByName(name: String): DrinkType?
}