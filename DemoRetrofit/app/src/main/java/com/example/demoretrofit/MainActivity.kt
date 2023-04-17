package com.example.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val albumFragment = AlbumsFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_frame_layout, albumFragment).commit()
    }
}