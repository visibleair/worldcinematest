package com.example.worldcinematest

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast

import com.example.worldcinematest.Common.Global.Companion.token1
import com.example.worldcinematest.data.Login
import com.example.worldcinematest.databinding.ActivitySignInBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.text.Normalizer

class SignIn : AppCompatActivity() {


    private lateinit var request: Request
    private var client = OkHttpClient()
    private lateinit var formBody: FormBody
    private lateinit var gson: Gson
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var url = "http://cinema.areas.su/auth/login"

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.buttonRegister.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
        }
        binding.buttonSignIn.setOnClickListener{
            var email = binding.editTextEmail.text.toString()
            var emailvalidation = Regex("[a-z0-9]@[a-z0-9]+\\.[a-z]{1,3}$").find(email)
            //Toast.makeText(this, "$emailvalidation", Toast.LENGTH_SHORT).show()
            if (emailvalidation != null){
                //binding.editTextEmail.setError("Email некорректен")
            }
            else{
                binding.editTextEmail.setError("Email некорректен")
            }
            var password = binding.editTextPassword.text.toString()
            var token111 = "Bearer 278203"
            formBody = FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build()

            request = Request.Builder()
                .url(url)
                .post(formBody)
                .build()

            gson = Gson()


            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.i("tag", "onFailure: ")
                }

                override fun onResponse(call: Call, response: Response) {
                    //Log.i("tag", "onResponse: ${gsonBuilder(response.body!!.string())}")
                    if(response.code == 200){
                        runOnUiThread{
                            gsonBuilder(response.body!!.string())
                        }
                        startActivity(Intent(this@SignIn, MainActivity::class.java))
                        finish()
                    }
                    else{
                        runOnUiThread{
                            Toast.makeText(this@SignIn, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }



                }
            })


        }

//        private fun validemail(emailtext: String){
//            var emailtext = binding.editTextEmail.text.toString()
//            if(emailtext.isNotEmpty() && emailtext.contains("@")){
//                Toast.makeText(this, "успешно", Toast.LENGTH_SHORT).show()
//            })
//            else
//            {
//                binding.editTextEmail.setError()
//            }
//        }

    }
    private lateinit var token : Login
    fun gsonBuilder(str: String){
        token = gson.fromJson(str, Login::class.java)
        token1 = token.token
        Toast.makeText(this, "token: ${token.token}", Toast.LENGTH_SHORT).show()
    }


}