package com.example.marketorder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class OrderAdapter(private val orderList: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.orderId)
        val customerName: TextView = itemView.findViewById(R.id.customerName)
        val orderDate: TextView = itemView.findViewById(R.id.orderDate)
        val totalPrice: TextView = itemView.findViewById(R.id.totalPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list_item, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.orderId.text = "Order #${currentItem.id.substring(0, 8)}"
        holder.customerName.text = currentItem.customerName
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        holder.orderDate.text = sdf.format(currentItem.orderDate)
        holder.totalPrice.text = "$${"%.2f".format(currentItem.totalPrice)}"
    }

    override fun getItemCount() = orderList.size
}
