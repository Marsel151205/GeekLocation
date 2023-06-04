package com.geeks.geeklocation.di

import com.geeks.data.repositories.AuthRepositoryImpl
import com.geeks.data.repositories.SaveUserDataRepositoryImpl
import com.geeks.domain.repositories.AuthRepository
import com.geeks.domain.repositories.SaveUserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindSaveUserDataRepository(saveUserDataRepositoryImpl: SaveUserDataRepositoryImpl): SaveUserDataRepository
}