package com.example.knu_sports_1.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.knu_sports_1.MainActivity
import com.example.knu_sports_1.R
import com.example.knu_sports_1.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue


class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            if(email.isEmpty()){
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password1.isEmpty()){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password2.isEmpty()){
                Toast.makeText(this, "비밀번호확인을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(!password1.equals(password2)){
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password1.length < 6){
                Toast.makeText(this, "비밀번호를 6자 이상 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(isGoToJoin) {
                auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(this, "성공",Toast.LENGTH_LONG).show()
                            val  sessionUsrRef = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
                                .reference.child("usrs").child(auth.uid.toString())

                            sessionUsrRef.child("applied_courses").setValue(mapOf<String, String>(0.toString() to "0-0-0"))
                            sessionUsrRef.child("applied_facilities").setValue(mapOf<String, String>(0.toString() to "0-2002.07.16"))
                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "실패",Toast.LENGTH_LONG).show()
                        }
                    }

            }
        }
    }
}