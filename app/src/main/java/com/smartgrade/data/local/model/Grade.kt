package com.smartgrade.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grade(
    @PrimaryKey(autoGenerate = true) val gradeId: Int,
    var name: String,
    var earnedPoints: Long,
    var totalPoints: Long,
    val subjectGradeId: Int
)
