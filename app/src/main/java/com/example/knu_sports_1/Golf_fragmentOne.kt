package com.example.knu_sports_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.knu_sports_1.databinding.ActivityGolfFragmentOneBinding
import com.example.knu_sports_1.databinding.ActivityHealthFragmentOneBinding

class Golf_fragmentOne : Fragment() {
    lateinit var binding: ActivityGolfFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityGolfFragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }
}