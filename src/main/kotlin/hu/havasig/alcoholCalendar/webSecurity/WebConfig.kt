package hu.havasig.alcoholCalendar.webSecurity

import hu.havasig.alcoholCalendar.user.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebMvc
@Configuration
class WebConfig(val userService: UserService) : WebMvcConfigurer {
	override fun addInterceptors(registry: InterceptorRegistry) {
		registry.addInterceptor(LoggerInterceptor(userService))
	}
}