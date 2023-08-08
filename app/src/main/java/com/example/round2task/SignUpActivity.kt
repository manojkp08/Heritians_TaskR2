package com.example.round2task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.round2task.databinding.ActivitySignInBinding
import com.example.round2task.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener{
            val email = binding.edtEmailSignUp.text.toString()
            val password = binding.edtPasswordSignUp.text.toString()
            
            signUp(email, password)

        }
    }

    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if(task.isSuccessful){
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUpActivity, "Some error occured", Toast.LENGTH_SHORT).show()
                }
            }
    }
}