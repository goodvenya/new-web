package ru.newmcpe.magicstone.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration

@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("*")
        corsConfiguration.allowedMethods = listOf(
            "GET",
            "POST",
            "PUT",
            "DELETE",
            "PUT",
            "OPTIONS",
            "PATCH",
            "DELETE"
        )
        corsConfiguration.allowCredentials = true

        // You can customize the following part based on your project, it's only a sample
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
            .authenticated().and().csrf().disable().cors()
            .configurationSource { corsConfiguration }
    }
}