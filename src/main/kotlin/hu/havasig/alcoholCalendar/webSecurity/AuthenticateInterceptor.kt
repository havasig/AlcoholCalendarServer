package hu.havasig.alcoholCalendar.webSecurity

import hu.havasig.alcoholCalendar.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class LoggerInterceptor(private val userService: UserService) : HandlerInterceptor {
	override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
		val userId = request.getHeader("user-id") ?: return false
		val uuidUserId = UUID.fromString(userId)
		val exists = userService.exists(uuidUserId)
		if (!exists) {
			userService.createUser(uuidUserId)
			logger.info("User created with id: $userId")
		}
		return true
	}

	companion object {
		private val logger = LoggerFactory.getLogger(LoggerInterceptor::class.java)
	}
}