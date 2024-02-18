package com.smartgrade.data.repository.impl

import com.smartgrade.data.local.dao.GradeDao
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.relationship.SubjectGrades
import com.smartgrade.data.repository.GradeRepository

class GradeRepositoryImpl(
    private val gradeDao: GradeDao
) : GradeRepository {

    override suspend fun findGradesWithSubject(): List<SubjectGrades> {
        return gradeDao.findGradesWithSubject()
    }

    override suspend fun save(grade: Grade) {
        gradeDao.save(grade)
    }

    override suspend fun delete(grade: Grade) {
        gradeDao.delete(grade)
    }
}