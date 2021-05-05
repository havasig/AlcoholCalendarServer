package hu.havasig.alcoholCalendar.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

class DrinkTypeResponse(
	@JsonProperty("id")
	var id: Int,
	@JsonProperty("name")
	var name: String,
	@JsonProperty("percentage")
	var percentage: Int,
	@JsonProperty("amount")
	var amount: Double,
	@JsonProperty("is_deleted")
	var isDeleted: Boolean
)