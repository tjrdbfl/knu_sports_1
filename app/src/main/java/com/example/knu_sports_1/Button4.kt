package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityButton1Binding
import com.example.knu_sports_1.databinding.ActivityButton4Binding

class Button4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityButton4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 시설안내")

        binding.placeExterior.setOnClickListener {
            intent= Intent(this,placeExterior::class.java)
            startActivity(intent)
        }

        binding.placeSwimmingPool.setOnClickListener {
            intent= Intent(this,placeSwimmingPool::class.java)
            startActivity(intent)
        }
        binding.placeGolfCourse.setOnClickListener {
            intent= Intent(this,placeGolfCourse::class.java)
            startActivity(intent)
        }
        binding.placeGym.setOnClickListener {
            intent= Intent(this,placeGym::class.java)
            startActivity(intent)
        }
        binding.placeRacket.setOnClickListener {
            intent= Intent(this,placeRacket::class.java)
            startActivity(intent)
        }
        binding.placeTennis.setOnClickListener {
            intent= Intent(this,placeTennis::class.java)
            startActivity(intent)
        }
        binding.placeYoga.setOnClickListener {
            intent= Intent(this,placeYoga::class.java)
            startActivity(intent)
        }
        binding.placePilates.setOnClickListener {
            intent= Intent(this,placePilates::class.java)
            startActivity(intent)
        }
        binding.placeBigPlayground.setOnClickListener {
            intent= Intent(this,placeBigPlayground::class.java)
            startActivity(intent)
        }
        binding.placeSmallPlayground.setOnClickListener {
            intent= Intent(this,placeSmallPlayground::class.java)
            startActivity(intent)
        }
        binding.placeMultipurposeStadium.setOnClickListener {
            intent= Intent(this,placeMultipurposeStadium::class.java)
            startActivity(intent)
        }
        binding.placeIndoorGym.setOnClickListener {
            intent= Intent(this,placeIndoorGym::class.java)
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