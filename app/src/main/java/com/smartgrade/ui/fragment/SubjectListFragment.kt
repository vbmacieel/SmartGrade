package com.smartgrade.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smartgrade.R
import com.smartgrade.data.local.model.Subject
import com.smartgrade.data.repository.SubjectRepository
import com.smartgrade.databinding.FragmentListSubjectBinding
import com.smartgrade.ui.adapter.SubjectRecyclerViewAdapter
import com.smartgrade.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubjectListFragment : Fragment() {

    private val binding by lazy {
        FragmentListSubjectBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: SubjectRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = SubjectRecyclerViewAdapter()
        viewModel.findSubjectList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabNewSubject.setOnClickListener {
            findNavController().navigate(R.id.action_subject_list_to_add_subject)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.subjectList.observe(this) {subjectList ->
            adapter.subjectList = subjectList
        }
    }
}