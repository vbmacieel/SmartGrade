package com.smartgrade.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.local.model.relationship.SubjectPoints
import com.smartgrade.data.repository.SubjectRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val subjectRepository: SubjectRepository
) : ViewModel() {
    private lateinit var _subjectList: MutableLiveData<List<SubjectPoints>>
    val subjectList: LiveData<List<SubjectPoints>> = _subjectList

    fun findSubjectList() = viewModelScope.launch {
        _subjectList.postValue(subjectRepository.findAll())
    }
}