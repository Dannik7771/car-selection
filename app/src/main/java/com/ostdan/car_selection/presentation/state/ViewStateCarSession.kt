package com.ostdan.car_selection.presentation.state

import com.ostdan.car_selection.domain.model.CheckSessionDTO

data class ViewStateCarSession (
    var isLoading: Boolean = false,
    var checkSession: CheckSessionDTO? = null
)