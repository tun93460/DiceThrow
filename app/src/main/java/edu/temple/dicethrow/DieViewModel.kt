package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private var dieSides: Int = 6

    private val dieNumber : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getDieNumber() : LiveData<Int> {
        return dieNumber
    }

    fun setDieNumber(number: Int) {
        dieNumber.value = number
    }

    fun rollDie(){
        setDieNumber(Random.nextInt(dieSides)+1)
    }
}