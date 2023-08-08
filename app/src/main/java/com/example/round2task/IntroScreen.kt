package com.example.round2task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.round2task.databinding.ActivityIntroScreenBinding

class IntroScreen : AppCompatActivity() {
    private lateinit var binding: ActivityIntroScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerfl.setOnClickListener {
            val intent = Intent(this@IntroScreen, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.signinfl.setOnClickListener {
            val intent = Intent(this@IntroScreen, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}