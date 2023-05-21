package com.ostdan.car_selection.di

import com.ostdan.car_selection.data.mapper.CheckGroupMapper
import com.ostdan.car_selection.data.mapper.CheckMapper
import com.ostdan.car_selection.data.mapper.CheckSessionMapper
import com.ostdan.car_selection.data.mapper.UserMapper
import com.ostdan.car_selection.data.model.remote.service.CheckGroupService
import com.ostdan.car_selection.data.model.remote.service.CheckService
import com.ostdan.car_selection.data.model.remote.service.CheckSessionService
import com.ostdan.car_selection.data.model.remote.service.UserService
import com.ostdan.car_selection.data.repository.CheckGroupRepositoryImpl
import com.ostdan.car_selection.data.repository.CheckRepositoryImpl
import com.ostdan.car_selection.data.repository.CheckSessionRepositoryImpl
import com.ostdan.car_selection.data.repository.UserRepositoryImpl
import com.ostdan.car_selection.domain.repository.CheckSessionRepository
import com.ostdan.car_selection.data.utilities.FlowResourceCallAdapterFactory
import com.ostdan.car_selection.domain.repository.CheckGroupRepository
import com.ostdan.car_selection.domain.repository.CheckRepository
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
        service: CheckSessionService,
        mapper: CheckSessionMapper
    ): CheckSessionRepository = CheckSessionRepositoryImpl(
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

    @Singleton
    @Provides
    fun provideCheckGroupRepository(
        service: CheckGroupService,
        mapper: CheckGroupMapper
    ): CheckGroupRepository = CheckGroupRepositoryImpl(
        service, mapper
    )

    @Singleton
    @Provides
    fun provideCheckRepository(
        service: CheckService,
        mapper: CheckMapper
    ): CheckRepository = CheckRepositoryImpl(
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
    fun provideCheckSessionService(retrofit: Retrofit): CheckSessionService {
        return retrofit.create(CheckSessionService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideCheckGroupService(retrofit: Retrofit): CheckGroupService {
        return retrofit.create(CheckGroupService::class.java)
    }

    @Provides
    @Singleton
    fun provideCheckService(retrofit: Retrofit): CheckService {
        return retrofit.create(CheckService::class.java)
    }
}