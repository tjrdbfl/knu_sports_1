package com.example.knu_sports_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knu_sports_1.databinding.FacilitiesListBinding

class FacilityAdapter(val datas: List<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var m_parent: ViewGroup


    class FacilityViewHolder(val binding: FacilitiesListBinding): RecyclerView.ViewHolder(binding.root)
    override fun getItemCount(): Int = datas.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder {
        m_parent = parent
        return FacilityViewHolder(FacilitiesListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FacilityViewHolder).binding
        val selectedFacility = datas[position]
        binding.facilityId.text =  selectedFacility ;

    }

}