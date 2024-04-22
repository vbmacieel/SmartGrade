package com.smartgrade.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.smartgrade.databinding.FragmentFormBinding
import com.smartgrade.ui.viewmodel.FormViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FormFragment : Fragment() {

    private val binding by lazy {
        FragmentFormBinding.inflate(layoutInflater)
    }

    private val viewModel: FormViewModel by viewModel()
    private var subjectId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subjectId = arguments?.getInt("subjectId")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (subjectId == null) binding.textFieldTotalPoints.visibility = View.GONE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (subjectId == null) saveSubject() else saveGrade()
    }

    private fun saveGrade() {
        binding.submitButton.setOnClickListener {
            val textName = binding.textFieldName.editText?.labelNotNullOrEmpty()
            val totalPoints = binding.textFieldPoints.editText?.labelNotNullOrEmpty()
            val totalGradePoints = binding.textFieldTotalPoints.editText?.labelNotNullOrEmpty()

            if (textName == null || totalPoints == null) {
                Toast.makeText(context, "Neither labels must not be null", Toast.LENGTH_SHORT)
                    .show()
            } else {
                subjectId?.let { id ->
                    if (totalGradePoints != null) {
                        viewModel.saveNewGrade(id, textName, totalPoints, totalGradePoints)
                    }
                }
            }
        }
    }

    private fun saveSubject() {
        binding.submitButton.setOnClickListener {
            val textName = binding.textFieldName.editText?.labelNotNullOrEmpty()
            val totalPoints = binding.textFieldPoints.editText?.labelNotNullOrEmpty()

            if (textName == null || totalPoints == null) {
                Toast.makeText(context, "Neither labels must not be null", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.saveNewSubject(textName, totalPoints)
            }
        }
    }

    private fun EditText?.labelNotNullOrEmpty(): String? {
        return this?.let {
            val text = it.text.toString()
            if (text.isEmpty()) {
                return null
            }

            return text
        }
    }
}