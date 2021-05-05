package hu.havasig.alcoholCalendar

import hu.havasig.alcoholCalendar.model.Dictionary
import hu.havasig.alcoholCalendar.model.Privilege
import hu.havasig.alcoholCalendar.model.Role
import hu.havasig.alcoholCalendar.model.User
import hu.havasig.alcoholCalendar.security.PrivilegeRepository
import hu.havasig.alcoholCalendar.security.RoleRepository
import hu.havasig.alcoholCalendar.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Component
class SetupDataLoader : ApplicationListener<ContextRefreshedEvent?> {
	var alreadySetup = false

	@Autowired
	private val userRepository: UserRepository? = null

	@Autowired
	private val roleRepository: RoleRepository? = null

	@Autowired
	private val privilegeRepository: PrivilegeRepository? = null

	@Transactional
	fun createPrivilegeIfNotFound(name: String): Privilege {
		var privilege = privilegeRepository!!.findByName(name)
		if (privilege == null) {
			privilege = Privilege(name)
			privilegeRepository.save(privilege)
		}
		return privilege
	}

	@Transactional
	fun createRoleIfNotFound(
		name: String, privileges: MutableList<Privilege>
	): Role? {
		var role: Role? = roleRepository!!.findByName(name)
		if (role == null) {
			role = Role(name)
			role.privileges = privileges
			roleRepository.save(role)
		}
		return role
	}

	override fun onApplicationEvent(event: ContextRefreshedEvent) {
		if (alreadySetup) return
		val challengeCreatePrivilege = createPrivilegeIfNotFound(Dictionary.CreateChallengePrivilege)
		val challengeUpdatePrivilege = createPrivilegeIfNotFound(Dictionary.UpdateChallengePrivilege)
		val challengeDeletePrivilege = createPrivilegeIfNotFound(Dictionary.DeleteChallengePrivilege)
		val adminPrivileges = mutableListOf(
			challengeCreatePrivilege, challengeUpdatePrivilege, challengeDeletePrivilege
		)
		createRoleIfNotFound(Dictionary.RoleAdmin, adminPrivileges)
		createRoleIfNotFound(Dictionary.RoleUser, mutableListOf())
		val adminRole: Role = roleRepository!!.findByName(Dictionary.RoleAdmin)!!
		val user = User()
		user.id = UUID.fromString("2d04a579-d212-4259-98d6-d6d088091640")
		user.name = "Test"
		user.roles = mutableListOf(adminRole)
		userRepository!!.save(user)
		alreadySetup = true
	}
}