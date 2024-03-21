package com.smartgrade.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.repository.SubjectRepository
import kotlinx.coroutines.launch

class FormViewModel(
    private val subjectRepository: SubjectRepository
) : ViewModel() {

    fun saveNewSubject(name: String, points: String) {
        val subject = Subject(name = name, totalPoints = points.toInt())
        viewModelScope.launch {
            subjectRepository.save(subject)
        }
    }
}