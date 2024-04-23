package com.gmail.wizaripost.probationtestbackend.security

import net.minidev.json.JSONArray
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.security.web.SecurityFilterChain
import java.util.stream.Collectors


@Configuration
//@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration {
    @Bean
//    @Throws(Exception::class)
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        val newHttp = http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/anonymous/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2Login { oauth2Login ->
                oauth2Login
                    .userInfoEndpoint { userInfoEndpoint ->
                        userInfoEndpoint
                            .oidcUserService(this.oidcUserService())
                    }
            }
        return newHttp.build();
    }

    @Bean
    fun oidcUserService(): OAuth2UserService<OidcUserRequest, OidcUser> {
        val delegate = OidcUserService()
        return OAuth2UserService { userRequest: OidcUserRequest? ->
            val oidcUser = delegate.loadUser(userRequest)
            val claims = oidcUser.claims
            val groups = claims["groups"] as JSONArray?
            val mappedAuthorities = groups!!.stream()
                .map { role: Any ->
                    SimpleGrantedAuthority(
                        "ROLE_$role"
                    )
                }
                .collect(Collectors.toSet())
            DefaultOidcUser(mappedAuthorities, oidcUser.idToken, oidcUser.userInfo)
        }
    }
}


//@Configuration
//@EnableMethodSecurity(prePostEnabled = true)
//class WebSecurityConfiguration {


//}
//    filterChain


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