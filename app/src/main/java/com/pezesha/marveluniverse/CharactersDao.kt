package com.pezesha.marveluniverse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters : List<com.pezesha.marveluniverse.models.Character>)


    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacters()

    @Query("SELECT * FROM 'characters'")
    fun getAllCharacters() : Flow<List<com.pezesha.marveluniverse.models.Character>>


}