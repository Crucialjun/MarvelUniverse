package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoriesItem(
    val resourceURI: String,
    val name: String,
    val type: ItemType
) : Parcelable

enum class ItemType(val value: String) {
    Cover("cover"),
    Empty(""),
    InteriorStory("interiorStory");

    companion object {
        public fun fromValue(value: String): ItemType = when (value) {
            "cover"         -> Cover
            ""              -> Empty
            "interiorStory" -> InteriorStory
            else            -> throw IllegalArgumentException()
        }
    }
}
