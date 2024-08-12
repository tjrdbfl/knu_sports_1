package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivitySwimmingFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityTennisFragmentOneBinding

class Tennis_fragmentOne : Fragment() {
    lateinit var binding: ActivityTennisFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityTennisFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

}