package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ComicsItem(
    val resourceURI: String,
    val name: String
) : Parcelable
