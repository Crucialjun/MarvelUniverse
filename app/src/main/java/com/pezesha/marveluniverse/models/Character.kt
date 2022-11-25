package com.pezesha.marveluniverse.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "characters")
@Parcelize
data class Character(
    val name : String,
    val description :String,
    val comics : Comics?,
    val series : Comics?,
    val stories : Stories?,
    val thumbnail : Thumbnail?,
    @PrimaryKey val id : Int?


) : Parcelable {

}
