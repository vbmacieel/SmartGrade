package com.smartgrade.di

import com.smartgrade.data.local.database.AppDatabase
import com.smartgrade.data.repository.GradeRepository
import com.smartgrade.data.repository.SubjectRepository
import com.smartgrade.data.repository.impl.GradeRepositoryImpl
import com.smartgrade.data.repository.impl.SubjectRepositoryImpl
import com.smartgrade.ui.viewmodel.FormViewModel
import com.smartgrade.ui.viewmodel.GradeViewModel
import com.smartgrade.ui.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { AppDatabase.getInstance(androidContext()) }

    single {
        val database = AppDatabase.getInstance(androidContext())
        database.subjectDao()
    }

    single {
        val database = AppDatabase.getInstance(androidContext())
        database.gradeDao()
    }

    single<SubjectRepository> { SubjectRepositoryImpl(get()) }

    single<GradeRepository> { GradeRepositoryImpl(get()) }

    viewModel { MainViewModel(get()) }

    viewModel { FormViewModel(get(), get()) }

    viewModel { GradeViewModel(get()) }
}