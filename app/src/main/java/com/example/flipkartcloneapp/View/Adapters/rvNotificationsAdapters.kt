package com.example.flipkartcloneapp.View.Adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.databinding.RvNotificationsItemsBinding

class rvNotificationsAdapters(
    val notificationsList: List<String>,
    val NotificaitiontimeList: List<String>,
    val NotificationimgList: List<Int>,
    val context: Context
) :
    RecyclerView.Adapter<rvNotificationsAdapters.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            RvNotificationsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val NTitlename = notificationsList[position]
        val ntimeList = NotificaitiontimeList[position]
        val nImgList = NotificationimgList[position]



        holder.tvTiming.text = ntimeList
        holder.name.text = NTitlename


        Glide.with(context)
            .load(nImgList)
            .into(holder.img)


        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Click working", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }

    class ViewHolder(binding: RvNotificationsItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTiming = binding.tvTiming
        val name = binding.tvText
        var img = binding.notificationImg

    }
}