package com.example.app_2.data.di

import com.example.app_2.data.repository.AuthRepositoryImpl
import com.example.app_2.data.repository.PetRepositoryImpl
import com.example.app_2.data.repository.UserRepositoryImpl
import com.example.app_2.domain.repository.AuthRepository
import com.example.app_2.domain.repository.PetRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindPetRepository(impl: PetRepositoryImpl): PetRepository
}