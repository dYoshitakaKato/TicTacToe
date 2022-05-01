package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val model by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = model
        binding.lifecycleOwner = this
        model.winner.observe(this) {
            if (it == ""){
                return@observe
            }
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("TEXT", it)
            startActivity(intent)
        }
    }
}