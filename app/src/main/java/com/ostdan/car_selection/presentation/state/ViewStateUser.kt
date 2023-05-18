package com.ostdan.car_selection.presentation.state

import com.ostdan.car_selection.domain.model.UserDTO

class ViewStateUser (
    var isLoading: Boolean = false,
    var user: UserDTO? = null
)