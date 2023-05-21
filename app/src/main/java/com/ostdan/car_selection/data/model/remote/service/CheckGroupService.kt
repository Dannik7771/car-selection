package com.ostdan.car_selection.data.model.remote.service

import com.ostdan.car_selection.data.model.remote.CheckGroupResponse
import com.ostdan.car_selection.data.repository.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CheckGroupService {
    @GET("/group")
    fun getCheckGroupById(
        @Query("checkGroupId") checkGroupId: String,
        @Query("userId") accessToken: String
    ): Flow<Resource<CheckGroupResponse>>
}