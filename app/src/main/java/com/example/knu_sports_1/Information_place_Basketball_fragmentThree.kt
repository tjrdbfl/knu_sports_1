package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBasketballFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBasketballFragmentThreeBinding

class Information_place_Basketball_fragmentThree : Fragment() {
    lateinit var binding: ActivityInformationPlaceBasketballFragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceBasketballFragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}