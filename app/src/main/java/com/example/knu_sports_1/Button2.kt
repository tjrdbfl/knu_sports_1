package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityButton1Binding
import com.example.knu_sports_1.databinding.ActivityButton2Binding

class Button2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityButton2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 강좌신청")
        val sessionUID = intent.extras?.getString("SessionUID")
        binding.button21.setOnClickListener {
            intent=Intent(this,CourseApplication::class.java)
            intent.putExtra("SessionUID",sessionUID)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_home_button,menu)
        val menuHome=menu?.findItem(R.id.menu_home)
        menuHome?.setOnMenuItemClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            return@setOnMenuItemClickListener true
        }
        return true
    }
    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}