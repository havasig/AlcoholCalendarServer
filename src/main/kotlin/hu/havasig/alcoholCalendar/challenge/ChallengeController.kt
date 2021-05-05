package hu.havasig.alcoholCalendar.challenge

import hu.havasig.alcoholCalendar.model.Challenge
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/challenge")
class ChallengeController(val challengeService: ChallengeService) {
	@GetMapping("")
	fun getChallenges(@RequestHeader("user-id") userId: UUID): Iterable<Challenge> {
		return challengeService.getChallenges(userId)
	}

	@PostMapping("")
	fun createChallenge(@RequestHeader("user-id") userId: UUID, @RequestBody challenge: Challenge): Challenge? {
		return challengeService.createChallenge(userId, challenge)
	}

	@PutMapping("")
	fun updateChallenge(@RequestHeader("user-id") userId: UUID, @RequestBody challenge: Challenge): Challenge? {
		return challengeService.updateChallenge(userId, challenge)
	}

	@DeleteMapping("/{id}")
	fun deleteChallenge(@RequestHeader("user-id") userId: UUID, @PathVariable("id") challengeId: Int): Boolean {
		return challengeService.deleteChallenge(userId, challengeId)
	}

	@GetMapping("/{id}")
	fun getChallenge(@RequestHeader("user-id") userId: UUID, @PathVariable("id") challengeId: Int): Challenge? {
		return challengeService.getChallenge(userId, challengeId)
	}

	@PostMapping("/{id}/apply")
	fun applyToChallenge(@RequestHeader("user-id") userId: UUID, @PathVariable("id") challengeId: Int): Boolean {
		return challengeService.applyToChallenge(userId, challengeId)
	}
}
