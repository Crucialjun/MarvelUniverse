package com.pezesha.marveluniverse

import com.pezesha.marveluniverse.api.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit = Retrofit.Builder().baseUrl(MarvelApi.BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)
}