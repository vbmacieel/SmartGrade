package com.smartgrade

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.smartgrade.data.local.dao.GradeDao
import com.smartgrade.data.local.dao.SubjectDao
import com.smartgrade.data.local.database.AppDatabase
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.Subject
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDatabaseGradeTest {
    private lateinit var database: AppDatabase
    private lateinit var gradeDao: GradeDao
    private lateinit var subjectDao: SubjectDao

    @Before
    fun createDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        database.apply {
            gradeDao = this.gradeDao()
            subjectDao = this.subjectDao()
        }
        generateSubjectsForGrade()
    }

    private fun generateSubjectsForGrade() = runBlocking {
        subjectDao.save(Subject(1, "Matematica", 200))
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun saveNewGrade() = runBlocking {
        val grade = Grade(1, "Prova 1", 50, 100, 1)
        gradeDao.save(grade)
        val findGradesWithSubject = gradeDao.findGradesWithSubject()
        assertTrue(findGradesWithSubject[0].grades.contains(grade))
    }

    @Test
    fun updateGrade() = runBlocking {
        val grade = Grade(2, "Prova 1", 50, 100, 1)
        gradeDao.save(grade)

        val newGrade = Grade(2, "Prova 2", 50, 200, 1)
        gradeDao.save(newGrade)
        val findGradesWithSubject = gradeDao.findGradesWithSubject()
        assertTrue(findGradesWithSubject[0].grades.contains(newGrade))
    }

    @Test
    fun deleteGrade() = runBlocking {
        val grade = Grade(3, "Prova 1", 50, 100, 1)
        gradeDao.save(grade)

        gradeDao.delete(grade)
        val findGradesWithSubject = gradeDao.findGradesWithSubject()
        assertFalse(findGradesWithSubject[0].grades.contains(grade))
    }
}