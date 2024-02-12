package com.smartgrade.data.local.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.Subject

data class SubjectWithGrades(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "subjectGradeId"
    )
    val grades: List<Grade>
)
