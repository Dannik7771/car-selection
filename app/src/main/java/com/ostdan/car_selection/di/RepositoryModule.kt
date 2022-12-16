package com.ostdan.car_selection.di

import com.ostdan.car_selection.data.mapper.CheckSessionMapper
import com.ostdan.car_selection.data.model.remote.service.CarCheckService
import com.ostdan.car_selection.data.repository.CarCheckRepositoryImpl
import com.ostdan.car_selection.domain.repository.CarCheckRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCarCheckRepository(
        service: CarCheckService,
        mapper: CheckSessionMapper
    ): CarCheckRepository = CarCheckRepositoryImpl(
        service, mapper
    )

    @Provides
    @Singleton
    fun provideRetrofit(): CarCheckService {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .build()
            .create(CarCheckService::class.java)
    }
}