package com.smartgrade.data.repository

import com.smartgrade.data.local.model.Subject

interface SubjectRepository {
    suspend fun findAll(): List<Subject>
    suspend fun findSubjectById(id: Int): Subject
    suspend fun save(subject: Subject)
    suspend fun updateTotalPoints(id: Int, newTotalPoints: Int)
    suspend fun delete(subject: Subject)

}