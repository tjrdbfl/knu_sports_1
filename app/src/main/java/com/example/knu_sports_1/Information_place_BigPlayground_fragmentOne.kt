package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityHealthFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityInformationPlaceBigPlaygroundFragmentOneBinding

class Information_place_BigPlayground_fragmentOne : Fragment() {
    lateinit var binding: ActivityInformationPlaceBigPlaygroundFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInformationPlaceBigPlaygroundFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }
}