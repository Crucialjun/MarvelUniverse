package com.pezesha.marveluniverse.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.pezesha.marveluniverse.MarvelCharactersPagingSource
import com.pezesha.marveluniverse.api.MarvelApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelRepository @Inject constructor(private val marvelApi: MarvelApi) {
    fun getCharacters() = Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = false,
                initialLoadSize = 10

            ),
            pagingSourceFactory = {  MarvelCharactersPagingSource(marvelApi) }
        ).liveData
    }
