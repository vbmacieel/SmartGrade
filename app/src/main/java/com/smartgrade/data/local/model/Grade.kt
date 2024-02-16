package com.smartgrade.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grade(
    @PrimaryKey(autoGenerate = true) var gradeId: Long,
    var name: String,
    var earnedPoints: Long,
    var totalPoints: Long,
    val subjectGradeId: Int
)
