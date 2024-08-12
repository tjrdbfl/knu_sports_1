package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityBadmintonFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityDanceFragmentOneBinding

class Badminton_fragmentOne : Fragment() {
    lateinit var binding: ActivityBadmintonFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityBadmintonFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }
}