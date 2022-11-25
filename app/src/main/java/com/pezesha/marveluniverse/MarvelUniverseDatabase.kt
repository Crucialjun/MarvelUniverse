package com.pezesha.marveluniverse

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pezesha.marveluniverse.models.ComicsTypeConverter

import com.pezesha.marveluniverse.models.StoriesTypeConverter
import com.pezesha.marveluniverse.models.ThumbnailTypeConverter

@Database(
    entities = [com.pezesha.marveluniverse.models.Character::class],
    version = 1)
@TypeConverters(
    ComicsTypeConverter::class,
    StoriesTypeConverter::class,
    ThumbnailTypeConverter::class)
abstract class MarverlUniverseDatabase : RoomDatabase() {

    abstract fun charactersDao() : CharactersDao
}