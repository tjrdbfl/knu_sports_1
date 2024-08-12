package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityButton1Binding

class Button1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityButton1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 강좌안내")

        binding.swimming.setOnClickListener {
            intent= Intent(this,Swimming::class.java)
            startActivity(intent)
        }

        binding.health.setOnClickListener {
            intent= Intent(this,Health::class.java)
            startActivity(intent)
        }
        binding.yoga.setOnClickListener {
            intent= Intent(this,Yoga::class.java)
            startActivity(intent)
        }
        binding.pilates.setOnClickListener {
            intent= Intent(this,Pilates::class.java)
            startActivity(intent)
        }
        binding.golf.setOnClickListener {
            intent= Intent(this,Golf::class.java)
            startActivity(intent)
        }
        binding.tennis.setOnClickListener {
            intent= Intent(this,Tennis::class.java)
            startActivity(intent)
        }
        binding.racket.setOnClickListener {
            intent= Intent(this,Racket::class.java)
            startActivity(intent)
        }
        binding.dance.setOnClickListener {
            intent= Intent(this,Dance::class.java)
            startActivity(intent)
        }
        binding.badminton.setOnClickListener {
            intent= Intent(this,Badminton::class.java)
            startActivity(intent)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_home_button,menu)
        val menuHome=menu?.findItem(R.id.menu_home)
        menuHome?.setOnMenuItemClickListener {
            intent=Intent(this,MainActivity::class.java)
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