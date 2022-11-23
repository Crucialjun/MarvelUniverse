package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comics(
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
) : Parcelable
