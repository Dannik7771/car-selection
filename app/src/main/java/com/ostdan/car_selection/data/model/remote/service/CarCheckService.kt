package com.ostdan.car_selection.data.model.remote.service

import com.ostdan.car_selection.data.model.remote.CheckSessionResponse
import com.ostdan.car_selection.data.repository.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CarCheckService {

    @GET("/car/vin")
    fun getCheckSessionByVin(
        @Query("searchQuery") vin: String,
        @Query("userId") accessToken: String
    ): Flow<Resource<CheckSessionResponse>>
}