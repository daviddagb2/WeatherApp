package com.gonzalez.blanchard.domain.base.models

data class RequestBO(
    val type: String,
    val query: String,
    val language: String,
    val unit: String,
)
