package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityHealthFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundFragmentThreeBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundFragmentTwoBinding

class Information_place_BigPlayground_fragmentThree : Fragment() {
    lateinit var binding: ActivityInformationPlaceBigPlaygroundFragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceBigPlaygroundFragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}