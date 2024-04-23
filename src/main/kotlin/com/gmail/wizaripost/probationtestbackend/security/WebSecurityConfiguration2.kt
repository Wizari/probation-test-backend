//package com.gmail.wizaripost.probationtestbackend.security
//
//import org.keycloak.adapters.KeycloakConfigResolver
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration
////import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
////import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper
//import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
//
//
//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class WebSecurityConfiguration : KeycloakWebSecurityConfigurerAdapter {
//    override fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy {
//        return NullAuthenticatedSessionStrategy()
//    }
//
//    @Autowired
//    fun configureGlobal(authManagerBuilder: AuthenticationManagerBuilder) {
//        val keycloakAuthenticationProvider = keycloakAuthenticationProvider()
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(SimpleAuthorityMapper())
//        authManagerBuilder.authenticationProvider(keycloakAuthenticationProvider)
//    }
//
//    @Bean
//    fun keycloakConfigResolver(): KeycloakConfigResolver {
//        return KeycloakSpringBootConfigResolver()
//    }
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        super.configure(http)
//        http
//            .authorizeRequests()
//            .antMatchers("/api/anonymous/**").permitAll()
//            .anyRequest().fullyAuthenticated()
//    }
//}
//




//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.web.SecurityFilterChain


//@Configuration
//@EnableWebSecurity
//class SecurityConfig {
//
//    @Bean
//    @Throws(Exception::class)
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .authorizeHttpRequests { authorizeRequests ->
//                authorizeRequests
//                    .anyRequest().authenticated()
//            }
//            .oauth2ResourceServer { oauth2ResourceServer ->
//                oauth2ResourceServer
//                    .jwt { }
//            }
//        return http.build();
//    }
//
//
//}