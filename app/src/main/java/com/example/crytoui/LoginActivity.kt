package com.example.crytoui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crytoui.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener{
            if(binding.edtUsername.text.toString().isEmpty()||binding.edtPassword.text.toString().isEmpty()){
                Toast.makeText(this@LoginActivity,"Please fill this form",Toast.LENGTH_SHORT).show()
            }else if(binding.edtUsername.text.toString() == "admin" && binding.edtPassword.text.toString() == "admin"){
                binding.edtUsername.setText("")
                binding.edtPassword.setText("")
                val intent = Intent(this, MainScreen::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this@LoginActivity,"Username or password is in correct!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}