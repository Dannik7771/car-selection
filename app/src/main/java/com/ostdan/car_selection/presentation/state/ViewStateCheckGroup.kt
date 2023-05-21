package com.ostdan.car_selection.presentation.state

import com.ostdan.car_selection.domain.model.CheckGroupDTO

data class ViewStateCheckGroup (
    var isLoading: Boolean = false,
    var checkGroup: CheckGroupDTO? = null
)