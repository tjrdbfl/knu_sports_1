package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityDanceFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityGolfFragmentOneBinding

class Dance_fragmentOne : Fragment() {
    lateinit var binding: ActivityDanceFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityDanceFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }
}