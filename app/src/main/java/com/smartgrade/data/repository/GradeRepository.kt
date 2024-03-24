package com.smartgrade.data.repository

import com.smartgrade.data.local.model.Grade

interface GradeRepository {
    suspend fun findGradesWithSubject(subjectId: Int): List<Grade>
    suspend fun save(grade: Grade)
    suspend fun delete(grade: Grade)
}