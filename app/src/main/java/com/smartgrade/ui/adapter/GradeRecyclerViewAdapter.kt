package com.smartgrade.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.smartgrade.data.local.model.Grade
import com.smartgrade.databinding.ItemGradeRecyclerviewBinding

class GradeRecyclerViewAdapter : Adapter<GradeRecyclerViewAdapter.GradeHolder>() {

    var gradeList: List<Grade> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeHolder {
        val binding = ItemGradeRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GradeHolder(binding)
    }

    override fun onBindViewHolder(holder: GradeHolder, position: Int) {
        val grade = gradeList[position]
        holder.bind(grade)
    }

    override fun getItemCount(): Int = gradeList.size

    inner class GradeHolder(
        private val binding: ItemGradeRecyclerviewBinding
    ): ViewHolder(binding.root) {

        fun bind(grade: Grade) {
            grade.apply {
                binding.gradeName.text = this.name
                binding.gradeValue.text = this.earnedPoints.toString()
            }
        }
    }
}