package com.example.demofragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newFragment: DemoFragment = DemoFragment.newInstance("Screen 1", object : DemoFragment.DemoFragmentCallback {
            override fun onBack() {
                supportFragmentManager.popBackStack()
            }

        })
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        ft.add(R.id.frameLayout, newFragment).addToBackStack("Screen_1").commit()

        val newFragment1: DemoFragment = DemoFragment.newInstance("Screen 2", object : DemoFragment.DemoFragmentCallback {
            override fun onBack() {
                supportFragmentManager.popBackStack()
            }

        })
        val ft1: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft1.add(R.id.frameLayout, newFragment1).addToBackStack("Screen_2").commit()

        findViewById<View>(R.id.iv_image).setOnClickListener {
            newFragment1.setScreenName("adakhdgahdjasd")
        }

    }

    fun setName() {
        findViewById<TextView>(R.id.txt_name).text = "asdaad"
    }
}