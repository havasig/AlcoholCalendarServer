package hu.havasig.alcoholCalendar.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "Challenge")
@Table(name = "challenges")
class Challenge(
	var name: String = "",
	var description: String = "",
	var startDate: LocalDate = LocalDate.now(),
	var endDate: LocalDate = LocalDate.now(),
	var isDeleted: Boolean = false,
	var imageUrl: String? = null,
) {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "challenge_id")
	var id: Int = 0

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "creator_id")
	var creator: User? = null


	@ManyToMany
	@JoinTable(
		name = "users_challenges",
		joinColumns = [JoinColumn(name = "challenge_id")],
		inverseJoinColumns = [JoinColumn(name = "user_id")]
	)
	var appliedUsers = mutableListOf<User>()
}