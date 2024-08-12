package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceSmallPlaygroundFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceTennisFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceTennisFragmentThreeBinding

class Information_place_Tennis_fragmentThree  : Fragment() {
    lateinit var binding: ActivityInformationPlaceTennisFragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceTennisFragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}