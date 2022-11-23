package com.pezesha.marveluniverse.api

data class ApiResponse(
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<com.pezesha.marveluniverse.models.Character>
)