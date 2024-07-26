package com.curiozing.android_mvvm.home.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curiozing.android_mvvm.home.model.CityModel
import com.curiozing.android_mvvm.home.model.ImageProvider

class HomeViewModel : ViewModel() {

    private var data = MutableLiveData<CityModel>()

    var imageData: LiveData<CityModel> = data

    init {
        generateRandomCity()
    }

    private fun generateRandomCity(){
        Handler(Looper.getMainLooper()).postDelayed({
             data.value = ImageProvider.imageList.random()
            generateRandomCity()
        },2000)
    }

}