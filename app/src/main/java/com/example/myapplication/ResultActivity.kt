package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val model by viewModels<ResultViewModel>()
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_result)
        binding.viewModel = model
        binding.lifecycleOwner = this
        model.onLoad((intent.getStringExtra("TEXT") ?: ""))
    }
}