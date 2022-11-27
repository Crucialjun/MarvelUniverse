package com.pezesha.marveluniverse.models

import android.os.Parcelable
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comics(
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
) : Parcelable


class ComicsTypeConverter{
    @TypeConverter
    fun fromComics(comics: Comics) : String {
        return Gson().toJson(comics)
    }

    @TypeConverter
    fun toComics(comicString : String) : Comics{
        return Gson().fromJson(comicString,object : TypeToken<Comics>() {}.type)
    }
}


