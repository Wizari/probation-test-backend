package com.gmail.wizaripost.probationtestbackend.security


//import net.minidev.json.JSONArray
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.Customizer
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.builders.WebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
//import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer
//import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.UserInfoEndpointConfig
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
//import org.springframework.security.oauth2.core.oidc.user.OidcUser
//import java.util.stream.Collectors
//
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class WebSecurityConfiguration {
//
//    @Throws(Exception::class)
//    protected fun configure(http: HttpSecurity) {
//        http
//            .authorizeHttpRequests{ authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/api/anonymous/**").permitAll()
//                    .anyRequest().authenticated()
//            }
//            .oauth2Login { oauth2Login: OAuth2LoginConfigurer<HttpSecurity?> ->
//                oauth2Login
//                    .userInfoEndpoint(
//                        Customizer { userInfoEndpoint ->
//                            userInfoEndpoint
//                                .oidcUserService(oidcUserService())
//                        }
//                    )
//            }
//    }
//
//    @Bean
//    fun oidcUserService(): OAuth2UserService<OidcUserRequest, OidcUser> {
//        val delegate = OidcUserService()
//        return OAuth2UserService { userRequest: OidcUserRequest? ->
//            val oidcUser = delegate.loadUser(userRequest)
//            val claims = oidcUser.claims
//            val groups = claims["groups"] as JSONArray?
//            val mappedAuthorities = groups!!.stream()
//                .map { role: Any ->
//                    SimpleGrantedAuthority(
//                        "ROLE_$role"
//                    )
//                }
//                .collect(Collectors.toSet())
//            DefaultOidcUser(mappedAuthorities, oidcUser.idToken, oidcUser.userInfo)
//        }
//    }
//}