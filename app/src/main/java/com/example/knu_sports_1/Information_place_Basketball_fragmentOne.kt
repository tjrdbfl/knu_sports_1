package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBasketballFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundFragmentOneBinding

class Information_place_Basketball_fragmentOne : Fragment() {
    lateinit var binding: ActivityInformationPlaceBasketballFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceBasketballFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }
}