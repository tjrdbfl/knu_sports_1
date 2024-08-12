package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivitySwimmingFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivitySwimmingFragmentTwoBinding

class Swimming_fragmentTwo : Fragment() {
    lateinit var binding:ActivitySwimmingFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySwimmingFragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

}