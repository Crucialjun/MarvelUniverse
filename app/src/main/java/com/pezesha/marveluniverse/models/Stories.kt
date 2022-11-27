package com.pezesha.marveluniverse.models

import android.os.Parcelable
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stories(
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
) : Parcelable

class StoriesTypeConverter{
    @TypeConverter
    fun fromStory(story: Stories) : String {
        return Gson().toJson(story)
    }

    @TypeConverter
    fun toStory(storyString : String) : Stories{
        return Gson().fromJson(storyString,object : TypeToken<Stories>() {}.type)
    }
}
