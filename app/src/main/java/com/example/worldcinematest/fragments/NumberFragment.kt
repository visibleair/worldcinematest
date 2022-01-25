package com.example.worldcinematest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.worldcinematest.R
import com.example.worldcinematest.R.*
import com.example.worldcinematest.databinding.FragmentNumberBinding

const val ARG_OBJECT = "object"
private lateinit var binding: FragmentNumberBinding
class NumberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            binding.textView.text = getInt(ARG_OBJECT).toString()

        }
    }
}

