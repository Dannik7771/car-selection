package com.ostdan.car_selection.data.model.remote.service

import com.ostdan.car_selection.data.model.remote.CheckResponse
import com.ostdan.car_selection.data.repository.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CheckService {
    @GET("/check")
    fun getCheckById(
        @Query("checkId") checkGroupId: String,
        @Query("userId") accessToken: String
    ): Flow<Resource<CheckResponse>>
}