package com.smartgrade.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgrade.data.local.model.Grade
import com.smartgrade.data.repository.GradeRepository
import kotlinx.coroutines.launch

class GradeViewModel(
    private val gradeRepository: GradeRepository
) : ViewModel() {
    private lateinit var _gradesList: MutableLiveData<List<Grade>>
    var gradesList: LiveData<List<Grade>> = _gradesList

    fun findAllGrades(subjectId: Int) = viewModelScope.launch {
        _gradesList.postValue(gradeRepository.findGradesWithSubject(subjectId))
    }

}