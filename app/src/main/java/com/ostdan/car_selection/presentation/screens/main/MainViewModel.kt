package com.ostdan.car_selection.presentation.screens.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostdan.car_selection.data.datastore.UserScheme.KEY_USER_ID
import com.ostdan.car_selection.domain.model.RoleDTO
import com.ostdan.car_selection.domain.model.UserDTO
import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import com.ostdan.car_selection.domain.usecase.FetchUserUseCase
import com.ostdan.car_selection.presentation.state.ViewStateCheckSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchCheckSessionUseCase: FetchCheckSessionUseCase,
    private val fetchUserUseCase: FetchUserUseCase,
    private val userDataStore: DataStore<Preferences>
): ViewModel() {
    private val TAG = "MainViewModel"

    private val _carSessionState = MutableStateFlow(ViewStateCheckSession(isLoading = false, checkSession = null))

    private val maxCharInVIN: Int = 17 //digits in VIN

    private var userFetched = false

    val state: StateFlow<ViewStateCheckSession>
        get() = _carSessionState
    var vinFieldState by mutableStateOf("")
        private set

    fun fetchCheckSession() {
        viewModelScope.launch {
            userDataStore.data.collect { preferences ->
                if (vinFieldState.length == maxCharInVIN) {
                    fetchCheckSessionUseCase(
                        govNumber = "O000OO000", //TODO: from UI
                        vin = vinFieldState,
                        accessToken = preferences[KEY_USER_ID].toString()
                    )
                        .flowOn(Dispatchers.Default)
                        .onStart {
                            _carSessionState.value = ViewStateCheckSession(true, null)
                        }
                        .onCompletion {
                        }
                        .collect { checkSession ->
                            _carSessionState.value = ViewStateCheckSession(false, checkSession)
                        }
                }
            }
        }
    }

    fun fetchUser() {
        if (!userFetched) { //TODO: убрать заглушку
            Log.d(TAG, "fetchUser")
            viewModelScope.launch {
                fetchUserUseCase(
                    //TODO: переписать
                    UserDTO(
                        userId = "",
                        name = "UserName",
                        password = "password",
                        role = RoleDTO.User
                    )
                )
                    .flowOn(Dispatchers.Default)
                    .onStart {
                        Log.d(TAG, "Flow started")
                    }
                    .onCompletion {
                        Log.d(TAG, "Flow completed")
                    }
                    .collect { user ->
                        val userId = user.userId
                        userDataStore.edit { preferences ->
                            preferences[KEY_USER_ID] = userId
                        }
                    }
            }
            userFetched = true
        }
    }

    fun updateTextFieldVIN(input: String) {
        var value: String = input
        if (value.length > maxCharInVIN)
            value = vinFieldState
        vinFieldState = value
    }
}