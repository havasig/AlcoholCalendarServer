package hu.havasig.alcoholCalendar.challenge

import hu.havasig.alcoholCalendar.model.Challenge
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChallengeRepository : CrudRepository<Challenge, Int> {

}