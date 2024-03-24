package com.smartgrade.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartgrade.data.local.model.Grade

@Dao
interface GradeDao {
    @Query("SELECT * FROM grade WHERE subjectId = :subjectId")
    suspend fun findGradesFromSubject(subjectId: Int): List<Grade>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(grade: Grade)

    @Delete
    suspend fun delete(grade: Grade)
}