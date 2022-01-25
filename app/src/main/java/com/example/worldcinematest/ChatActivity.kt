package com.example.worldcinematest

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.worldcinematest.databinding.ActivityChatBinding

private lateinit var binding: ActivityChatBinding
class ChatActivity : AppCompatActivity() {
    private var titlesList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.plus.visibility = View.INVISIBLE
        binding.toolbar.backArrow.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.button.setOnClickListener{
            startActivity(Intent(this, OpenChat::class.java))
        }


    }
    private fun addToList(title: String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..25){
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }
}