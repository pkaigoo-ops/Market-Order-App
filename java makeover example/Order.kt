package com.example.marketorder

import java.util.Date

data class Order(
    val id: String,
    val customerName: String,
    val products: List<Product>,
    val orderDate: Date,
    val totalPrice: Double
)
