package com.example.demoviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.bottomTabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Product"
                else -> Unit
            }
        }.attach()
    }
}