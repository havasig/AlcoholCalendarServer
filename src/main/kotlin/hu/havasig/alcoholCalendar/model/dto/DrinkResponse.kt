package hu.havasig.alcoholCalendar.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class DrinkResponse(
	@JsonProperty("id")
	var id: Int,
	@JsonProperty("server_id")
	var serverId: Int? = null,
	@JsonProperty("name")
	var name: String,
	@JsonProperty("percentage")
	var percentage: Int? = null,
	@JsonProperty("amount")
	var amount: Double? = null,
	@JsonProperty("date")
	var date: LocalDate? = null,
	@JsonProperty("last_update")
	var lastUpdate: LocalDate,
	@JsonProperty("is_deleted")
	var isDeleted: Boolean = false
)