package com.example.knu_sports_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knu_sports_1.databinding.ActivityShowCoursesBinding
import com.example.knu_sports_1.CourseAdapter
import com.example.knu_sports_1.databinding.ActivityShowFacilitiesBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.*
import com.google.firebase.ktx.Firebase

class ShowFacilitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityShowFacilitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 신청시설")
        val refSessionUser = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference.child("usrs")
            .child(Firebase.auth.uid.toString())
            .child("applied_facilities")

        val refCourses = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
            .reference.child("facilities")

        var facility_info = mutableListOf<String>()
        refSessionUser.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val session_user_facilities= snapshot.getValue() as ArrayList<String>
                facility_info.clear()

                for(serial_id in session_user_facilities)
                {
                    val pairSerialDate = serial_id.split("-")
                    refCourses.addValueEventListener(object: ValueEventListener {

                        override fun onDataChange(snapshot: DataSnapshot) {
                            val facility_name_list= snapshot.getValue() as ArrayList<String>

                            if(pairSerialDate[0] != "0")
                            facility_info.add(facility_name_list[pairSerialDate[0].toInt()]  + " 일시: " + pairSerialDate[1])
                            (binding.facilitiesRecyclerView.adapter as FacilityAdapter).notifyDataSetChanged()
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.w("ssong", "Failed to read value.", error.toException())
                        }

                    })
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("ssong", "Failed to read value.", error.toException())
            }

        })
        binding.facilitiesRecyclerView.adapter = FacilityAdapter(facility_info)
        binding.facilitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.facilitiesRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL))
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
        intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}