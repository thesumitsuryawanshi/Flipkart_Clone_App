package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.rvNotificationsAdapters
import com.example.flipkartcloneapp.databinding.FragmentNotificationBinding


class NotificationFrag : Fragment() {

    lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)



        setUpRvNotificaition()
        return binding.root
    }


    private fun setUpRvNotificaition() {

        val NotificaitionList = listOf(
            "Order Placed Successfully ❤️",
            "Comfirmation pending \uD83E\uDD14 \uD83D\uDEEB ",
            "Order \uD83D\uDCE6  Arriving \n at your door\uD83D\uDEAA in 10 min.",
            "Notification4",
            "Notification5",
            "Notification6",
            "Notification7",
            "Notification8",
            "Notification9",
            "Notification10",
        )

        val NotificationimgList = listOf(
            R.drawable.ic_baseline_favorite_24,
            R.drawable.ic_question,
            R.drawable.ic_face,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert
        )

        val NotificaitiontimeList = listOf(
            "⌚ 9:12 am",
            "⌚ 3:02 pm",
            "⌚ 6:12 pm",
            "⌚ 9:01 pm",
            "⌚ 7:12 am",
            "⌚ 9:12 am",
            "⌚ 6:12 pm",
            "⌚ 9:01 pm",
            "⌚ 7:12 am",
            "⌚ 9:12 am"
        )

        val adapter = rvNotificationsAdapters(
            NotificaitionList,
            NotificaitiontimeList,
            NotificationimgList,
            requireContext()
        )

        binding.rvNotoficationBinding.adapter = adapter
        binding.rvNotoficationBinding.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

}