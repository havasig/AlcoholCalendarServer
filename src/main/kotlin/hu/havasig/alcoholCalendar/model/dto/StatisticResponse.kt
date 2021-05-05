package hu.havasig.alcoholCalendar.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

class StatisticResponse(
	@JsonProperty("last_7_days")
	val last7Days: StatisticDetailsResponse? = null,
	@JsonProperty("last_week")
	val lastWeek: StatisticDetailsResponse? = null,
	@JsonProperty("last_month")
	val lastMonth: StatisticDetailsResponse? = null,
	@JsonProperty("last_year")
	val lastYear: StatisticDetailsResponse? = null
)