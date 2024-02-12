package com.smartgrade.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.smartgrade.data.local.model.Subject

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subject")
    suspend fun findAll(): List<Subject>

    @Insert
    suspend fun save(subject: Subject)

    @Update
    suspend fun update(subject: Subject, oldSubjectId: String)

    @Delete
    suspend fun delete(subject: Subject)
}