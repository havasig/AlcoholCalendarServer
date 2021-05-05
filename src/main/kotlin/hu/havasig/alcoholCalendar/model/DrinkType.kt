package hu.havasig.alcoholCalendar.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "DrinkType")
@Table(name = "drink_types")
class DrinkType(
	var name: String = "",
	var percentage: Double? = null,
	var amount: Double? = null
) {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(
		name = "drink_type_id",
		unique = true,
		nullable = false
	)
	var id: Int = 0

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	var user: User? = null
}