package com.example.worldcinematest

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import com.example.worldcinematest.data.Login
import com.example.worldcinematest.data.Register
import com.example.worldcinematest.databinding.ActivitySignUpBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import android.text.TextUtils
import android.util.Patterns


class SignUp : AppCompatActivity() {
    private lateinit var request: Request
    private var client = OkHttpClient()
    private lateinit var formBody: FormBody
    private lateinit var gson: Gson
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var url = "http://cinema.areas.su/auth/register"

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.buttonSignIn.setOnClickListener{
            startActivity(Intent(this, SignIn::class.java))
            finish()
        }
        binding.buttonRegister1.setOnClickListener {
            var email = binding.editTextEmail.text.toString()
            var password = binding.editTextPassword.text.toString()
            var firstName = binding.editTextName.text.toString()
            var lastName = binding.editTextSurname.text.toString()
            var emailvalidation = Regex("[a-z0-9._%-]@[a-z0-9]+\\.[a-z]{1,3}$").find(email)
            if(binding.editTextPassword.text == null || binding.editTextPassword2.text == null || binding.editTextEmail.text == null || binding.editTextName.text == null || binding.editTextSurname.text == null){
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else{
                if (emailvalidation == null){
                    binding.editTextEmail.setError("Некорректный Email")

                }
                if(binding.editTextPassword.text != binding.editTextPassword2.text){
                    binding.editTextPassword.setError("Пароли не совпадают")
                    binding.editTextPassword2.setError("Пароли не совпадают")
                }
            }




            formBody = FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .build()

            request = Request.Builder()
                .url(url)
                .post(formBody)
                .build()

            gson = Gson()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.i("tag", "onFailure: ")
                }

                override fun onResponse(call: Call, response: Response) {
                    //Log.i("tag", "onResponse: ${response.body!!.string()}")
                    if(response.code == 201){
                        runOnUiThread{
                            Toast.makeText(this@SignUp, "Успешная регистрация}", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        runOnUiThread{
                            Toast.makeText(this@SignUp, "Неуспешная регистрация", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

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




    }
    private lateinit var token: Register
    fun gsonBuilder(str: String){
        token = gson.fromJson(str, Register::class.java)
        Log.i("tag", "gsonBuilder: ${token.token1}")
    }

}