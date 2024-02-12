package com.smartgrade.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.smartgrade.data.local.dao.GradeDao
import com.smartgrade.data.local.dao.SubjectDao
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.Subject

@Database(entities = [Subject::class, Grade::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subjectDao(): SubjectDao
    abstract fun gradeDao(): GradeDao

    companion object {
        private const val DATABASE_NAME = "subject_grades.db"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
                return instance
            }
        }
    }
}