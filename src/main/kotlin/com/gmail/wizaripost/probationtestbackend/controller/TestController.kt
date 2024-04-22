package com.gmail.wizaripost.probationtestbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/api")
class TestController {

//    @GetMapping("/me")
//    fun me(): Authentication {
//        return SecurityContextHolder.getContext().authentication
//    }

    @GetMapping("/me")
    fun whoAmI(): Authentication {
        val context: SecurityContext = SecurityContextHolder.getContext()
        return context.getAuthentication()
    }

    @GetMapping("/resource")
    fun administratorReadRes(): ResponseEntity<String> {
        return ResponseEntity.of(Optional.of("Resource for users with fancy access attribute"))
    }
}