package com.pezesha.marveluniverse.api

import com.pezesha.marveluniverse.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MarvelApi {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com"
        const val TS = "marvel"
        const val PUBLIC_API_KEY = "55a69d7b2992b5cf962b6e450aa7e165"
        const val PRIVATE_API_KEY = "d30ec592d68bc00aac26701ab7b4dc3ab40198df"
    }
    @GET("v1/public/characters")
    suspend fun loadCharacters(
        //@Query("orderBy") orderBy :String,
        //@Query("limit")  limit : Int,
        //@Query("offset") offset : Int
    ) : ApiResponse



}