package com.example.worldcinematest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.worldcinematest.databinding.ActivityOpenChatBinding
import com.example.worldcinematest.databinding.FragmentItem3Binding

private lateinit var binding: ActivityOpenChatBinding
class OpenChat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOpenChatBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolbar.plus.visibility = View.INVISIBLE
        binding.toolbar.titleBar.text = "Игра пристолов"
        binding.toolbar.backArrow.setOnClickListener{
            startActivity(Intent(this, ChatActivity::class.java))
            finish()
        }
    }
}