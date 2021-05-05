package hu.havasig.alcoholCalendar.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class ChallengeResponse(
	@JsonProperty("id")
	var id: Int,
	@JsonProperty("name")
	var name: String,
	@JsonProperty("description")
	var description: String,
	@JsonProperty("image_url")
	var imageUrl: String? = null,
	@JsonProperty("start_date")
	var startDate: LocalDate,
	@JsonProperty("end_date")
	var endDate: LocalDate,
	@JsonProperty("am_i_applied")
	var amIApplied: Boolean,
	@JsonProperty("is_deleted")
	var isDeleted: Boolean
)