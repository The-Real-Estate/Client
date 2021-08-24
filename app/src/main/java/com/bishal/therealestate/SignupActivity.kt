package com.bishal.therealestate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.bishal.therealestate.model.User
import com.bishal.therealestate.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


class SignupActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etPhone: EditText
    private lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnLogin: Button
    private var storage = Storage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        binding()

//        adapterInit()
        btnSubmit.setOnClickListener {
            if (validateInput()) {
                val user = User(
                    FullName = etName.text.toString(),
                    Address = etAddress.text.toString(),
                    PhoneNo = etPhone.text.toString(),
                    Username = etUser.text.toString(),
                    Password = etPass.text.toString()
                )

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.registerUser(user)

                        //yadi success bhayo vane toast dekhkaune
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@SignupActivity,
                                    "Register vayo hai",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@SignupActivity, "submit vako xaina hai",Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

            } else {
                Toast.makeText(this, "Invalid Signup", Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val intent = Intent(
                this, LoginActivity::class.java
            )
            startActivity(intent)
        }
    }

    private fun validateInput(): Boolean {
        var res: Boolean = true
        when {
            TextUtils.isEmpty(etName.text) -> {
                etName.error = "This field should not be empty"
                etName.requestFocus()
                res = false
            }

            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "This field should not be empty"
                etAddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etPhone.text) -> {
                etPhone.error = "This field should not be empty"
                etAddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etUser.text) -> {
                etUser.error = "This field should not be empty"
                etUser.requestFocus()
                res = false
            }
            storage.hasUsername(etUser.text.toString()) != null -> {
                etUser.error = "Username already taken"
                etUser.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etPass.text) -> {
                etPass.error = "This field should not be empty"
                etPass.requestFocus()
                res = false
            }
        }

        return res

    }

              private fun binding() {
                etName = findViewById(R.id.etName)
                etAddress = findViewById(R.id.etAdress)
                etPhone = findViewById(R.id.etPhone)
                etPass = findViewById(R.id.etPass)
                etUser = findViewById(R.id.etUser)
                btnSubmit = findViewById(R.id.btnSubmit)
                btnLogin = findViewById(R.id.btnLogin)

            }


        }
