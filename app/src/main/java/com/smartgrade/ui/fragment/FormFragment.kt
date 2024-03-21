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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.subjectSubmitButton.setOnClickListener {
            val textName = binding.subjectTextFieldName.editText?.labelNotNullOrEmpty()
            val totalPoints = binding.subjectTextFieldPoints.editText?.labelNotNullOrEmpty()

            if (textName == null || totalPoints == null){
                Toast.makeText(context, "Neither labels must not be null", Toast.LENGTH_SHORT).show()
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