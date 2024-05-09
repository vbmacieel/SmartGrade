package com.smartgrade.data.local.model.relationship

import androidx.room.Embedded
import com.smartgrade.data.local.model.Subject

data class SubjectPoints(
    @Embedded val subject: Subject,
    val earnedPoints: Int
)
