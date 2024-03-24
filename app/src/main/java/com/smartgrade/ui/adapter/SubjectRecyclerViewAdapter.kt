package com.smartgrade.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartgrade.data.local.model.Subject
import com.smartgrade.databinding.ItemRecyclerViewBinding

class SubjectRecyclerViewAdapter :
    RecyclerView.Adapter<SubjectRecyclerViewAdapter.SubjectViewHolder>() {

    var subjectList: List<Subject> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) = holder.bind(subjectList[position])

    override fun getItemCount(): Int = subjectList.size

    inner class SubjectViewHolder(private val binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(subject: Subject) {
            subject.apply {
                binding.itemTitle.text = subject.name
                binding.itemValue.text = subject.totalPoints.toString()
            }
        }
    }
}