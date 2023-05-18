package com.ostdan.car_selection.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ostdan.car_selection.domain.usecase.FetchCheckSessionUseCase
import com.ostdan.car_selection.domain.usecase.FetchUserUseCase
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
    fun provideMainViewModel(carSessionUseCase: FetchCheckSessionUseCase,
                             userUseCase: FetchUserUseCase,
                             dataStore: DataStore<Preferences>):
            MainViewModel = MainViewModel(carSessionUseCase, userUseCase, dataStore)
}