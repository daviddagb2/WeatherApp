package com.gonzalez.blanchard.domain.base.models

data class ErrorDetailBO(
    val code: Int,
    val type: String,
    val info: String,
)
