package hu.havasig.alcoholCalendar.user

import hu.havasig.alcoholCalendar.model.Dictionary
import hu.havasig.alcoholCalendar.model.Privilege
import hu.havasig.alcoholCalendar.model.Role
import hu.havasig.alcoholCalendar.model.User
import hu.havasig.alcoholCalendar.security.RoleRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class UserService(
	val userRepository: UserRepository,
	val roleRepository: RoleRepository
) {
	fun addType(newType: String, userId: Int) {
		TODO("Not yet implemented")
	}

	fun getTypes(userId: Int?): List<String> {
		return mutableListOf("asd", "qwerty", userId.toString())
	}

	fun exists(id: UUID): Boolean {
		return loadUserById(id) != null
	}

	fun hasPrivilege(id: UUID, privilege: String): Boolean {
		val user = loadUserById(id) ?: return false
		val privileges = getPrivileges(user.roles)
		return privileges.contains(privilege)
	}

	private fun loadUserById(id: UUID): User? {
		val optionalUser = userRepository.findById(id)
		return if (optionalUser.isPresent) {
			optionalUser.get()
		} else {
			null
		}
	}

	private fun getPrivileges(roles: Collection<Role>): List<String> {
		val privileges: MutableList<String> = ArrayList()
		val collection: MutableList<Privilege> = ArrayList()
		for (role in roles) {
			collection.addAll(role.privileges)
		}
		for (item in collection) {
			privileges.add(item.name)
		}
		return privileges
	}

	fun createUser(userId: UUID) {
		val user = User()
		val adminRole: Role = roleRepository.findByName(Dictionary.RoleUser)!!
		user.id = userId
		user.roles = mutableListOf(adminRole)
		userRepository.save(user)
	}

	fun createAdmin(userId: UUID) {
		val user = User()
		val adminRole: Role = roleRepository.findByName(Dictionary.RoleAdmin)!!
		user.id = userId
		user.roles = mutableListOf(adminRole)
		userRepository.save(user)
	}
}