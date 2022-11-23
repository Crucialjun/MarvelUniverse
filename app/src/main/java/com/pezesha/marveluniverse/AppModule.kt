package com.pezesha.marveluniverse

import com.pezesha.marveluniverse.api.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object AppModule {

    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder().baseUrl(MarvelApi.BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()

    fun providesMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)
}