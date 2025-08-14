package com.example.marketorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = generateSampleProducts()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_view_orders -> {
                val intent = Intent(this, OrderHistoryActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun generateSampleProducts(): List<Product> {
        return listOf(
            Product(1, "Orange Juice", "Freshly squeezed orange juice", 2.99),
            Product(2, "Apple Juice", "Crisp and refreshing apple juice", 2.49),
            Product(3, "Cola", "Classic cola flavor", 1.99),
            Product(4, "Lemonade", "Tangy and sweet lemonade", 2.29),
            Product(5, "Grape Juice", "Sweet and delicious grape juice", 3.49),
            Product(6, "Iced Tea", "Refreshing iced tea with lemon", 1.79)
        )
    }
}
