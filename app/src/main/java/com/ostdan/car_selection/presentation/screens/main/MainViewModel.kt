package com.ostdan.car_selection.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import com.ostdan.car_selection.presentation.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchCheckSessionUseCase: FetchCheckSessionUseCase
): ViewModel() {
    private val _state = MutableStateFlow(ViewState(isLoading = false, data = null))

    val state: StateFlow<ViewState>
        get() = _state

    fun fetchCheckSession(govNumber: String, vin: String, accessToken: String) {
        viewModelScope.launch {
            fetchCheckSessionUseCase(govNumber, vin, accessToken)
                .flowOn(Dispatchers.Default)
                .onStart {
                    Log.d("MainViewModel", "Flow started")
                    _state.value.isLoading = true
                }
                .onCompletion {
                    Log.d("MainViewModel", "Flow completed")
                    _state.value.isLoading = false
                }
                .collect { checkSession ->
                    Log.d("MainViewModel", "Data received")
                    _state.value.data = checkSession
                }
        }
    }
}