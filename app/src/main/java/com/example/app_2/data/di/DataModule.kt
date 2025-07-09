package com.example.app_2.data.di

import com.example.app_2.data.reposity.AuthRepositoryImpl
import com.example.app_2.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun ProvideAuthRepository():AuthRepository {
        return AuthRepositoryImpl()
    }
}