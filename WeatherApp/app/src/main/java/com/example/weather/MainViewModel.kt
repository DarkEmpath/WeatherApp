package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.adapters.WeatherInformations

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherInformations>()
    val liveDataList = MutableLiveData<List<WeatherInformations>>()


}