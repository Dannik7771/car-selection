package com.ostdan.car_selection.data.model.remote.service

import com.ostdan.car_selection.data.model.remote.CheckSessionResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CarCheckService {

    @GET("/search")
    fun getCheckSession(
        @Query("vin") vin: String,
        @Query("gov_number") govNumber: String,
        @Query("access_token") accessToken: String
    ): Flow<CheckSessionResponse>
}