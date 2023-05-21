package com.ostdan.car_selection.di

import com.ostdan.car_selection.domain.repository.CheckGroupRepository
import com.ostdan.car_selection.domain.repository.CheckRepository
import com.ostdan.car_selection.domain.repository.CheckSessionRepository
import com.ostdan.car_selection.domain.repository.UserRepository
import com.ostdan.car_selection.domain.usecase.FetchCheckGroupUseCase
import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import com.ostdan.car_selection.domain.usecase.FetchCheckUseCase
import com.ostdan.car_selection.domain.usecase.FetchUserUseCase
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
    fun provideFetchCheckSessionUseCase(repository: CheckSessionRepository):
            FetchCheckSessionUseCase = FetchCheckSessionUseCase(repository)

    @Singleton
    @Provides
    fun provideFetchCheckGroupUseCase(repository: CheckGroupRepository):
            FetchCheckGroupUseCase = FetchCheckGroupUseCase(repository)

    @Singleton
    @Provides
    fun provideFetchCheckUseCase(repository: CheckRepository):
            FetchCheckUseCase = FetchCheckUseCase(repository)

    @Singleton
    @Provides
    fun provideFetchUserUseCase(repository: UserRepository):
            FetchUserUseCase = FetchUserUseCase(repository)
}