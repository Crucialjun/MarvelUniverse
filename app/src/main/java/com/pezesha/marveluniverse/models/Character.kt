package com.pezesha.marveluniverse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name : String,
    val description :String,
    val comics : Comics?,
    val series : Comics?,
    val stories : Stories?,
    val thumbnail : Thumbnail?


) : Parcelable {

}
