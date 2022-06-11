package com.example.widget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget.databinding.ActivityMainBinding
import com.example.widget.databinding.ActivityWidgetBinding

//membuat variabel binding nya
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //memanggi bindig root
        setContentView(binding.root)

        val getData =intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUserName.text = getData?.username.toString()
        binding.txtPassword.text = getData?.password.toString()

        //Explicit intent memanggil activity di project yang sama
        binding.btnWidget.setOnClickListener {
            val intent = Intent(this,Widget::class.java)
            startActivity(intent)

        }

        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent(this,ImplicitIntent::class.java)
            startActivity(intent)
        }
    }

}