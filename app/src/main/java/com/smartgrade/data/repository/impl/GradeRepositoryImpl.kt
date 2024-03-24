package com.smartgrade.data.repository.impl

import com.smartgrade.data.local.dao.GradeDao
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.repository.GradeRepository

class GradeRepositoryImpl(
    private val gradeDao: GradeDao
) : GradeRepository {

    override suspend fun findGradesWithSubject(subjectId: Int): List<Grade> {
        return gradeDao.findGradesFromSubject(subjectId)
    }

    override suspend fun save(grade: Grade) {
        gradeDao.save(grade)
    }

    override suspend fun delete(grade: Grade) {
        gradeDao.delete(grade)
    }
}