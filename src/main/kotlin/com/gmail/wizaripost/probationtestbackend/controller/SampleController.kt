package com.gmail.wizaripost.probationtestbackend.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class SampleController {
    @get:GetMapping("/anonymous")
    val anonymousInfo: String
        get() = "Anonymous"

    @get:PreAuthorize("hasRole('USER')")
    @get:GetMapping("/user")
    val userInfo: String
        get() = "user info"

    @get:PreAuthorize("hasRole('ADMIN')")
    @get:GetMapping("/admin")
    val adminInfo: String
        get() = "admin info"

    @get:PreAuthorize("hasRole('SERVICE')")
    @get:GetMapping("/service")
    val serviceInfo: String
        get() = "service info"

    @get:GetMapping("/me")
    val me: Any
        get() {
            val authentication: Authentication = SecurityContextHolder.getContext().authentication
            return authentication.getName()
        }
}