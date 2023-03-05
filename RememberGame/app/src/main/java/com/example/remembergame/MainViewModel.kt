package com.example.remembergame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    var round = MutableLiveData<Int>(1)
    var done = MutableLiveData<Boolean>(false)
    var answerArray: MutableList<Int> = mutableListOf()
    var yourSelectedArray: MutableList<Int> = mutableListOf()

    init {
        round.value = 1
    }

    fun generateNewRound(size: Int): MutableList<Int> {
        var idArray = mutableListOf<Int>()
        repeat(size) {
            idArray.add(Random.nextInt(1, 4))
        }
        return idArray
    }

    fun dosomthing() {

        done.value = true
    }
}