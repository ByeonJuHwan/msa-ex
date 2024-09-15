package dev.be.userservice.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurity {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/users/**").permitAll()
                    .requestMatchers("/h2-console/**").permitAll()  // H2 콘솔 접근 허용
                    .anyRequest().authenticated()
            }
            .csrf { csrf ->
                csrf.disable()
                csrf.ignoringRequestMatchers("/h2-console/**")  // H2 콘솔에 대해 CSRF 보호 비활성화
            }
            .headers { headers ->
                headers.frameOptions { frameOptions ->
                    frameOptions.sameOrigin()  // X-Frame-Options를 SAMEORIGIN으로 설정
                }
            }

        return http.build()
    }
}