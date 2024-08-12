package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityButton2Binding
import com.example.knu_sports_1.databinding.ActivityButton5Binding

class Button5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityButton5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 시설물사용신청")

        binding.placeBigPlayground.setOnClickListener {
            intent=Intent(this,Information_place_BigPlayground::class.java)
            startActivity(intent)
        }
        binding.placeSmallPlayground.setOnClickListener {
            intent=Intent(this,Information_place_SmallPlayground::class.java)
            startActivity(intent)
        }
        binding.placeIndoorGym.setOnClickListener {
            intent=Intent(this,Information_place_IndoorGym::class.java)
            startActivity(intent)
        }
        binding.placeBasketball.setOnClickListener {
            intent=Intent(this,Information_place_BasketBall::class.java)
            startActivity(intent)
        }
        binding.placeVolleyball.setOnClickListener {
            intent=Intent(this,Information_place_VolleyBall::class.java)
            startActivity(intent)
        }
        binding.placeTennis.setOnClickListener {
            intent=Intent(this,Information_place_Tennis::class.java)
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