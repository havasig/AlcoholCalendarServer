package hu.havasig.alcoholCalendar.security

import hu.havasig.alcoholCalendar.model.Privilege
import hu.havasig.alcoholCalendar.model.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PrivilegeRepository : CrudRepository<Privilege, Int> {
	fun findByName(name: String): Privilege?
}