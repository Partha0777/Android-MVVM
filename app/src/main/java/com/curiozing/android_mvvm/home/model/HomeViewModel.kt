package com.curiozing.android_mvvm.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private var countData = MutableLiveData(0)

    var count:LiveData<Int> = countData

    fun increment(){
        countData.value = countData.value!!.plus(1)
    }

    fun decrement(){
        countData.value = countData.value!!.minus(1)
    }
}