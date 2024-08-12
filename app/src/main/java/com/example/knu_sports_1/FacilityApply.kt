package com.example.knu_sports_1

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.knu_sports_1.databinding.ActivityFacilityApplyBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.LocalDate
import java.util.*
import kotlin.properties.Delegates
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FacilityApply : AppCompatActivity() {
    var classification by Delegates.notNull<String>()
    var reservation_date by Delegates.notNull<String>()
    var application_date by Delegates.notNull<String>()
    var reservation_time1 by Delegates.notNull<String>()
    var reservation_time2 by Delegates.notNull<String>()
    var membership by Delegates.notNull<String>()
    var member_number by Delegates.notNull<String>()
    var member_name by Delegates.notNull<String>()
    var plan by Delegates.notNull<String>()
    var string_id by Delegates.notNull<String>()

    var cmb1 by Delegates.notNull<Int>()
    var cmb2 by Delegates.notNull<Int>()
    var cmb3 by Delegates.notNull<Int>()
    var cmb4 by Delegates.notNull<Int>()

    lateinit var datePickerText:TextView
    lateinit var calendar: Calendar
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityFacilityApplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("KNU | 시설물 이용신청")

        val sAdapter1= ArrayAdapter.createFromResource(this,R.array.facility_classification,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox1.setAdapter(sAdapter1)
        binding.categoryComboBox1.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {
                    cmb1 = p2
                    classification = p3.toString()
                }
                when (p2) {
                    0 -> Toast.makeText(applicationContext, "시설구분을 선택해주세요", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "시설구분을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        //sharedPreference를 이용한 기기에 선택한 날짜 데이터 저장
        val sharedPreference = getSharedPreferences("CreateProfile", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        //오늘 날짜
        val today:Long=MaterialDatePicker.todayInUtcMilliseconds()
        binding.reservationDateBtn.setOnClickListener(){
            val calendarConstraintBuilder=CalendarConstraints.Builder()
            calendarConstraintBuilder.setValidator(DateValidatorPointForward.now())

            //오늘 날짜 셋팅
            val builder = MaterialDatePicker.Builder.datePicker() //datePicker를 만들어줍니다.
                .setTitleText("예약 날짜") //DatePicker창에 타이틀을 정해줍니다.
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())//기본 선택값을정하는곳이고 오늘로 설정했습니다.
                .setCalendarConstraints(calendarConstraintBuilder.build())
            val datePicker=builder.build()
            datePicker.addOnPositiveButtonClickListener{
                val calendar=Calendar.getInstance()
                calendar.time= Date(it)
                val calendarMilli=calendar.timeInMillis
                binding.reservationDateBtn.text="${calendar.get(Calendar.YEAR)}.${calendar.get(Calendar.MONTH) + 1}.${calendar.get(Calendar.DAY_OF_MONTH)}"
                reservation_date="${calendar.get(Calendar.YEAR)}.${calendar.get(Calendar.MONTH) + 1}.${calendar.get(Calendar.DAY_OF_MONTH)}"
                //sharedPreference
                editor.putLong("예약 날짜", calendarMilli)
                editor.apply()
            }
            datePicker.show(supportFragmentManager,datePicker.toString())
        }

        val sAdapter2= ArrayAdapter.createFromResource(this,R.array.reservation_time,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox2.setAdapter(sAdapter2)
        binding.categoryComboBox2.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {
                    cmb2 = p2
                    reservation_time1 = p3.toString()
                }
                when (p2) {
                    0 -> Toast.makeText(applicationContext, "예약시간을 선택해주세요", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "예약시간을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        val sAdapter3= ArrayAdapter.createFromResource(this,R.array.reservation_time,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox3.setAdapter(sAdapter3)
        binding.categoryComboBox3.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {
                    cmb3 = p2
                    reservation_time2 = p3.toString()
                }
                when (p2) {
                    0 -> Toast.makeText(applicationContext, "예약시간을 선택해주세요", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "예약시간을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        val sAdapter4= ArrayAdapter.createFromResource(this,R.array.facility_membership,android.R.layout.simple_spinner_dropdown_item)
        binding.categoryComboBox4.setAdapter(sAdapter4)
        binding.categoryComboBox4.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {
                    cmb4 = p2
                    membership = p3.toString()
                }
                when (p2) {
                    0 -> Toast.makeText(applicationContext, "신청자 소속을 선택해주세요", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "신청자 소속을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                member_number=binding.editText1.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                member_name=binding.editText2.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.editText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                plan=binding.editText3.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.applicationDate.text= LocalDate.now().toString()
        application_date= LocalDate.now().toString()
        val eventHandler1= object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1== DialogInterface.BUTTON_POSITIVE){

                    //string_id
                    val refSessionUser = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
                        .reference.child("usrs")
                        .child(Firebase.auth.uid.toString())
                        .child("applied_facilities")
                    refSessionUser.addValueEventListener(object: ValueEventListener {

                        override fun onDataChange(snapshot: DataSnapshot) {
                            //This method is called once with the initial value and again
                            //whenever data at this location is updated.
                            val session_user_facilities = snapshot.getValue() as ArrayList<String>
                            var updated_usr_facilities = mutableMapOf<String, String>()
                            var i = 0
                            string_id= "$classification-$reservation_date"
                            var isAlreadExist = false
                            for(value in  session_user_facilities){
                                if(value ==  string_id)
                                {
                                    Toast.makeText(applicationContext,"이미 신청한 기간입니다!",Toast.LENGTH_SHORT).show()
                                    isAlreadExist = true
                                    break
                                }
                                updated_usr_facilities [i.toString()] = value
                                i++
                            }
                            if(!isAlreadExist)
                            {
                                updated_usr_facilities  [i.toString()] = string_id
                                Log.d("ssong", updated_usr_facilities.toString())
                                refSessionUser
                                    .updateChildren( updated_usr_facilities.toMap())
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.w("ssong", "Failed to read value.", error.toException())
                        }

                    })
                    onBackPressed()

                }
            }
        }
        binding.btnJoin.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("시설물 이용신청 신청하기")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 신청하시겠습니까?")
                setPositiveButton("Yes",eventHandler1)
                setNegativeButton("No",null)
                show()
            }
        }
        val eventHandler2= object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1== DialogInterface.BUTTON_POSITIVE){
                    onBackPressed()
                }
            }
        }
        binding.btnCancel.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("시설물 이용신청 취소하기")
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
        startActivity(Intent(this, Button5::class.java))
        finish()
    }
}