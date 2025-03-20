package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel() {

    private val dieNumber : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getDieNumber() : LiveData<Int> {
        return dieNumber
    }

    fun setDieNumber(number: Int) {
        dieNumber.value = number
    }
}