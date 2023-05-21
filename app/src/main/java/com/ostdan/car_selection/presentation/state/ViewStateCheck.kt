package com.ostdan.car_selection.presentation.state

import com.ostdan.car_selection.domain.model.CheckDTO

data class ViewStateCheck (
    var isLoading: Boolean = false,
    var check: CheckDTO? = null
)