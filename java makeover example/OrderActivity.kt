package com.example.marketorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Date
import java.util.UUID

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val customerNameEditText = findViewById<EditText>(R.id.customerName)
        val placeOrderButton = findViewById<Button>(R.id.placeOrderButton)

        placeOrderButton.setOnClickListener {
            val customerName = customerNameEditText.text.toString()
            if (customerName.isNotEmpty()) {
                // In a real app, you would have a list of selected products.
                // For this example, we'll just create an order with some sample products.
                val products = listOf(
                    Product(1, "Orange Juice", "Freshly squeezed orange juice", 2.99),
                    Product(2, "Apple Juice", "Crisp and refreshing apple juice", 2.49)
                )
                val totalPrice = products.sumByDouble { it.price }

                val order = Order(
                    id = UUID.randomUUID().toString(),
                    customerName = customerName,
                    products = products,
                    orderDate = Date(),
                    totalPrice = totalPrice
                )

                // In a real app, you would save the order to a database or send it to a server.
                // For now, we'll just show a toast message.
                Toast.makeText(this, "Order placed for ${order.customerName}", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter a customer name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
