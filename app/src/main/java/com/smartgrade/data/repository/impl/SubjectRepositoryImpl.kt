package com.smartgrade.data.repository.impl

import com.smartgrade.data.local.dao.SubjectDao
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.local.model.relationship.SubjectPoints
import com.smartgrade.data.repository.SubjectRepository

class SubjectRepositoryImpl(
    private val subjectDao: SubjectDao
) : SubjectRepository {

    override suspend fun findAll(): List<SubjectPoints> {
        return subjectDao.findAll()
    }

    override suspend fun findSubjectById(id: Int): Subject {
        return subjectDao.findSubjectById(id)
    }

    override suspend fun save(subject: Subject) {
        subjectDao.save(subject)
    }

    override suspend fun updateTotalPoints(id: Int, newTotalPoints: Int) {
        subjectDao.updateTotalPoints(id, newTotalPoints)
    }

    override suspend fun delete(subject: Subject) {
        subjectDao.delete(subject)
    }
}