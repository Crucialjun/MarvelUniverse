package com.pezesha.marveluniverse

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pezesha.marveluniverse.api.MarvelApi
import com.pezesha.marveluniverse.models.Character
import retrofit2.HttpException
import java.io.IOException

class MarvelCharactersPagingSource(
    private val marvelApi: MarvelApi,
): PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val currentPosition = params.key ?:1

        return try {
            val response = marvelApi.loadCharacters()

            val characters = response.data.results

            Log.d("Load Result", "load:$response ")
            print("This is the load result $response")

            LoadResult.Page(
                data = characters,
                prevKey = if(currentPosition == 1 || currentPosition < 1 ) null else currentPosition - 1,
                nextKey = if(characters.isEmpty())null else currentPosition + 1,
            )
        } catch (e : IOException){
            LoadResult.Error(e)
        }catch (e : HttpException){
            LoadResult.Error(e)
        }
    }

}