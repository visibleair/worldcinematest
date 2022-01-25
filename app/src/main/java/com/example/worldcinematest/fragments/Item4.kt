package com.example.worldcinematest.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldcinematest.ChatActivity
import com.example.worldcinematest.MainActivity
import com.example.worldcinematest.R
import com.example.worldcinematest.SignIn
import com.example.worldcinematest.databinding.ActivityMainBinding
import com.example.worldcinematest.databinding.ActivitySignInBinding
import com.example.worldcinematest.databinding.FragmentItem1Binding
import com.example.worldcinematest.databinding.FragmentItem4Binding

class Item4 : Fragment() {
    private lateinit var binding: FragmentItem4Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentItem4Binding.inflate(inflater, container, false)

        binding.buttonExit.setOnClickListener{
            startActivity(Intent(requireContext(), SignIn::class.java))
            activity?.finish()

        }
        binding.chats2.setOnClickListener{
            startActivity(Intent(requireContext(),ChatActivity::class.java))
            activity?.finish()
        }
        return binding.root
    }
}