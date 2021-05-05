package hu.havasig.alcoholCalendar.model

import javax.persistence.*

@Entity
class Privilege(val name: String = "") {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "privilege_id")
	private val id: Long? = null

	@ManyToMany(mappedBy = "privileges")
	private val roles = mutableListOf<Role>()
}