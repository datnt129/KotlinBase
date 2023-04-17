package com.example.fruitshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fruitshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val ft = supportFragmentManager.beginTransaction()

        val introFragment = IntroFragment.newInstance(object : IntroFragment.IntroFragmentCallBack {
            override fun onBack() {
                val mainFragment = MainFragment()
                val ft2 = supportFragmentManager.beginTransaction()
                ft2.replace(R.id.main_frame_layout, mainFragment).commit()
            }
        })

        ft.replace(R.id.main_frame_layout, introFragment).commit()
    }
}