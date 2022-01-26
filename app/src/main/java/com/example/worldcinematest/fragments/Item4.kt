package com.example.worldcinematest.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.worldcinematest.ChatActivity
import com.example.worldcinematest.Common.Global.Companion.token1
import com.example.worldcinematest.MainActivity
import com.example.worldcinematest.R
import com.example.worldcinematest.SignIn
import com.example.worldcinematest.data.User
import com.example.worldcinematest.databinding.ActivityMainBinding
import com.example.worldcinematest.databinding.ActivitySignInBinding
import com.example.worldcinematest.databinding.FragmentItem1Binding
import com.example.worldcinematest.databinding.FragmentItem4Binding
import com.google.gson.Gson
import com.google.gson.internal.`$Gson$Types`.arrayOf
import okhttp3.*
import java.io.IOException

class Item4 : Fragment() {
    private lateinit var binding: FragmentItem4Binding
    private lateinit var request: Request
    private var client = OkHttpClient()
    private lateinit var formBody: FormBody
    private lateinit var formHeader: Headers
    private lateinit var gson: Gson
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var firstName: String
    private lateinit var lastName: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentItem4Binding.inflate(inflater, container, false)
        var url = "http://cinema.areas.su/user"
        binding.buttonExit.setOnClickListener{
            startActivity(Intent(requireContext(), SignIn::class.java))
            activity?.finish()

        }
        binding.chats2.setOnClickListener{
            startActivity(Intent(requireContext(),ChatActivity::class.java))
            activity?.finish()
        }

        var token111 = "Bearer $token1"

        request = Request.Builder()
            .url(url)
            .addHeader("Authorization", token111)
            .build()

        gson = Gson()


        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("tag", "onFailure: ")
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.code == 200){
                    requireActivity().runOnUiThread{
                        gsonBuilder(response.body!!.string())
                        binding.name.text = "$firstName $lastName"
                        binding.email.text = email

                    }
                }
                else{
                    requireActivity().runOnUiThread{
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

        return binding.root
    }

    private lateinit var userId: Array<User>

    private lateinit var arg: String
    private fun gsonBuilder(str: String) {
        userId = gson.fromJson(str, arrayOf<User>()::class.java)
        email = userId[0].email
        password = userId[0].password
        firstName = userId[0].firstName
        lastName = userId[0].lastName
    }
}