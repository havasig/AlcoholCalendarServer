package hu.havasig.alcoholCalendar.model

import javax.persistence.*


@Entity
class Role(val name: String = "") {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private val id: Long? = null

	@ManyToMany(mappedBy = "roles")
	private val users = mutableListOf<User>()

	@ManyToMany
	@JoinTable(
		name = "roles_privileges",
		joinColumns = [JoinColumn(name = "role_id")],
		inverseJoinColumns = [JoinColumn(name = "privilege_id")]
	)
	var privileges = mutableListOf<Privilege>()
}