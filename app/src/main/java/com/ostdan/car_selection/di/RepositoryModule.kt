package com.ostdan.car_selection.di

import com.ostdan.car_selection.data.mapper.CheckSessionMapper
import com.ostdan.car_selection.data.mapper.UserMapper
import com.ostdan.car_selection.data.model.remote.service.CarCheckService
import com.ostdan.car_selection.data.model.remote.service.UserService
import com.ostdan.car_selection.data.repository.CarCheckRepositoryImpl
import com.ostdan.car_selection.data.repository.UserRepositoryImpl
import com.ostdan.car_selection.domain.repository.CarCheckRepository
import com.ostdan.car_selection.data.utilities.FlowResourceCallAdapterFactory
import com.ostdan.car_selection.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Singleton
    @Provides
    fun provideUserRepository(
        service: UserService,
        mapper: UserMapper
    ): UserRepository = UserRepositoryImpl(
        service, mapper
    )

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowResourceCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideCarCheckService(retrofit: Retrofit): CarCheckService {
        return retrofit.create(CarCheckService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}