package com.gmail.wizaripost.probationtestbackend.controller

import com.gmail.wizaripost.probationtestbackend.entity.Product
import com.gmail.wizaripost.probationtestbackend.services.ProductsServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Controller {

    @Autowired
    private lateinit var productsServices: ProductsServices

    @GetMapping("/api/products")
    fun getAll(): String {
        val retrievedProducts = productsServices.getAll()
        return "retrievedProducts: $retrievedProducts"
    }

    @GetMapping("/api/products/{id}")
    fun getById(@PathVariable id: Long): String {
        val retrievedProduct = productsServices.getById(id)
        return "retrievedProduct: $retrievedProduct"
    }


    @PostMapping("/api/products")
    fun  createProduct(@RequestBody product: Product): ResponseEntity<String> {
        val newProduct = Product(title = product.title)
        val savedProduct = productsServices.save(newProduct)
        return ResponseEntity.ok("Продукт " + savedProduct + " создан!");
    }

    @PutMapping("/api/products/{id}")
    fun updateProduct(@RequestBody product: Product,@PathVariable id: Long): ResponseEntity<String> {
        val newProduct = Product(title = product.title)
        val savedProduct = productsServices.update(newProduct, id)
        return ResponseEntity.ok("Продукт " + savedProduct + " обновлен!");
    }

    @DeleteMapping("/api/products/{id}")
    fun updateProduct(@PathVariable id: Long): ResponseEntity<String> {
        productsServices.delete(id)
        return ResponseEntity.ok("Продукт удалён!");
    }
}