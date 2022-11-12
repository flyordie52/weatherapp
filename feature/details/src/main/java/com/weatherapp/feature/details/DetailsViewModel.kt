package com.weatherapp.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.domain.model.State
import com.weatherapp.domain.model.TodayWeather
import com.weatherapp.domain.model.UpcomingWeather
import com.weatherapp.domain.usecase.CurrentWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailsViewModel(private val useCase: CurrentWeatherUseCase) : ViewModel() {

    private val mState = MutableStateFlow<State<TodayWeather>>(State.Loading())
    val state = mState.asStateFlow()

    fun getCurrentWeather() {
        viewModelScope.launch {
            useCase.currentWeather.collectLatest {
                    mState.value = it
                }
        }
    }
}