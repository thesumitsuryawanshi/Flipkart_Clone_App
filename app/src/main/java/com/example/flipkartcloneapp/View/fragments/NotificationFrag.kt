package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.View.Adapters.rvNotificationAdapters
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
            "Your ordered has been dispatched \uD83D\uDCE6",
            "Please verify your order \uD83D\uDCDE",
            "Here is what you will Love \uD83E\uDD70 ",
            "Your ordered has been dispatched \uD83D\uDCE6",
            "Here is what you will Like \uD83D\uDC97 ",
            "Please verify your Number \uD83D\uDCDE.",
            "Your ordered has been dispatched \uD83D\uDCE6",
            "Please verify your E-mail ID."
        )
        val timingList = listOf(
            "9:36 PM",
            "5:26 PM ",
            "1:06 PM",
            "8:36 AM",
            "10:36 AM",
            "2:36 PM",
            "4:20 PM",
            "5:30 PM",
        )

        val adapter = rvNotificationAdapters(NotificaitionList,timingList,  requireContext())

        binding.rvNotification.adapter = adapter
        binding.rvNotification.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

}