package com.smartgrade

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.smartgrade.data.local.dao.SubjectDao
import com.smartgrade.data.local.database.AppDatabase
import com.smartgrade.data.local.model.Subject
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDatabaseSubjectTest {
    private lateinit var appDatabase: AppDatabase
    private lateinit var subjectDao: SubjectDao

    @Before
    fun setUpDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        subjectDao = appDatabase.subjectDao()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun insertAndReadOneSubject() = runBlocking {
        val subject = Subject(1, "Matematica", 100)
        subjectDao.save(subject)
        val allSubjects = subjectDao.findAll()
        assertTrue(allSubjects.contains(subject))
    }

    @Test
    fun updateTotalPoints() = runBlocking {
        val subject = Subject(1, "Portuguese", 200)
        subjectDao.save(subject)

        val idFromItemToUpdate = subject.subjectId
        val newTotalPoints = 1200
        subjectDao.updateTotalPoints(idFromItemToUpdate, newTotalPoints)

        val subjectFromId = subjectDao.findSubjectById(idFromItemToUpdate)
        assertEquals(subjectFromId.totalPoints, newTotalPoints)
    }

    @Test
    fun deleteSubject() = runBlocking {
        val subject = Subject(1,"Matematica", 100)
        subjectDao.delete(subject)
        assertTrue(!subjectDao.findAll().contains(subject))
    }
}