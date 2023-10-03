package com.gonzalez.blanchard.localdatasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SettingsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val primaryKey: Int = 1,
    @ColumnInfo(name = "default_place") val defaultPlace: String,
)
