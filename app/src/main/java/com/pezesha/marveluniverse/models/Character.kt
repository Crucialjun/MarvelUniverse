package com.pezesha.marveluniverse.models

data class Character(
    val name : String,
    val description :String,
    val comics : Comics?,
    val series : Comics?,
    val stories : Stories?,
    val thumbnail : Thumbnail?


){

}
