package com.gmail.wizaripost.probationtestbackend.security

import net.minidev.json.JSONArray
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import java.util.stream.Collectors


//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//internal class SecurityConfig(val keycloakLogoutHandler: KeycloakLogoutHandler) {
//    private val keycloakLogoutHandler: KeycloakLogoutHandler
////
//    constructor(keycloakLogoutHandler: KeycloakLogoutHandler) {
//        this.keycloakLogoutHandler = keycloakLogoutHandler
//    }

//    @Bean
//    fun sessionRegistry(): SessionRegistry {
//        return SessionRegistryImpl()
//    }
//
//    @Bean
//    protected fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy {
//        return RegisterSessionAuthenticationStrategy(sessionRegistry())
//    }
//
//    @Bean
//    fun httpSessionEventPublisher(): HttpSessionEventPublisher {
//        return HttpSessionEventPublisher()
//    }
//
//    @Bean
//    @Throws(Exception::class)
//    fun resourceServerFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http.authorizeHttpRequests { auth ->
//            auth
//                .requestMatchers(
//                    AntPathRequestMatcher(
//                        "/customers*",
//                        HttpMethod.OPTIONS.name()
//                    )
//                )
//                .permitAll()
//                .requestMatchers(AntPathRequestMatcher("/customers*"))
//                .hasRole("user")
//                .requestMatchers(AntPathRequestMatcher("/"))
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//        }
//        http.oauth2ResourceServer { oauth2 ->
//            oauth2
//                .jwt(Customizer.withDefaults())
//        }
//        http.oauth2Login(Customizer.withDefaults())
//            .logout { logout -> logout.addLogoutHandler(keycloakLogoutHandler).logoutSuccessUrl("/") }
//        return http.build()
//    }
//
//    @Bean
//    fun userAuthoritiesMapperForKeycloak(): GrantedAuthoritiesMapper {
//        return GrantedAuthoritiesMapper { authorities: Collection<GrantedAuthority> ->
//            val mappedAuthorities: MutableSet<GrantedAuthority> = HashSet()
//            val authority = authorities.iterator().next()
//            val isOidc = authority is OidcUserAuthority
//            if (isOidc) {
//                val oidcUserAuthority = authority as OidcUserAuthority
//                val userInfo = oidcUserAuthority.userInfo
//
//                // Tokens can be configured to return roles under
//                // Groups or REALM ACCESS hence have to check both
//                if (userInfo.hasClaim(REALM_ACCESS_CLAIM)) {
//                    val realmAccess =
//                        userInfo.getClaimAsMap(REALM_ACCESS_CLAIM)
//                    val roles =
//                        realmAccess[ROLES_CLAIM] as Collection<String>?
//                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles))
//                } else if (userInfo.hasClaim(GROUPS)) {
//                    val roles =
//                        userInfo.getClaim<Collection<String>>(GROUPS)
//                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles))
//                }
//            } else {
//                val oauth2UserAuthority = authority as OAuth2UserAuthority
//                val userAttributes =
//                    oauth2UserAuthority.attributes
//                if (userAttributes.containsKey(REALM_ACCESS_CLAIM)) {
//                    val realmAccess =
//                        userAttributes[REALM_ACCESS_CLAIM] as Map<String, Any>?
//                    val roles =
//                        realmAccess!![ROLES_CLAIM] as Collection<String>?
//                    mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles))
//                }
//            }
//            mappedAuthorities
//        }
//    }
//
//    fun generateAuthoritiesFromClaim(roles: Collection<String>?): Collection<GrantedAuthority> {
//        return roles!!.stream().map { role: String ->
//            SimpleGrantedAuthority(
//                "ROLE_$role"
//            )
//        }.collect(
//            Collectors.toList()
//        )
//    }
//
//    companion object {
//        private const val GROUPS = "groups"
//        private const val REALM_ACCESS_CLAIM = "realm_access"
//        private const val ROLES_CLAIM = "roles"
//    }


//    @Throws(Exception::class)
//    protected fun configure(http: HttpSecurity) {
//        http
//            .authorizeHttpRequests { authorizeRequests ->
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