package com.example.demofragment.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demofragment.databinding.FragmentFavoriteBinding
import com.example.demofragment.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    companion object {
        fun newInstance(): NotificationFragment {
            return NotificationFragment().apply {
            }
        }
    }

    private var _binding: FragmentNotificationBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}