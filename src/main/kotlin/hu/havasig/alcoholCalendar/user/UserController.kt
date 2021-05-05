package hu.havasig.alcoholCalendar.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(val userService: UserService) {
	@GetMapping("/type-list")
	fun getTypes(@RequestParam userId: Int?): List<String> {
		return userService.getTypes(userId)
	}

	@PostMapping("/add-type")
	fun addType(@RequestBody newType: String, @RequestBody userId: Int) {
		userService.addType(newType, userId)
	}
}