package com.pezesha.marveluniverse.models

enum class URLType(val value: String) {
    Comiclink("comiclink"),
    Detail("detail"),
    Wiki("wiki");

    companion object {
        public fun fromValue(value: String): URLType = when (value) {
            "comiclink" -> Comiclink
            "detail"    -> Detail
            "wiki"      -> Wiki
            else        -> throw IllegalArgumentException()
        }
    }
}
