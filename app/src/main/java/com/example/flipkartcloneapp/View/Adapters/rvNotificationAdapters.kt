package com.example.flipkartcloneapp.View.Adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.RvNotificationsItemsBinding

class rvNotificationAdapters(val notificationsList: List<String>, val timingList: List<String>, val context: Context) :
    RecyclerView.Adapter<rvNotificationAdapters.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {

        val view = RvNotificationsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = NotificationViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notificationsList[position]
        val timing = timingList[position]

        holder.name.text = notification
        holder.tvTiming.text = timing

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "End of the thread.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int { return notificationsList.size }

    class NotificationViewHolder(binding: RvNotificationsItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        var tvTiming = binding.tvTiming
         var name = binding.tvNotificationText
    }

}