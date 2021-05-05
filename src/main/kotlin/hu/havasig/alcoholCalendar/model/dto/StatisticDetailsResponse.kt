package hu.havasig.alcoholCalendar.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class StatisticDetailsResponse(
	@JsonProperty("id")
	val from: LocalDate? = null,
	@JsonProperty("id")
	val to: LocalDate? = null,
	@JsonProperty("drink_types")
	var drinkTypes: MutableList<DrinkTypeResponse> = mutableListOf()
)