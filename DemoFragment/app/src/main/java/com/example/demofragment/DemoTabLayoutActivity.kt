package com.example.demofragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demofragment.databinding.ActivityDemoTabLayoutBinding
import com.example.demofragment.screen.FavoriteFragment
import com.example.demofragment.screen.HomeFragment
import com.example.demofragment.screen.NotificationFragment
import com.example.demofragment.screen.ProfileFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class DemoTabLayoutActivity : AppCompatActivity() {

    lateinit var binding: ActivityDemoTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var fragHome = HomeFragment.newInstance()
        var fragfavo = FavoriteFragment.newInstance()
        var fragNoti = NotificationFragment.newInstance()
        var fragProf = ProfileFragment.newInstance()

        binding.bottomTabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 ->  supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragHome).commit()
                    1 ->  supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragfavo).commit()
                    2 ->  supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragNoti).commit()
                    3 ->  supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragProf).commit()

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragHome).commit()

    }
}