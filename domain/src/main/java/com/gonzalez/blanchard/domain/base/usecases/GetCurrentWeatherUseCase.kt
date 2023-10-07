package com.gonzalez.blanchard.domain.base.usecases

import com.gonzalez.blanchard.domain.base.UseCase
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.domain.base.models.inputs.CurrentWeatherInput
import com.gonzalez.blanchard.domain.base.repository.IWeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: IWeatherRepository,
) : UseCase<CurrentWeatherInput, WeatherBO>() {

    override suspend fun useCaseFunction(input: CurrentWeatherInput): WeatherBO {
        return weatherRepository.getCurrentWeather(
            input.city,
            input.unit,
            input.language,
        )
    }
}
