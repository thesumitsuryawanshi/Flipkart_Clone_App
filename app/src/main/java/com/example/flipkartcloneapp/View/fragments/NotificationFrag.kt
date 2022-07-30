package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Adapters.rvNotificationsAdapters
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
            "Notification1",
            "Notification2",
            "Notification3",
            "Notification4",
            "Notification5",
            "Notification6",
            "Notification7",
            "Notification8"
        )

        val adapter = rvNotificationsAdapters(NotificaitionList)

        binding.rvNotification.adapter = adapter
        binding.rvNotification.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


}