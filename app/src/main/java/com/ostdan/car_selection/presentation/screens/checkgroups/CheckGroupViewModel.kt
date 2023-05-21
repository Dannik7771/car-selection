package com.ostdan.car_selection.presentation.screens.checkgroups

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostdan.car_selection.data.datastore.UserScheme
import com.ostdan.car_selection.domain.usecase.FetchCheckGroupUseCase
import com.ostdan.car_selection.presentation.state.ViewStateCheckGroup
import com.ostdan.car_selection.presentation.state.ViewStateCheckSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckGroupViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val fetchCheckGroupUseCase: FetchCheckGroupUseCase,
    private val userDataStore: DataStore<Preferences>
): ViewModel() {

    private val checkGroupId: String = checkNotNull(savedStateHandle["checkGroupId"])

    private val _checkGroupState = MutableStateFlow(ViewStateCheckGroup(isLoading = false, checkGroup = null))
    val state: StateFlow<ViewStateCheckGroup>
        get() = _checkGroupState

    fun fetchCheckGroup() {
        viewModelScope.launch {
            userDataStore.data.collect { preferences ->
                fetchCheckGroupUseCase(
                    checkGroupId = checkGroupId,
                    accessToken = preferences[UserScheme.KEY_USER_ID].toString()
                )
                    .flowOn(Dispatchers.Default)
                    .onStart {
                        _checkGroupState.value = ViewStateCheckGroup(true, null)
                    }
                    .onCompletion {
                    }
                    .collect { checkGroup ->
                        _checkGroupState.value = ViewStateCheckGroup(false, checkGroup)
                    }
            }
        }
    }
}