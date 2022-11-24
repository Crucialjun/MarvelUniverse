package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: Extension
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
