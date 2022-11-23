package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stories(
    val available: Long,
    val collectionURI: String,
    val items: List<StoriesItem>,
    val returned: Long
) : Parcelable
