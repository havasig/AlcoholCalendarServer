package hu.havasig.alcoholCalendar.model

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.springframework.data.domain.Persistable
import java.util.*
import javax.persistence.*


@Entity(name = "User")
@Table(name = "users")
class User(var name: String = "") {
	@Id
	@Column(
		name = "user_id",
		unique = true,
		nullable = false
	)
	@Type(type = "uuid-char")
	var id: UUID = UUID.randomUUID()

	@OneToMany(
		mappedBy = "user",
		cascade = [CascadeType.ALL]
	)
	var drinks = mutableListOf<Drink>()

	@ManyToMany
	@JoinTable(
		name = "users_challenges",
		joinColumns = [JoinColumn(name = "user_id")],
		inverseJoinColumns = [JoinColumn(name = "challenge_id")]
	)
	var appliedChallenges = mutableListOf<Challenge>()


	@OneToMany(
		mappedBy = "user",
		cascade = [CascadeType.ALL]
	)
	var drinkTypes = mutableListOf<DrinkType>()

	@ManyToMany
	@JoinTable(
		name = "users_roles",
		joinColumns = [JoinColumn(name = "user_id")],
		inverseJoinColumns = [JoinColumn(name = "role_id")]
	)
	var roles = mutableListOf<Role>()
}