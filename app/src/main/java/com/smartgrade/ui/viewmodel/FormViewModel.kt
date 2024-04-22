package com.smartgrade.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.repository.GradeRepository
import com.smartgrade.data.repository.SubjectRepository
import kotlinx.coroutines.launch

class FormViewModel(
    private val subjectRepository: SubjectRepository,
    private val gradeRepository: GradeRepository
) : ViewModel() {

    fun saveNewSubject(name: String, points: String) {
        val subject = Subject(name = name, totalPoints = points.toInt())
        viewModelScope.launch {
            subjectRepository.save(subject)
        }
    }

    fun saveNewGrade(subjectId: Int, name: String, points: String, totalPoints: String) {
        val grade = Grade(name = name, earnedPoints = points.toLong(),
            totalPoints = totalPoints.toLong(), subjectId = subjectId)
        viewModelScope.launch {
            gradeRepository.save(grade)
        }
    }
}