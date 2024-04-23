package com.gmail.wizaripost.probationtestbackend.controller

import com.gmail.wizaripost.probationtestbackend.entity.Product
import com.gmail.wizaripost.probationtestbackend.services.ProductsServices
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal


@Controller
class WebController {

    @Autowired
    private lateinit var productsServices: ProductsServices
    @GetMapping(path = ["/"])
    fun index(): String {
        return "external"
    }

    @GetMapping("/logout")
    @Throws(Exception::class)
    fun logout(request: HttpServletRequest): String {
        request.logout()
        return "redirect:/"
    }

    @GetMapping(path = ["/customers"])
    fun customers(principal: Principal, model: Model): String {
        addCustomers()
        val customers: Iterable<Product> = productsServices.getAll()
        model.addAttribute("customers", customers)
        model.addAttribute("username", principal.name)
        return "customers"
    }

    // add customers for demonstration
    fun addCustomers() {
//        val customer1 = Customer()
//        customer1.setAddress("1111 foo blvd")
//        customer1.setName("Foo Industries")
//        customer1.setServiceRendered("Important services")
//        customerDAO.save(customer1)
//        val customer2 = Customer()
//        customer2.setAddress("2222 bar street")
//        customer2.setName("Bar LLP")
//        customer2.setServiceRendered("Important services")
//        customerDAO.save(customer2)
//        val customer3 = Customer()
//        customer3.setAddress("33 main street")
//        customer3.setName("Big LLC")
//        customer3.setServiceRendered("Important services")
//        customerDAO.save(customer3)

        val newProduct1 = Product(title = "test1")
        val savedProduct1 = productsServices.save(newProduct1)
        val newProduct2 = Product(title = "test2")
        val savedProduct2 = productsServices.save(newProduct2)
        val newProduct3 = Product(title = "test3")
        val savedProduct3 = productsServices.save(newProduct3)
    }
}