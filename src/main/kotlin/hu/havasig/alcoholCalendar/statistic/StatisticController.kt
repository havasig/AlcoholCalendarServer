package hu.havasig.alcoholCalendar.statistic

import hu.havasig.alcoholCalendar.model.dto.StatisticResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/statistic")
class StatisticController(val statisticService: StatisticService) {
	@GetMapping("")
	fun getStatistic(@RequestHeader("user-id") userId: UUID): StatisticResponse? {
		return statisticService.getStatistic(userId)
	}
}