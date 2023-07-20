package com.ahuaman.recipeapp.data.di

import com.ahuaman.recipeapp.data.remote.RemoteDataSource
import com.ahuaman.recipeapp.data.remote.RemoteDataSourceImpl
import com.ahuaman.recipeapp.data.repository.Repository
import com.ahuaman.recipeapp.data.repository.RepositoryImpl
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
    abstract fun provideRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    @Singleton
    abstract fun provideMoviesRepository(
        moviesRepositoryImpl: RepositoryImpl
    ): Repository

}