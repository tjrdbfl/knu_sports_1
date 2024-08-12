package com.example.knu_sports_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivitySwimmingFragmentOneBinding

class Swimming_fragmentOne : Fragment() {
    lateinit var binding:ActivitySwimmingFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=ActivitySwimmingFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

}