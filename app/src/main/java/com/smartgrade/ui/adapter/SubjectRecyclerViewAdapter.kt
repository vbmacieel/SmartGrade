package com.smartgrade.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.smartgrade.R
import com.smartgrade.data.local.model.relationship.SubjectPoints
import com.smartgrade.databinding.ItemRecyclerViewBinding

class SubjectRecyclerViewAdapter :
    RecyclerView.Adapter<SubjectRecyclerViewAdapter.SubjectViewHolder>() {

    var subjectList: List<SubjectPoints> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.bind(subject)

        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_subject_list_to_grades_list,
                bundleOf("subjectId" to subject.subject.subjectId))
        }
    }

    override fun getItemCount(): Int = subjectList.size

    inner class SubjectViewHolder(
        private val binding: ItemRecyclerViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(subject: SubjectPoints) {
            subject.apply {
                binding.itemTitle.text = subject.subject.name
                binding.itemTotalValue.text = subject.subject.totalPoints.toString()
                binding.itemEarnedValue.text = subject.earnedPoints.toString()
            }
        }
    }
}