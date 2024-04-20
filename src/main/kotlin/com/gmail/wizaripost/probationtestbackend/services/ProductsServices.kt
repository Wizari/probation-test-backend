package com.gmail.wizaripost.probationtestbackend.services

import com.gmail.wizaripost.probationtestbackend.entity.Product
import com.gmail.wizaripost.probationtestbackend.repository.ProductsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductsServices {

    @Autowired
    private lateinit var productsRepository: ProductsRepository

    fun getAll(): Iterable<Product> {
        return productsRepository.findAll()
    }

    fun getById(productId: Long): Product? {
        return productsRepository.findById(productId).orElse(null)
    }

    fun save(product: Product): Product {
        return productsRepository.save(product)
    }

    fun update(product: Product, id: Long): Product {
        return if (product.id == id) {
            productsRepository.save(product)
        } else {
            productsRepository.deleteById(id)
            productsRepository.save(product)
        }
    }

    fun delete(id: Long) {
        productsRepository.deleteById(id)
    }


}