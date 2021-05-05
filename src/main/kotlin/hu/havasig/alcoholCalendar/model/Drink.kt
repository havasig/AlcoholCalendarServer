package hu.havasig.alcoholCalendar.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "Drink")
@Table(name = "drinks")
class Drink(
	var name: String = "",
	var percentage: Int? = null,
	var amount: Double? = null,
	var date: LocalDate? = null
) {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	var id: Int = 0

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	var user: User? = null

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "drink_type_id")
	var type: DrinkType? = null
}
