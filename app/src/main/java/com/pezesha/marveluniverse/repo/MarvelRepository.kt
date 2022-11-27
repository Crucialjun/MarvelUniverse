package com.pezesha.marveluniverse.repo

import androidx.room.withTransaction
import com.pezesha.marveluniverse.MarverlUniverseDatabase
import com.pezesha.marveluniverse.api.MarvelApi
import com.pezesha.marveluniverse.networkBoundResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelRepository @Inject constructor(private val marvelApi: MarvelApi,private val database: MarverlUniverseDatabase) {

    private val dao = database.charactersDao()


    fun getCharacters() = networkBoundResource(
        query = {
            dao.getAllCharacters()
        },
        fetch = {
            marvelApi.loadCharacters()
        },

        saveFetchResult = {
            database.withTransaction{
                dao.deleteAllCharacters()
                dao.insertCharacters(it.data.results)
            }

        }
    )
    }
