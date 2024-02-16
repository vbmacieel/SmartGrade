package com.smartgrade.data.local.model.relationship

import androidx.room.Embedded
import androidx.room.Relation
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.Subject

data class SubjectGrades(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "subjectGradeId",
        entity = Grade::class
    )
    val grades: List<Grade>
)
