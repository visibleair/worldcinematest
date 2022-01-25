package com.example.worldcinematest

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcinematest.databinding.ActivityMainBinding
import com.example.worldcinematest.fragments.Item1
import com.example.worldcinematest.fragments.Item2
import com.example.worldcinematest.fragments.Item3
import com.example.worldcinematest.fragments.Item4

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Item1()).commit()
        binding.bottomMenu.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Item1()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Item2()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Item3()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item4 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Item4()).commit()
                    return@setOnItemSelectedListener true
                }


            }
            return@setOnItemSelectedListener false
        }
    }
}