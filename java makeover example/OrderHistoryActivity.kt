package com.example.marketorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date
import java.util.UUID

class OrderHistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)

        val orders = generateSampleOrders()

        recyclerView = findViewById(R.id.orderHistoryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter(orders)
        recyclerView.adapter = orderAdapter
    }

    private fun generateSampleOrders(): List<Order> {
        val products1 = listOf(
            Product(1, "Orange Juice", "Freshly squeezed orange juice", 2.99),
            Product(3, "Cola", "Classic cola flavor", 1.99)
        )
        val totalPrice1 = products1.sumByDouble { it.price }

        val products2 = listOf(
            Product(2, "Apple Juice", "Crisp and refreshing apple juice", 2.49),
            Product(4, "Lemonade", "Tangy and sweet lemonade", 2.29),
            Product(6, "Iced Tea", "Refreshing iced tea with lemon", 1.79)
        )
        val totalPrice2 = products2.sumByDouble { it.price }


        return listOf(
            Order(UUID.randomUUID().toString(), "John Doe", products1, Date(), totalPrice1),
            Order(UUID.randomUUID().toString(), "Jane Smith", products2, Date(), totalPrice2)
        )
    }
}
