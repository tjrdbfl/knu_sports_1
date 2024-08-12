package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityHealthFragmentTwoBinding
import com.example.knu_sports_1.databinding.ActivitySwimmingFragmentOneBinding

class Health_fragmentTwo : Fragment() {
    lateinit var binding: ActivityHealthFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityHealthFragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
}