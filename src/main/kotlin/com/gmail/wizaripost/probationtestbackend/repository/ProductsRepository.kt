package com.gmail.wizaripost.probationtestbackend.repository

import com.gmail.wizaripost.probationtestbackend.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository : CrudRepository<Product, Long>