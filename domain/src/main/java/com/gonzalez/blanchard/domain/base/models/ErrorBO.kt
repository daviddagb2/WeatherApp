package com.gonzalez.blanchard.domain.base.models

data class ErrorBO(
    val success: Boolean,
    val error: ErrorDetailBO,
)
