package com.gmail.wizaripost.probationtestbackend.entity

import jakarta.persistence.*
import org.hibernate.Hibernate

@Table(name = "products")
@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String? = null,
) {
    @Override
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Product

        return id != null && id == other.id
    }

    @Override
    override fun hashCode(): Int = 1756406093

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title )"
    }
}