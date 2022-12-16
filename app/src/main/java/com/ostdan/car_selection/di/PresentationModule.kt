package com.ostdan.car_selection.di

import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import com.ostdan.car_selection.presentation.screens.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Singleton
    @Provides
    fun provideMainViewModel(useCase: FetchCheckSessionUseCase):
            MainViewModel = MainViewModel(useCase)
}