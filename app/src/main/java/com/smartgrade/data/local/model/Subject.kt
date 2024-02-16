package com.smartgrade.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true) var subjectId: Int = 0,
    val name: String,
    var totalPoints: Int
)
