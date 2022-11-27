package com.pezesha.marveluniverse

import android.app.Application
import androidx.room.Room
import com.pezesha.marveluniverse.api.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(MarvelApi.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }


    @Provides
    @Singleton
    fun providesMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)

    @Provides
    @Singleton
    fun providesDatabase(app: Application): MarverlUniverseDatabase =
        Room.databaseBuilder(app, MarverlUniverseDatabase::class.java, "marvel_universe_database")
            .build()

}