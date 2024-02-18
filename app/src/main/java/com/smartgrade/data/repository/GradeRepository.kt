package com.smartgrade.data.repository

import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.relationship.SubjectGrades

interface GradeRepository {
    suspend fun findGradesWithSubject(): List<SubjectGrades>
    suspend fun save(grade: Grade)
    suspend fun delete(grade: Grade)
}