package com.pezesha.marveluniverse

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pezesha.marveluniverse.api.MarvelApi
import com.pezesha.marveluniverse.models.Character
import retrofit2.HttpException
import java.io.IOException

class MarvelCharactersPagingSource(
    private val marvelApi: MarvelApi,
): PagingSource<Int,com.pezesha.marveluniverse.models.Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val currentPostion = params.key ?:1

        return try {
            val response = marvelApi.loadCharacters()

            val characters = response.results

            LoadResult.Page(
                data = characters,
                prevKey = if(currentPostion == 1 ) null else currentPostion - 1,
                nextKey = currentPostion + 1,
            )
        } catch (e : IOException){
            LoadResult.Error(e)
        }catch (e : HttpException){
            LoadResult.Error(e)
        }
    }

}