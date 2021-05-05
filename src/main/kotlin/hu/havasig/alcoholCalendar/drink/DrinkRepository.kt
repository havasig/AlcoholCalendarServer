package hu.havasig.alcoholCalendar.drink

import hu.havasig.alcoholCalendar.model.Drink
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinkRepository : CrudRepository<Drink, Int> {

}