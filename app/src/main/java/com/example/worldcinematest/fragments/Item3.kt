package com.example.worldcinematest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldcinematest.R
import com.example.worldcinematest.databinding.FragmentItem1Binding
import com.example.worldcinematest.databinding.FragmentItem3Binding

class Item3 : Fragment() {
    private lateinit var binding: FragmentItem3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentItem3Binding.inflate(inflater, container, false)
        binding.toolbar.titleBar.text = "Коллекции"
        binding.toolbar.backArrow.visibility = View.INVISIBLE
        return binding.root

    }
}