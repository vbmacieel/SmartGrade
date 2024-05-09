package com.smartgrade.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.local.model.relationship.SubjectPoints

@Dao
interface SubjectDao {
    @Query("""
        SELECT s.subjectId, s.name, s.totalPoints, SUM(g.earnedPoints) AS earnedPoints
        FROM subject s JOIN grade g ON s.subjectId = g.subjectId
        GROUP BY s.subjectId
    """)
    suspend fun findAll(): List<SubjectPoints>

    @Query("SELECT * FROM subject WHERE subjectId = :id")
    suspend fun findSubjectById(id: Int): Subject

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(subject: Subject)

    @Query("UPDATE subject SET totalPoints = :newTotalPoints WHERE subjectId = :id")
    suspend fun updateTotalPoints(id: Int, newTotalPoints: Int)

    @Delete
    suspend fun delete(subject: Subject)
}