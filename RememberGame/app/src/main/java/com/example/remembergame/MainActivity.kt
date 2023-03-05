package com.example.remembergame

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.remembergame.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.done.observe(this) {
            if (it) {

            }
        }

        binding.txtRed.setOnClickListener {
            doFlash(it)
            viewModel.yourSelectedArray.add(1)
            check()
        }

        binding.txtGreen.setOnClickListener {
            doFlash(it)
            viewModel.yourSelectedArray.add(2)
            check()
        }

        binding.txtBlue.setOnClickListener {
            doFlash(it)
            viewModel.yourSelectedArray.add(3)
            check()
        }

        binding.txtYellow.setOnClickListener {
            doFlash(it)
            viewModel.yourSelectedArray.add(4)
            check()
        }

        binding.txtStart.setOnClickListener {
            binding.txtStart.visibility = View.GONE
            startGame(viewModel.round.value!!)
        }
    }

    private fun doFlash(view: View) {
        view.alpha = 0.5f
        Handler(Looper.getMainLooper()).postDelayed({
            view.alpha = 1f
        }, 100)
    }


    fun updateButtonStatus(status: Boolean) {
        binding.txtRed.isEnabled = status
        binding.txtGreen.isEnabled = status
        binding.txtBlue.isEnabled = status
        binding.txtYellow.isEnabled = status
    }

    fun updateRound(num: Int) {
        viewModel.round.value = num
        binding.txtRoundContent.text = viewModel.round.toString()
    }

    fun check() {
        (0 until viewModel.yourSelectedArray.size).forEach {
            if (viewModel.yourSelectedArray[it] != viewModel.answerArray[it]) {
                updateButtonStatus(false)
                showAlert("You Fail!")
                updateRound(1)
            }
        }
        if (viewModel.yourSelectedArray.size == viewModel.answerArray.size) {
            updateButtonStatus(false)
            showAlert("Next Round")
            updateRound(viewModel.round.value!! + 1)
            binding.txtStart.visibility = View.VISIBLE
        }
    }

    fun startGame(size: Int) {
        Toast.makeText(this, "Generate turn", Toast.LENGTH_SHORT).show()
        updateButtonStatus(false)
        viewModel.answerArray = viewModel.generateNewRound(size)
        GlobalScope.launch {
            viewModel.answerArray.forEach {
                delay(1000)
                withContext(Dispatchers.Main) {
                    when (it) {
                        1 -> doFlash(binding.txtRed)
                        2 -> doFlash(binding.txtGreen)
                        3 -> doFlash(binding.txtBlue)
                        4 -> doFlash(binding.txtYellow)
                    }
                }
            }

            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "Your turn", Toast.LENGTH_SHORT).show()
                updateButtonStatus(true)
                viewModel.yourSelectedArray = mutableListOf()
            }


        }

    }

    fun showAlert(message: String) {
        AlertDialog.Builder(this).setMessage(message).show()
    }

}