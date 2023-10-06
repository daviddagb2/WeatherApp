package com.gonzalez.blanchard.domain.base.models

data class SettingsItem(
    val unit: String,
    val theme: String,
    val notificationsEnabled: Boolean
)