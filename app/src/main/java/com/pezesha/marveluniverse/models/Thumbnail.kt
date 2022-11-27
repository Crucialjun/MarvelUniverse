package com.pezesha.marveluniverse.models

import android.os.Parcelable
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val path: String?,
    val extension: Extension?
) : Parcelable

enum class Extension(val value: String) {
    GIF("gif"),
    Jpg("jpg");

    companion object {
        public fun fromValue(value: String): Extension = when (value) {
            "gif" -> GIF
            "jpg" -> Jpg
            else  -> throw IllegalArgumentException()
        }
    }
}

class ThumbnailTypeConverter{
    @TypeConverter
    fun fromThumbnail(thumbnail: Thumbnail) : String {
        return Gson().toJson(thumbnail)
    }

    @TypeConverter
    fun toThumbnail(thumbnailString : String) : Thumbnail{
        return Gson().fromJson(thumbnailString,object : TypeToken<Thumbnail>() {}.type)
    }
}
