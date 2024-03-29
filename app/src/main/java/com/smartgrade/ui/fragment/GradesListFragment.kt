package com.smartgrade.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartgrade.databinding.FragmentListGradeBinding
import com.smartgrade.ui.adapter.GradeRecyclerViewAdapter
import com.smartgrade.ui.viewmodel.GradeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GradesListFragment: Fragment() {

    private val binding by lazy {
        FragmentListGradeBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: GradeRecyclerViewAdapter
    private val viewModel: GradeViewModel by viewModel()
    private var subjectId: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subjectId = arguments?.getInt("subjectId")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subjectId?.let { viewModel.findAllGrades(it) }
        adapter = GradeRecyclerViewAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gradesList.observe(viewLifecycleOwner) { gradeList ->
            adapter.gradeList = gradeList
        }
    }
}