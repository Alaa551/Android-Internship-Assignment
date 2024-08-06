package com.example.cityexplorer.di

import android.app.Application
import android.content.Context
import com.example.cityexplorer.data.datasource.CityDataSource
import com.example.cityexplorer.data.datasource.CityDataSourceImp
import com.example.cityexplorer.data.parser.CityJsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CityDataSourceModule {

    @Provides
    @Singleton
    fun provideCityDataSource(
        cityJsonParser: CityJsonParser
    ): CityDataSource = CityDataSourceImp(cityJsonParser)

}