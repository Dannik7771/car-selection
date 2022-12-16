package com.ostdan.car_selection.di

import com.ostdan.car_selection.domain.repository.CarCheckRepository
import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideFetchCheckSessionUseCase(repository: CarCheckRepository):
            FetchCheckSessionUseCase = FetchCheckSessionUseCase(repository)
}