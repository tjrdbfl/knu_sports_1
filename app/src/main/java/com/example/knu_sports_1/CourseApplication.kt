package com.example.knu_sports_1

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.example.knu_sports_1.databinding.ActivityButton2Binding
import com.example.knu_sports_1.databinding.ActivityCourseApplicationBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.NonCancellable.cancel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.properties.Delegates

class CourseApplication : AppCompatActivity() {
    var classification by Delegates.notNull<String>()
    var course_name by Delegates.notNull<String>()
    var course_detail by Delegates.notNull<String>()
    var application_month by Delegates.notNull<String>()
    var membership by Delegates.notNull<String>()
    var present_number by Delegates.notNull<Long>()
    var total_number by Delegates.notNull<Long>()
    var cmb1 by Delegates.notNull<Int>()
    var cmb2 by Delegates.notNull<Int>()
    var cmb3 by Delegates.notNull<Int>()
    var cmb4 by Delegates.notNull<Int>()
    var cmb5 by Delegates.notNull<Int>()
    var total_cost by Delegates.notNull<Float>()
    //var string_id by Delegates.notNull<String>()
    var session_user_courses by Delegates.notNull<ArrayList<String>>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityCourseApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val refSessionUser = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
          .reference.child("usrs")
            .child(Firebase.auth.uid.toString())
            .child("applied_courses")
        refSessionUser.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                 //This method is called once with the initial value and again
                 //whenever data at this location is updated.
                session_user_courses = snapshot.getValue() as ArrayList<String>
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("ssong", "Failed to read value.", error.toException())
            }

        })

        var applied_course_serial = ""
        val database = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 강좌신청")

        val sAdapter=ArrayAdapter.createFromResource(this,R.array.categories1,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox1.setAdapter(sAdapter)
        fun getApplyInfo()
        {
            applied_course_serial = "$classification-$course_name-$course_detail"
            total_number= -1
            present_number = -1
            var postsRef = database.reference.child("courses").child( applied_course_serial)
            postsRef.addValueEventListener(object: ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val course_info = snapshot.getValue() as Map<String, Long>
                    present_number = course_info["StudentCount"]!!
                    binding.presentNumber.setText("${present_number}/${total_number}")
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("ssong", "Failed to read value.", error.toException())
                }

            })

        }
        //종목구분
        fun clickGolf(){
            val sAdapter1_golf=ArrayAdapter.createFromResource(this,R.array.golf_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_golf)
        }
        fun clickFaculty(){
            val sAdapter1_faculty=ArrayAdapter.createFromResource(this,R.array.faculty_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_faculty)
        }
        fun clickBodyChallenge(){
            val sAdapter1_bodychallenge=ArrayAdapter.createFromResource(this,R.array.bodychallenge_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_bodychallenge)
        }
        fun clickSwimming_health(){
            val sAdapter1_swimming_health=ArrayAdapter.createFromResource(this,R.array.swimming_health_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_swimming_health)
        }
        fun clickAquaAerobic(){
            val sAdapter1_aqua=ArrayAdapter.createFromResource(this,R.array.aquq_aerobics_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_aqua)
        }
        fun clickYoga(){
            val sAdapter1_yoga=ArrayAdapter.createFromResource(this,R.array.oga_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_yoga)
        }
        fun clickTennis(){
            val sAdapter1_tennis=ArrayAdapter.createFromResource(this,R.array.tennis_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_tennis)
        }
        fun clickPilatesHealth(){
            val sAdapter1_pilates_h=ArrayAdapter.createFromResource(this,R.array.pilates_health_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_pilates_h)
        }
        fun clickHealth(){
            val sAdapter1_health=ArrayAdapter.createFromResource(this,R.array.health_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_health)
        }
        fun clickDance(){
            val sAdapter1_dance=ArrayAdapter.createFromResource(this,R.array.dance_health_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_dance)
        }
        fun clickBadminton(){
            val sAdapter1_badminton=ArrayAdapter.createFromResource(this,R.array.badminton_course_name,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox2.setAdapter(sAdapter1_badminton)
        }

        //강좌명+강좌세부선택(badminton)
        fun golf_1(){
            val sAdapter2_1_1=ArrayAdapter.createFromResource(this,R.array.golf_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1_1)
        }
        fun golf_2(){
            val sAdapter2_1_2=ArrayAdapter.createFromResource(this,R.array.golf_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1_2)
        }
        fun golf_3(){
            val sAdapter2_1_3=ArrayAdapter.createFromResource(this,R.array.golf_3,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1_3)
        }
        fun golf_4(){
            val sAdapter2_1_4=ArrayAdapter.createFromResource(this,R.array.golf_4,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1_4)
        }
        fun golf_5(){
            val sAdapter2_1_5=ArrayAdapter.createFromResource(this,R.array.golf_5,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1_5)
        }
        fun faculty2_1(){
            val sAdapter2_2_1=ArrayAdapter.createFromResource(this,R.array.faculty_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_2_1)
        }
        fun swimming_health_5_1(){
            val sAdapter2_5_1=ArrayAdapter.createFromResource(this,R.array.swimming_health_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_5_1)
        }
        fun swimming_health_5_2(){
            val sAdapter2_5_2=ArrayAdapter.createFromResource(this,R.array.swimming_health_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_5_2)
        }
        fun aqua_aerobic_1(){
            val sAdapter2_aa_1=ArrayAdapter.createFromResource(this,R.array.aquq_aerobics_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_aa_1)
        }
        fun aqua_aerobic_2(){
            val sAdapter2_aa_2=ArrayAdapter.createFromResource(this,R.array.aquq_aerobics_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_aa_2)
        }
        fun yoga_1(){
            total_number=10
           val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_2(){
            total_number=5
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_3(){
            total_number=5
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_3,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_4(){
            total_number=15
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_4,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_5(){
            total_number=5
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_5,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_6(){
            total_number=20
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_6,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun yoga_7(){
            total_number=15
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.oga_7,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun tennis_1(){
            total_number=1
            val sAdapter2_1=ArrayAdapter.createFromResource(this,R.array.tennis_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_1)
        }
        fun tennis_2(){
            total_number=1
            val sAdapter2_2=ArrayAdapter.createFromResource(this,R.array.tennis_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_2)
        }
        fun tennis_3(){
            total_number=8
            val sAdapter2_3=ArrayAdapter.createFromResource(this,R.array.tennis_3,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_3)
        }
        fun tennis_4(){
            total_number=1
            val sAdapter2_4=ArrayAdapter.createFromResource(this,R.array.tennis_4,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_4)
        }
        fun tennis_5(){
            total_number=1
            val sAdapter2_5=ArrayAdapter.createFromResource(this,R.array.tennis_5,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_5)
        }
        fun pilates_health_10_1(){
            val sAdapter2_10_1=ArrayAdapter.createFromResource(this,R.array.pilates_health_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_10_1)
        }
        fun pilates_health_10_2(){
            val sAdapter2_10_2=ArrayAdapter.createFromResource(this,R.array.pilates_health_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_10_2)
        }
        fun health11_1(){
            val sAdapter2_11_1=ArrayAdapter.createFromResource(this,R.array.health_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_11_1)
        }
        fun dance_health_12_1(){
            val sAdapter2_12_1=ArrayAdapter.createFromResource(this,R.array.dance_health_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_12_1)
        }
        fun dance_health_12_2(){
            val sAdapter2_12_2=ArrayAdapter.createFromResource(this,R.array.dance_health_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_12_2)
        }
        fun bodychallenge3_1(){
            val sAdapter2_3_1=ArrayAdapter.createFromResource(this,R.array.bodychallenge_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_3_1)
        }
        fun badminton13_1(){
            val sAdapter2_13_1=ArrayAdapter.createFromResource(this,R.array.badminton_1,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_1)
        }
        fun badminton13_2(){
            val sAdapter2_13_2=ArrayAdapter.createFromResource(this,R.array.badminton_2,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_2)
        }
        fun badminton13_3(){
            val sAdapter2_13_3=ArrayAdapter.createFromResource(this,R.array.badminton_3,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_3)
        }
        fun badminton13_4(){
            val sAdapter2_13_4=ArrayAdapter.createFromResource(this,R.array.badminton_4,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_4)
        }
        fun badminton13_5(){
            val sAdapter2_13_5=ArrayAdapter.createFromResource(this,R.array.badminton_5,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_5)
        }
        fun badminton13_6(){
            val sAdapter2_13_6=ArrayAdapter.createFromResource(this,R.array.badminton_6,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_6)
        }
        fun badminton13_7(){
            val sAdapter2_13_7=ArrayAdapter.createFromResource(this,R.array.badminton_7,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_7)
        }
        fun badminton13_8(){
            val sAdapter2_13_8=ArrayAdapter.createFromResource(this,R.array.badminton_8,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_8)
        }
        fun badminton13_9(){
            val sAdapter2_13_9=ArrayAdapter.createFromResource(this,R.array.badminton_9,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_9)
        }
        fun badminton13_10(){
            val sAdapter2_13_10=ArrayAdapter.createFromResource(this,R.array.badminton_10,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_10)
        }
        fun badminton13_11(){
            val sAdapter2_13_11=ArrayAdapter.createFromResource(this,R.array.badminton_11,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_11)
        }
        fun badminton13_12(){
            val sAdapter2_13_12=ArrayAdapter.createFromResource(this,R.array.badminton_12,android.R.layout.simple_spinner_dropdown_item)
            binding.categoryComboBox3.setAdapter(sAdapter2_13_12)
        }
        binding.categoryComboBox1.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2!=0){
                    cmb1=p2
                    classification= p3.toString()
                }
                when(p2){
                    0-> Toast.makeText(applicationContext,"종목구분을 선택해주세요",Toast.LENGTH_SHORT).show()
                    1-> {
                        clickGolf()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    in 1..100-> golf_1()
                                    101->golf_2()
                                    102->golf_3()
                                    103->golf_4()
                                    104->golf_5()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    2-> {
                        clickFaculty()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> faculty2_1()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    3->{
                        clickBodyChallenge()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> bodychallenge3_1()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    4->{
                        clickSwimming_health()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> swimming_health_5_1()
                                    2-> swimming_health_5_2()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    5->{
                        clickAquaAerobic()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> aqua_aerobic_1()
                                    2-> aqua_aerobic_2()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    6->{
                        clickYoga()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> yoga_1()
                                    2-> yoga_2()
                                    3->yoga_3()
                                    4->yoga_4()
                                    5->yoga_5()
                                    6->yoga_6()
                                    7->yoga_7()

                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    7->{
                        clickTennis()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    in 1..6-> tennis_1()
                                    in 7..12-> tennis_2()
                                    13->tennis_3()
                                    in 14..89->tennis_4()
                                    in 90..139->tennis_5()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    8->{
                        clickPilatesHealth()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> pilates_health_10_1()
                                    2-> pilates_health_10_2()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    9->{
                        clickHealth()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> health11_1()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }

                    }
                    10->{
                        clickDance()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> dance_health_12_1()
                                    2-> dance_health_12_2()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                    11->{clickBadminton()
                        binding.categoryComboBox2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                if(p2!=0){
                                    cmb2=p2
                                    course_name=p3.toString()
                                }
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    1-> badminton13_1()
                                    2-> badminton13_2()
                                    3-> badminton13_3()
                                    4-> badminton13_4()
                                    5->badminton13_5()
                                    6-> badminton13_6()
                                    7-> badminton13_7()
                                    8->badminton13_8()
                                    9->badminton13_9()
                                    10-> badminton13_10()
                                    11->badminton13_11()
                                    12->badminton13_12()
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                        binding.categoryComboBox3.onItemSelectedListener=object :AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                when(p2){
                                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                                    else-> {course_detail=p3.toString()
                                        cmb3=p2}
                                }
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext,"종목구분을 선택해주세요",Toast.LENGTH_SHORT).show()
            }
        }
        fun cost1(i:Int,j:Int): Float {
            when(i) {
                1 -> {
                    when (j) {
                        1 -> total_cost = 180000F
                        2 -> total_cost = (180000F * 0.95).toFloat()
                        3 -> total_cost = (180000F * 0.95).toFloat()
                    }
                }
                2 -> {
                    when (j) {
                        1 -> total_cost = 7000F
                        2 -> total_cost = (7000F * 0.95).toFloat()
                        3 -> total_cost = (7000F * 0.95).toFloat()
                    }
                }
                3 -> {
                    when (j) {
                        1 -> total_cost = 60000F
                        2 -> total_cost = (60000F * 0.95).toFloat()
                        3 -> total_cost = (60000F * 0.95).toFloat()
                    }
                }
                4 -> {
                    when (j) {
                        1 -> total_cost = 70000F
                        2 -> total_cost = (70000F * 0.95).toFloat()
                        3 -> total_cost = (70000F * 0.95).toFloat()
                    }
                }

            }

            return total_cost
        }
        fun cost2(i:Int,j:Int): Float {
            when(i){
                1->{
                    when(j){
                        1->total_cost=54000F
                        2->total_cost= (54000F*0.95).toFloat()
                        3->total_cost= (54000F*0.95).toFloat()
                    }
                }
                2,3-> {
                    when (j) {
                        1 -> total_cost = 55000F
                        2 -> total_cost = (55000F * 0.95).toFloat()
                        3 -> total_cost = (55000F * 0.95).toFloat()
                    }
                }
                4,5->{
                    when (j) {
                        1 -> total_cost = 58000F
                        2 -> total_cost = (58000F * 0.95).toFloat()
                        3 -> total_cost = (58000F * 0.95).toFloat()
                    }
                }
                6->{
                    when (j) {
                        1 -> total_cost = 70000F
                        2 -> total_cost = (70000F * 0.95).toFloat()
                        3 -> total_cost = (70000F * 0.95).toFloat()
                    }
                }
                7->{
                    when (j) {
                        1 -> total_cost = 57000F
                        2 -> total_cost = (57000F * 0.95).toFloat()
                        3 -> total_cost = (57000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        fun cost3(i:Int,j:Int): Float {
            when(i){
                1->{
                    total_number=6
                    when(j){
                        1->total_cost=400000F
                        2->total_cost= (400000F*0.95).toFloat()
                        3->total_cost= (400000F*0.95).toFloat()
                    }
                }
                2-> {
                    total_number=6
                    when (j) {
                        1 -> total_cost = 300000F
                        2 -> total_cost = (300000F * 0.95).toFloat()
                        3 -> total_cost = (300000F * 0.95).toFloat()
                    }
                }
                3->{
                    total_number=8
                    when (j) {
                        1 -> total_cost = 140000F
                        2 -> total_cost = (140000F * 0.95).toFloat()
                        3 -> total_cost = (140000F * 0.95).toFloat()
                    }
                }
                4->{
                    total_number=8
                    when (j) {
                        1 -> total_cost = 120000F
                        2 -> total_cost = (120000F * 0.95).toFloat()
                        3 -> total_cost = (120000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        fun cost4(i:Int,j:Int,k:Int): Float {
            when(k){
                1-> {
                    when (i) {
                        1 -> {
                            when (j) {
                                1 -> total_cost = 85000F
                                2 -> total_cost = (85000F * 0.95).toFloat()
                                3 -> total_cost = (85000F * 0.95).toFloat()
                            }
                        }
                        2,3 -> {
                            when (j) {
                                1 -> total_cost = 86000F
                                2 -> total_cost = (86000F * 0.95).toFloat()
                                3 -> total_cost = (86000F * 0.95).toFloat()
                            }
                        }
                        4,5 -> {
                            when (j) {
                                1 -> total_cost = 94000F
                                2 -> total_cost = (94000F * 0.95).toFloat()
                                3 -> total_cost = (94000F * 0.95).toFloat()
                            }
                        }
                    }
                }
                2-> when(i) {
                    1 -> {
                        when (j) {
                            1 -> total_cost = 74000F
                            2 -> total_cost = (74000F * 0.95).toFloat()
                            3 -> total_cost = (74000F * 0.95).toFloat()
                        }
                    }
                    2,3 -> {
                        when (j) {
                            1 -> total_cost = 76000F
                            2 -> total_cost = (76000F * 0.95).toFloat()
                            3 -> total_cost = (76000F * 0.95).toFloat()
                        }
                    }
                    4,5 -> {
                        when (j) {
                            1 -> total_cost = 81000F
                            2 -> total_cost = (81000F * 0.95).toFloat()
                            3 -> total_cost = (81000F * 0.95).toFloat()
                        }
                    }
                }
            }

            return total_cost
        }
        fun cost5(i:Int,j:Int,k:Int): Float {
            when(k){
                1-> {
                    when (i) {
                        1 -> {
                            when (j) {
                                1 -> total_cost = 42000F
                                2 -> total_cost = (42000F * 0.95).toFloat()
                                3 -> total_cost = (42000F * 0.95).toFloat()
                            }
                        }
                        2,3 -> {
                            when (j) {
                                1 -> total_cost = 43000F
                                2 -> total_cost = (43000F * 0.95).toFloat()
                                3 -> total_cost = (43000F * 0.95).toFloat()
                            }
                        }
                        4,5 -> {
                            when (j) {
                                1 -> total_cost = 46000F
                                2 -> total_cost = (46000F * 0.95).toFloat()
                                3 -> total_cost = (46000F * 0.95).toFloat()
                            }
                        }
                        6 -> {
                            when (j) {
                                1 -> total_cost = 59000F
                                2 -> total_cost = (59000F * 0.95).toFloat()
                                3 -> total_cost = (59000F * 0.95).toFloat()
                            }
                        }
                        7->{
                            when (j) {
                                1 -> total_cost = 45000F
                                2 -> total_cost = (45000F * 0.95).toFloat()
                                3 -> total_cost = (45000F * 0.95).toFloat()
                            }
                        }
                    }
                }
                2-> when(i) {
                    1 -> {
                        when (j) {
                            1 -> total_cost = 54000F
                            2 -> total_cost = (54000F * 0.95).toFloat()
                            3 -> total_cost = (54000F * 0.95).toFloat()
                        }
                    }
                    2,3 -> {
                        when (j) {
                            1 -> total_cost = 55000F
                            2 -> total_cost = (55000F * 0.95).toFloat()
                            3 -> total_cost = (55000F * 0.95).toFloat()
                        }
                    }
                    4,5 -> {
                        when (j) {
                            1 -> total_cost = 58000F
                            2 -> total_cost = (58000F * 0.95).toFloat()
                            3 -> total_cost = (58000F * 0.95).toFloat()
                        }
                    }
                    6 -> {
                        when (j) {
                            1 -> total_cost = 70000F
                            2 -> total_cost = (70000F * 0.95).toFloat()
                            3 -> total_cost = (70000F * 0.95).toFloat()
                        }
                    }
                    7->{
                        when (j) {
                            1 -> total_cost = 57000F
                            2 -> total_cost = (57000F * 0.95).toFloat()
                            3 -> total_cost = (57000F * 0.95).toFloat()
                        }
                    }
                }
            }

            return total_cost
        }
        fun cost6(i:Int,j:Int,k:Int): Float {
            when(k){
                7-> {
                    when (i) {
                        1 -> {
                            when (j) {
                                1 -> total_cost =32000F
                                2 -> total_cost = (32000F * 0.95).toFloat()
                                3 -> total_cost = (32000F * 0.95).toFloat()
                            }
                        }
                        2,3 -> {
                            when (j) {
                                1 -> total_cost = 33000F
                                2 -> total_cost = (33000F * 0.95).toFloat()
                                3 -> total_cost = (33000F * 0.95).toFloat()
                            }
                        }
                        4,5 -> {
                            when (j) {
                                1 -> total_cost = 35000F
                                2 -> total_cost = (35000F * 0.95).toFloat()
                                3 -> total_cost = (35000F * 0.95).toFloat()
                            }
                        }
                        6,7 -> {
                            when (j) {
                                1 -> total_cost = 41000F
                                2 -> total_cost = (41000F * 0.95).toFloat()
                                3 -> total_cost = (41000F * 0.95).toFloat()
                            }
                        }
                    }
                }
                1,2,3,6-> when(i) {
                    1 -> {
                        when (j) {
                            1 -> total_cost = 47000F
                            2 -> total_cost = (47000F * 0.95).toFloat()
                            3 -> total_cost = (47000F * 0.95).toFloat()
                        }
                    }
                    2,3 -> {
                        when (j) {
                            1 -> total_cost = 48000F
                            2 -> total_cost = (48000F * 0.95).toFloat()
                            3 -> total_cost = (48000F * 0.95).toFloat()
                        }
                    }
                    4,5 -> {
                        when (j) {
                            1 -> total_cost = 52000F
                            2 -> total_cost = (52000F * 0.95).toFloat()
                            3 -> total_cost = (52000F * 0.95).toFloat()
                        }
                    }
                    6,7 -> {
                        when (j) {
                            1 -> total_cost = 59000F
                            2 -> total_cost = (59000F * 0.95).toFloat()
                            3 -> total_cost = (59000F * 0.95).toFloat()
                        }
                    }
                }
                else->when(i) {
                    1 -> {
                        when (j) {
                            1 -> total_cost = 64000F
                            2 -> total_cost = (64000F * 0.95).toFloat()
                            3 -> total_cost = (64000F * 0.95).toFloat()
                        }
                    }
                    2,3 -> {
                        when (j) {
                            1 -> total_cost = 65000F
                            2 -> total_cost = (65000F * 0.95).toFloat()
                            3 -> total_cost = (65000F * 0.95).toFloat()
                        }
                    }
                    4,5 -> {
                        when (j) {
                            1 -> total_cost = 69000F
                            2 -> total_cost = (69000F * 0.95).toFloat()
                            3 -> total_cost = (69000F * 0.95).toFloat()
                        }
                    }
                    6,7 -> {
                        when (j) {
                            1 -> total_cost = 77000F
                            2 -> total_cost = (77000F * 0.95).toFloat()
                            3 -> total_cost = (77000F * 0.95).toFloat()
                        }
                    }
                }
            }

            return total_cost
        }
        fun cost7(i:Int,j:Int,k:Int): Float {
            when(k){
                4-> {
                    when (i) {
                        1 -> {
                            when (j) {
                                1 -> total_cost = 100000F
                                2 -> total_cost = (100000F * 0.95).toFloat()
                                3 -> total_cost = (100000F * 0.95).toFloat()
                            }
                        }
                        2,3 -> {
                            when (j) {
                                1 -> total_cost = 103000F
                                2 -> total_cost = (103000F * 0.95).toFloat()
                                3 -> total_cost = (103000F * 0.95).toFloat()
                            }
                        }
                        4,5 -> {
                            when (j) {
                                1 -> total_cost = 110000F
                                2 -> total_cost = (110000F * 0.95).toFloat()
                                3 -> total_cost = (110000F * 0.95).toFloat()
                            }
                        }
                        6,7 -> {
                            when (j) {
                                1 -> total_cost = 130000F
                                2 -> total_cost = (130000F * 0.95).toFloat()
                                3 -> total_cost = (130000F * 0.95).toFloat()
                            }
                        }
                    }
                }
                else-> when(i) {
                    1 -> {
                        when (j) {
                            1 -> total_cost = 79000F
                            2 -> total_cost = (79000F * 0.95).toFloat()
                            3 -> total_cost = (79000F * 0.95).toFloat()
                        }
                    }
                    2,3 -> {
                        when (j) {
                            1 -> total_cost = 81000F
                            2 -> total_cost = (81000F * 0.95).toFloat()
                            3 -> total_cost = (81000F * 0.95).toFloat()
                        }
                    }
                    4,5 -> {
                        when (j) {
                            1 -> total_cost = 87000F
                            2 -> total_cost = (87000F * 0.95).toFloat()
                            3 -> total_cost = (87000F * 0.95).toFloat()
                        }
                    }
                    6 -> {
                        when (j) {
                            1 -> total_cost = 106000F
                            2 -> total_cost = (106000F * 0.95).toFloat()
                            3 -> total_cost = (106000F * 0.95).toFloat()
                        }
                    }
                    7->{
                        when (j) {
                            1 -> total_cost = 120000F
                            2 -> total_cost = (120000F * 0.95).toFloat()
                            3 -> total_cost = (120000F * 0.95).toFloat()
                        }
                    }
                }
            }

            return total_cost
        }
        fun cost10(i:Int,j:Int): Float {
            when(i){
                1->{
                    when(j){
                        1->total_cost=64000F
                        2->total_cost= (64000F*0.95).toFloat()
                        3->total_cost= (64000F*0.95).toFloat()
                    }
                }
                2,3-> {
                    when (j) {
                        1 -> total_cost = 65000F
                        2 -> total_cost = (65000F * 0.95).toFloat()
                        3 -> total_cost = (65000F * 0.95).toFloat()
                    }
                }
                4,5->{
                    when (j) {
                        1 -> total_cost = 69000F
                        2 -> total_cost = (69000F * 0.95).toFloat()
                        3 -> total_cost = (69000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        fun cost11(i:Int,j:Int): Float {
            when(i){
                1->{
                    when(j){
                        1->total_cost=42000F
                        2->total_cost= (42000F*0.95).toFloat()
                        3->total_cost= (42000F*0.95).toFloat()
                    }
                }
                2,3-> {
                    when (j) {
                        1 -> total_cost = 43000F
                        2 -> total_cost = (43000F * 0.95).toFloat()
                        3 -> total_cost = (43000F * 0.95).toFloat()
                    }
                }
                4,5->{
                    when (j) {
                        1 -> total_cost = 45000F
                        2 -> total_cost = (45000F * 0.95).toFloat()
                        3 -> total_cost = (45000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        fun cost12(i:Int,j:Int): Float {
            when(i){
                1->{
                    when(j){
                        1->total_cost=74000F
                        2->total_cost= (74000F*0.95).toFloat()
                        3->total_cost= (74000F*0.95).toFloat()
                    }
                }
                2,3-> {
                    when (j) {
                        1 -> total_cost = 76000F
                        2 -> total_cost = (76000F * 0.95).toFloat()
                        3 -> total_cost = (76000F * 0.95).toFloat()
                    }
                }
                4,5->{
                    when (j) {
                        1 -> total_cost = 81000F
                        2 -> total_cost = (81000F * 0.95).toFloat()
                        3 -> total_cost = (81000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        fun cost13(i:Int,j:Int): Float {
            when(i){
                1,2,3->{
                    when(j){
                        1->total_cost=90000F
                        2->total_cost= (90000F*0.95).toFloat()
                        3->total_cost= (90000F*0.95).toFloat()
                    }
                }
                4,5-> {
                    when (j) {
                        1 -> total_cost = 95000F
                        2 -> total_cost = (95000F * 0.95).toFloat()
                        3 -> total_cost = (95000F * 0.95).toFloat()
                    }
                }
                6,7->{
                    when (j) {
                        1 -> total_cost = 100000F
                        2 -> total_cost = (100000F * 0.95).toFloat()
                        3 -> total_cost = (100000F * 0.95).toFloat()
                    }
                }
            }
            return total_cost
        }
        //신청개월
        val sAdapter_4=ArrayAdapter.createFromResource(this,R.array.application_month,android.R.layout.simple_spinner_dropdown_item)
        val sAdapter_5_1=ArrayAdapter.createFromResource(this,R.array.membership_golf,android.R.layout.simple_spinner_dropdown_item)
        val sAdapter_5_3=ArrayAdapter.createFromResource(this,R.array.membership_bodychallenge,android.R.layout.simple_spinner_dropdown_item)
        val sAdapter_5_5=ArrayAdapter.createFromResource(this,R.array.membership_swimming_health,android.R.layout.simple_spinner_dropdown_item)
        val sAdapter_5_e=ArrayAdapter.createFromResource(this,R.array.membership,android.R.layout.simple_spinner_dropdown_item)
        val sAdapter_5_t=ArrayAdapter.createFromResource(this,R.array.membership_tennis,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox4.setAdapter(sAdapter_4)
        binding.categoryComboBox4.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2!=0){
                    application_month=p3.toString()
                }
                when(p2){
                    0-> Toast.makeText(applicationContext,"이전 항목을 체크해주세요.",Toast.LENGTH_SHORT).show()
                    else -> {
                        when(cmb1){
                            1->binding.categoryComboBox5.setAdapter(sAdapter_5_1)
                            3->binding.categoryComboBox5.setAdapter(sAdapter_5_3)
                            7-> binding.categoryComboBox5.setAdapter(sAdapter_5_t)
                            4,8,9,10->binding.categoryComboBox5.setAdapter(sAdapter_5_5)
                            else->{
                                binding.categoryComboBox5.setAdapter(sAdapter_5_e)
                            }
                        }
                        cmb4=p2
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.categoryComboBox5.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2!=0){
                    membership=p3.toString()
                }
                when(p2){
                    0-> Toast.makeText(applicationContext,"이전 항목을 선택해주세요",Toast.LENGTH_SHORT).show()
                    else->{cmb5=p2
                        getApplyInfo()
                        when(cmb1){
                            1->{
                                binding.cost.text = cost1(cmb5,cmb4).toInt().toString()
                                total_number=1
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            2->{
                                binding.cost.text = cost2(cmb5,cmb4).toInt().toString()
                                total_number=15
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            3->{
                                binding.cost.text = cost3(cmb5,cmb4).toInt().toString()
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            4->{
                                binding.cost.text = cost4(cmb5,cmb4,cmb2).toInt().toString()
                                total_number = 25
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            5->{
                                total_number = 75
                                binding.cost.text = cost5(cmb5,cmb4,cmb2).toInt().toString()
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            6->{
                                binding.cost.text = cost6(cmb5,cmb4,cmb2).toInt().toString()
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            7->{
                                binding.cost.text = cost7(cmb5,cmb4,cmb2).toInt().toString()
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            8->{
                                binding.cost.text = cost10(cmb5,cmb4).toInt().toString()
                                total_number = 20
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            9->{
                                binding.cost.text = cost11(cmb5,cmb4).toInt().toString()
                                total_number = 800
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            10->{
                                binding.cost.text = cost12(cmb5,cmb4).toInt().toString()
                                total_number = 20
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                            11-> {
                                binding.cost.text = cost13(cmb5,cmb4).toInt().toString()
                                total_number=1
                                binding.presentNumber.setText("${present_number}/${total_number}")
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.reservationDate.text= LocalDate.now().toString()
        val eventHandler1= object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if(p1==DialogInterface.BUTTON_POSITIVE){


                        var updated_usr_courses = mutableMapOf<String, String>()
                        var i = 0
                        var isAlreadExist = false
                        for(value in session_user_courses){
                            if(value == applied_course_serial)
                            {
                                Toast.makeText(applicationContext,"이미 신청한 과목입니다!",Toast.LENGTH_SHORT).show()
                                isAlreadExist = true
                                break
                            }
                            updated_usr_courses [i.toString()] = value
                            i++
                        }
                        updated_usr_courses [i.toString()] = applied_course_serial
                        if(!isAlreadExist)
                        {
                            refSessionUser
                                .updateChildren(updated_usr_courses.toMap())
                            val mapStudentInfo = mapOf("StudentCount" to (present_number + 1))
                            Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
                                .reference.child("courses")
                                .child( applied_course_serial)
                                .updateChildren( mapStudentInfo)

                        }

                    onBackPressed()
                    //string_id
                }
            }
        }
        binding.btnJoin.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("강좌 신청하기")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 신청하시겠습니까?")
                setPositiveButton("Yes",eventHandler1)
                setNegativeButton("No",null)
                show()
            }
        }
        val eventHandler2= object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1==DialogInterface.BUTTON_POSITIVE){
                    onBackPressed()
                }
            }
        }
        binding.btnCancel.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("강좌 취소하기")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 취소하시겠습니까?")
                setPositiveButton("Yes",eventHandler2)
                setNegativeButton("No",null)
                show()
            }
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
        intent= Intent(this,Button2::class.java)
        startActivity(intent)
        finish()
    }
}