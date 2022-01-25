package com.example.worldcinematest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.worldcinematest.databinding.FragmentItem1Binding

class Item1 : Fragment () {
    private lateinit var binding: FragmentItem1Binding
    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentItem1Binding.inflate(inflater, container, false)


        adapter = NumberAdapter(requireActivity())
        binding.pager.adapter = adapter
        return binding.root
    }
}