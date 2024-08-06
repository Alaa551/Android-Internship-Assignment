package com.example.cityexplorer.di

import com.example.cityexplorer.data.parser.CityJsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class JsonParserModule {

    @Provides
    @Singleton
    fun provideJsonParser(): CityJsonParser = CityJsonParser()
}