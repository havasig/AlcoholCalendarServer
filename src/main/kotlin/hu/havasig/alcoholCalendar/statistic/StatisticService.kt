package hu.havasig.alcoholCalendar.statistic

import hu.havasig.alcoholCalendar.model.dto.StatisticResponse
import hu.havasig.alcoholCalendar.user.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StatisticService(
	val userRepository: UserRepository
) {
	fun getStatistic(userId: UUID): StatisticResponse? {
		TODO("Not yet implemented")
	}
}