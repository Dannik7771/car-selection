package com.ostdan.car_selection.presentation.screens.checks

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostdan.car_selection.data.datastore.UserScheme
import com.ostdan.car_selection.domain.usecase.FetchCheckUseCase
import com.ostdan.car_selection.presentation.state.ViewStateCheck
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val fetchCheckUseCase: FetchCheckUseCase,
    private val userDataStore: DataStore<Preferences>
): ViewModel() {

    private val checkId: String = checkNotNull(savedStateHandle["checkId"])

    private val _checkState = MutableStateFlow(ViewStateCheck(isLoading = false, check = null))
    val state: StateFlow<ViewStateCheck>
        get() = _checkState

    fun fetchCheck() {
        viewModelScope.launch {
            userDataStore.data.collect { preferences ->
                fetchCheckUseCase(
                    checkId = checkId,
                    accessToken = preferences[UserScheme.KEY_USER_ID].toString()
                )
                    .flowOn(Dispatchers.Default)
                    .onStart {
                        _checkState.value = ViewStateCheck(true, null)
                    }
                    .onCompletion {
                    }
                    .collect { check ->
                        _checkState.value = ViewStateCheck(false, check)
                    }
            }
        }
    }
}