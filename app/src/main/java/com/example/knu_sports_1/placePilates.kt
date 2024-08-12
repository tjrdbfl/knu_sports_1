package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityPlaceExteriorBinding
import com.example.knu_sports_1.databinding.ActivityPlacePilatesBinding

class placePilates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityPlacePilatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 시설안내")
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
        startActivity(Intent(this, Button4::class.java))
        finish()
    }
}