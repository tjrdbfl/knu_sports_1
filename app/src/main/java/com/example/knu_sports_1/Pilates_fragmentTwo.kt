package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityPilatesFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityPilatesFragmentTwoBinding

class Pilates_fragmentTwo : Fragment() {
    lateinit var binding: ActivityPilatesFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityPilatesFragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

}