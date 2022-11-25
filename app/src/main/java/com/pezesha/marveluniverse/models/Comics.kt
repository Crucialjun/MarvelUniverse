package com.pezesha.marveluniverse.models

import android.os.Parcelable
import android.util.Log
import androidx.room.Entity
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject

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


