package com.gonzalez.blanchard.domain.base.models

data class AlertItem(
    val title: String,
    val description: String,
    val severity: String,
    val startDate: String,
    val endDate: String
)