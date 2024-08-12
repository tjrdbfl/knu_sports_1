package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.knu_sports_1.databinding.ActivityPilatesBinding
import com.example.knu_sports_1.databinding.ActivityRacketBinding
import com.google.android.material.tabs.TabLayout

class Racket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityRacketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 강좌안내")

        val tabLayout: TabLayout =binding.tabs
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            //탭 버튼은 선택할 때 이벤트
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction=supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "프로그램 안내" -> transaction.replace(R.id.tabContent,Racket_fragmentOne())
                    "강사 안내" -> transaction.replace(R.id.tabContent, Racket_fragmentTwo())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val transaction=supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "프로그램 안내" -> transaction.replace(R.id.tabContent,Racket_fragmentTwo())
                    "강사 안내" -> transaction.replace(R.id.tabContent, Racket_fragmentOne())
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val transaction=supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "프로그램 안내" -> transaction.replace(R.id.tabContent,Racket_fragmentOne())
                    "강사 안내" -> transaction.replace(R.id.tabContent, Racket_fragmentTwo())
                }
                transaction.commit()
            }
        })
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
        startActivity(Intent(this, Button1::class.java))
        finish()
    }
}