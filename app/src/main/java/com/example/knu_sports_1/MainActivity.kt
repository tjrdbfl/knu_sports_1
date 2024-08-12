package com.example.knu_sports_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU|체육진흥센터")

        binding.button1.setOnClickListener {
            intent=Intent(this,Button1::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            intent=Intent(this,Button2::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            intent=Intent(this,ShowCoursesActivity::class.java)
            startActivity(intent)
        }
        binding.button4.setOnClickListener {
            intent=Intent(this,Button4::class.java)
            startActivity(intent)
        }
        binding.button5.setOnClickListener {
            intent=Intent(this,Button5::class.java)
            startActivity(intent)
        }
        binding.button6.setOnClickListener {
            intent=Intent(this,ShowFacilitiesActivity::class.java)
            startActivity(intent)
        }
        binding.button7.setOnClickListener {
            intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        binding.button8.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://sports.knu.ac.kr/pages/board/list.php?board_sid=4"))
            startActivity(intent)
        }
        binding.button9.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri
                .parse("https://sports.knu.ac.kr/pages/board/list.php?board_sid=1"))
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_button,menu)
        return super.onCreateOptionsMenu(menu)
    }
}