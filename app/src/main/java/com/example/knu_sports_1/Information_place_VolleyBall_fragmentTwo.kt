package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityInformationPlaceTennisFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceVolleyBallFragmentThreeBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceVolleyBallFragmentTwoBinding

class Information_place_VolleyBall_fragmentTwo : Fragment() {
    lateinit var binding: ActivityInformationPlaceVolleyBallFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceVolleyBallFragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
}