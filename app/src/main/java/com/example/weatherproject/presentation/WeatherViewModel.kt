package com.example.weatherproject.presentation

import androidx.lifecycle.*
import com.example.weatherproject.data.WeatherRepositoryImpl
import com.example.weatherproject.domain.model.DomainWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepositoryImpl
    ) : ViewModel() {

    private val _searchResult = MutableStateFlow<WeatherResult>(WeatherResult.Loading)
    val searchResult: LiveData<WeatherResult>
        get() = _searchResult.asLiveData(viewModelScope.coroutineContext)

    fun load(){
        viewModelScope.launch {
            handleSearchMovie("moscow")
        }
    }

sealed class WeatherResult {

    object Loading : WeatherResult()
    object EmptyResult : WeatherResult()
    object EmptyQuery : WeatherResult()
    data class SuccessResult(val result: DomainWeather) : WeatherResult()
    data class ErrorResult(val e: Throwable) : WeatherResult()
}
    private suspend fun handleSearchMovie(query: String) = viewModelScope.launch {
         try {
            val res = repository.getCurrentWeather(query)
             _searchResult.value = WeatherResult.SuccessResult(res)
        }catch (e : IOException){
             _searchResult.value = WeatherResult.ErrorResult(IllegalArgumentException("server error!"))
        }
    }

}
