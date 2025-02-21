package com.example.cityexplorer.di

import android.content.Context
import com.example.cityexplorer.data.parser.CityJsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JsonParserModule {

    @Provides
    @Singleton
    fun provideJsonParser(context: Context): CityJsonParser = CityJsonParser(context)
}