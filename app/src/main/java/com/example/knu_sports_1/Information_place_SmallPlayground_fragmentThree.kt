package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceIndoorGymFragmentThreeBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceSmallPlaygroundFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceSmallPlaygroundFragmentThreeBinding

class Information_place_SmallPlayground_fragmentThree  : Fragment() {
    lateinit var binding: ActivityInformationPlaceSmallPlaygroundFragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceSmallPlaygroundFragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}