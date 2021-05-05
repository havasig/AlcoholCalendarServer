package hu.havasig.alcoholCalendar.challenge

import hu.havasig.alcoholCalendar.model.Challenge
import hu.havasig.alcoholCalendar.model.Dictionary
import hu.havasig.alcoholCalendar.user.UserRepository
import hu.havasig.alcoholCalendar.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service("challengeService")
class ChallengeService(
	val challengeRepository: ChallengeRepository,
	val userRepository: UserRepository,
	val userService: UserService
) {
	companion object {
		private val logger = LoggerFactory.getLogger(ChallengeService::class.java)
	}

	//ADMIN
	fun createChallenge(userId: UUID, challenge: Challenge): Challenge? {
		if (userService.hasPrivilege(userId, Dictionary.UpdateChallengePrivilege)) {
			val creator = userRepository.findById(userId)
			if (creator.isPresent) {
				challenge.creator = creator.get()
				val result = challengeRepository.save(challenge)
				logger.info("User $userId created challenge ${result.id}")
				return result
			} else
				logger.error("User $userId not found")
		} else
			logger.error("User $userId has no privilege: ${Dictionary.UpdateChallengePrivilege}")
		return null
	}

	//ADMIN
	fun updateChallenge(userId: UUID, challenge: Challenge): Challenge? {
		if (userService.hasPrivilege(userId, Dictionary.CreateChallengePrivilege)) {
			val updater = userRepository.findById(userId)
			val challengeEntity = challengeRepository.findById(challenge.id)
			if (challengeEntity.isPresent && !challengeEntity.get().isDeleted) {
				challenge.creator = challengeEntity.get().creator
				if (updater.isPresent) {
					val result = challengeRepository.save(challenge)
					logger.info("User $userId updated challenge ${challenge.id}")
					return result
				} else
					logger.error("User $userId not found")
			} else
				logger.error("Challenge ${challenge.id} not found")
		} else
			logger.error("User $userId has no privilege: ${Dictionary.CreateChallengePrivilege}")
		return null
	}

	//ADMIN
	fun deleteChallenge(userId: UUID, challengeId: Int): Boolean {
		if (userService.hasPrivilege(userId, Dictionary.DeleteChallengePrivilege)) {
			val challengeEntity = challengeRepository.findById(challengeId)
			if (challengeEntity.isPresent && !challengeEntity.get().isDeleted) {
				challengeEntity.get().isDeleted = true
				challengeRepository.save(challengeEntity.get())
				logger.info("User $userId deleted challenge $challengeId")
				return true
			} else
				logger.error("User $userId has no privilege: ${Dictionary.DeleteChallengePrivilege}")
		}
		return false
	}

	fun getChallenge(userId: UUID, challengeId: Int): Challenge? {
		val challenge = challengeRepository.findById(challengeId)
		if (challenge.isPresent && !challenge.get().isDeleted) {
			logger.info("User $userId get challenge $challengeId")
			return challenge.get()
		}
		return null
	}

	fun getChallenges(userId: UUID): Iterable<Challenge> {
		logger.info("User $userId get all challenges")
		return challengeRepository.findAll().filter { !it.isDeleted }
	}

	fun applyToChallenge(userId: UUID, challengeId: Int): Boolean {
		val challenge = challengeRepository.findById(challengeId)
		val user = userRepository.findById(userId)
		return if (challenge.isPresent && !challenge.get().isDeleted && user.isPresent) {
			challenge.get().appliedUsers.add(user.get())
			challengeRepository.save(challenge.get())
			logger.info("User $userId applied to challenge $challengeId")
			true
		} else {
			logger.error("User $userId of challenge $challenge not found")
			false
		}
	}
}