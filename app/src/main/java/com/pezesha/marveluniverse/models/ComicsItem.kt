package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicsItem(
    val resourceURI: String,
    val name: String
) : Parcelable
