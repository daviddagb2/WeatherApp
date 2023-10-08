package com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.mainscreen

import com.gonzalez.blanchard.domain.base.models.inputs.CurrentWeatherInput
import com.gonzalez.blanchard.domain.base.usecases.GetCurrentWeatherUseCase
import com.gonzalez.blanchard.wheaterapp.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : BaseViewModel() {

    private val _status = Channel<MainScreenStatus>()
    val status = _status.receiveAsFlow()

    private val _action = Channel<MainScreenActions>()
    val action = _action.receiveAsFlow()
    
    init {
    }

    fun viewCreated() {
        executeUseCase(action = {
            _status.send(MainScreenStatus.Loading)
            val query = CurrentWeatherInput(
                city = "Managua",
                unit = "m",
                language = "en",
            )
            val currentWeatherBO = getCurrentWeatherUseCase.execute(query)
            currentWeatherBO?.let { weatherBO ->
                _status.send(MainScreenStatus.ShowWeather(weatherBO))
            }
        }, exceptionHandler = { 
            _status.send(MainScreenStatus.ShowError(it.toString()))
        })
    }
}
