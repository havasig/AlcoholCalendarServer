package hu.havasig.alcoholCalendar.security

import hu.havasig.alcoholCalendar.model.Role
import hu.havasig.alcoholCalendar.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : CrudRepository<Role, Int> {
	fun findByName(name: String): Role?
}