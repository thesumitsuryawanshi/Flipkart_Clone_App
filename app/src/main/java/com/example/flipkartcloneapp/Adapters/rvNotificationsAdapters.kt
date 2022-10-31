package com.example.flipkartcloneapp.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.RvNotificationsItemsBinding

class rvNotificationsAdapters(val notificationsList: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = RvNotificationsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val Cname = notificationsList[position]

    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }

    class ViewHolder(binding: RvNotificationsItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTiming = binding.tvTiming
         val name = binding.tvNotificationText
    }

}