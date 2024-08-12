package com.example.knu_sports_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knu_sports_1.databinding.CoursesListBinding

class CourseAdapter(val datas: List<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var m_parent: ViewGroup


    class CourseViewHolder(val binding: CoursesListBinding): RecyclerView.ViewHolder(binding.root)
    override fun getItemCount(): Int = datas.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder {
        m_parent = parent
        return CourseViewHolder(CoursesListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as CourseViewHolder).binding
        val selectedCourse = datas[position]
        binding.courseId.text =   selectedCourse;
        binding.itemRoot.setOnClickListener{
            //val intent = Intent(m_parent.context, ReadPost::class.java)
            //intent.putExtra("제목", selectedPost.first);
            //intent.putExtra("내용", selectedPost.second);
            //m_parent.context.startActivity(intent)
        }

    }

}