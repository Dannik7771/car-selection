package com.ostdan.car_selection.presentation.screens.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    private val TAG = "MainViewModel"

    private val _state = MutableStateFlow(ViewState(isLoading = false, data = null))

    private val maxCharInVIN: Int = 17 //digits in VIN

    val state: StateFlow<ViewState>
        get() = _state

    fun fetchCheckSession() {
        if (vinFieldState.length == maxCharInVIN)
            viewModelScope.launch {
                fetchCheckSessionUseCase(
                    govNumber = "O000OO000", //TODO: from UI
                    vin = vinFieldState,
                    accessToken = "8ac1b5eb-28df-453d-b2d2-71c61f098fc2") //TODO: from datastore
                    .flowOn(Dispatchers.Default)
                    .onStart {
                        Log.d(TAG, "Flow started")
                        _state.value.isLoading = true
                    }
                    .onCompletion {
                        Log.d(TAG, "Flow completed")
                        _state.value.isLoading = false
                    }
                    .collect { checkSession ->
                        _state.value.data = checkSession
                    }
            }
    }

    var vinFieldState by mutableStateOf("")
        private set

    fun updateTextFieldVIN(input: String) {
        var value: String = input
        if (value.length > maxCharInVIN)
            value = vinFieldState
        vinFieldState = value
    }
}