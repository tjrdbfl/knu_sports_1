package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceIndoorGymFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceIndoorGymFragmentThreeBinding

class Information_place_IndoorGym_fragmentThree  : Fragment() {
    lateinit var binding: ActivityInformationPlaceIndoorGymFragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceIndoorGymFragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}