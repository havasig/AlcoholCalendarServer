package hu.havasig.alcoholCalendar.user

import hu.havasig.alcoholCalendar.model.Role
import hu.havasig.alcoholCalendar.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {

}