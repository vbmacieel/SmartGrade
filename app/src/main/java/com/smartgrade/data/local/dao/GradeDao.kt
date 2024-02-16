package com.smartgrade.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.relationship.SubjectGrades

@Dao
interface GradeDao {
    @Transaction
    @Query("SELECT * FROM subject")
    suspend fun getGradesWithSubject(): List<SubjectGrades>

    @Insert
    suspend fun save(grade: Grade)

    @Update
    suspend fun update(grade: Grade)

    @Delete
    suspend fun delete(grade: Grade)
}