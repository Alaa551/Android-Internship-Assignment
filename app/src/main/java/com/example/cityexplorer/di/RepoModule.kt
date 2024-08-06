package com.example.cityexplorer.di

import com.example.cityexplorer.data.datasource.CityDataSource
import com.example.cityexplorer.repo.CityRepository
import com.example.cityexplorer.repo.CityRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(cityDataSource: CityDataSource): CityRepository =
        CityRepositoryImp(cityDataSource)

}