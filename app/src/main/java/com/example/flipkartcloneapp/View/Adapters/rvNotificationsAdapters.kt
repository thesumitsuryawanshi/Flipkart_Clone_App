package com.example.flipkartcloneapp.View.Adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.RvNotificationsItemsBinding

class rvNotificationsAdapters(val notificationsList: List<String>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =
            RvNotificationsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val Cname = notificationsList[position]

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "App working", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }

    class ViewHolder(binding: RvNotificationsItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTiming = binding.tvTiming
         val name = binding.tvNotificationText
    }

}