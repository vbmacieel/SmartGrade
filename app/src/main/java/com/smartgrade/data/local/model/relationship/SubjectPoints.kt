package com.smartgrade.data.local.model.relationship

data class SubjectPoints(
    val subjectId: Int,
    val name: String,
    val totalPoints: Int,
    val earnedPoints: Int
)
