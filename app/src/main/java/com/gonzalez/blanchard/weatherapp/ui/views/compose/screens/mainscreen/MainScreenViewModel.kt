package com.gonzalez.blanchard.weatherapp.ui.views.compose.screens.mainscreen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.domain.base.models.inputs.CurrentWeatherInput
import com.gonzalez.blanchard.domain.base.usecases.GetCurrentWeatherUseCase
import com.gonzalez.blanchard.weatherapp.ui.viewmodel.BaseViewModel
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : BaseViewModel() {

    private val _status = Channel<MainScreenStatus>()
    val status = _status.receiveAsFlow()

    private val _action = Channel<MainScreenActions>()
    val action = _action.receiveAsFlow()

    private val _location = MutableStateFlow<Location?>(null)
    val location: StateFlow<Location?> get() = _location

    fun fetchLocation(context: Context) {
        viewModelScope.launch {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                ) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        _location.value = location
                        fetchWeather()
                    }
            } else {
                // Aquí puedes manejar la situación en la que no tienes permisos.
                // Por ejemplo, podrías enviar un estado para mostrar un mensaje al usuario.
                _status.send(MainScreenStatus.PermissionRequired)
            }
        }
    }

    private fun fetchWeather() {
        val latitude = location.value?.latitude.toString()
        val longitude = location.value?.longitude.toString()
        
        executeUseCase(action = {
            _status.send(MainScreenStatus.Loading)
            val query = CurrentWeatherInput(
                city = "$latitude,$longitude",
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

    fun refreshData(context: Context) {
        viewModelScope.launch {
            _status.send(MainScreenStatus.Loading)
            delay(500)
            fetchLocation(context)
        }
    }
}
