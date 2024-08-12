package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityGolfFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityGolfFragmentTwoBinding

class Golf_fragmentTwo : Fragment() {
    lateinit var binding: ActivityGolfFragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityGolfFragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }
}