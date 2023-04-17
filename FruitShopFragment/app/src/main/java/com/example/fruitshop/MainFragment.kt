package com.example.fruitshop

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fruitshop.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeFragment = HomeFragment.newInstance()
        val favoriteFragment = FavoriteFragment.newInstance()
        val notificationFragment = NotificationFragment.newInstance()
        val profileFragment = ProfileFragment.newInstance()

        childFragmentManager.beginTransaction().replace(binding.mainFragmentFrame.id, homeFragment).commit()

        binding.bottomTabLayout.addOnTabSelectedListener(object: OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    //remove .addToBackStack("Home")
                    0 -> childFragmentManager.beginTransaction().replace(binding.mainFragmentFrame.id, homeFragment).commit()
                    1 -> childFragmentManager.beginTransaction().replace(binding.mainFragmentFrame.id, favoriteFragment).commit()
                    2 -> childFragmentManager.beginTransaction().replace(binding.mainFragmentFrame.id, notificationFragment).commit()
                    3 -> childFragmentManager.beginTransaction().replace(binding.mainFragmentFrame.id, profileFragment).commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}