package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceSmallPlaygroundFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceSmallPlaygroundFragmentTwoBinding

class Information_place_Tennis_fragmentTwo  : Fragment() {
    lateinit var binding: ActivityInformationPlaceSmallPlaygroundFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceSmallPlaygroundFragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
}