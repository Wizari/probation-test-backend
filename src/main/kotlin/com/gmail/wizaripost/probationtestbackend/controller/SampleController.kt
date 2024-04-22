package com.gmail.wizaripost.probationtestbackend.controller


import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SampleController {

    @GetMapping("/anonymous")
    fun getAnonymousInfo(): String {
        return "Anonymous"
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    fun getUserInfo(): String {
        return "user info"
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    fun getAdminInfo(): String {
        return "admin info"
    }

    @GetMapping("/me")
    fun getMe(): Any {
        println("1231")
        val authentication = SecurityContextHolder.getContext().authentication
        return authentication.name
    }
}



