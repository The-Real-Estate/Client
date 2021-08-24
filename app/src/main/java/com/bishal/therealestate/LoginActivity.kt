package com.bishal.therealestate

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import com.bishal.therealestate.api.ServiceBuilder
import com.bishal.therealestate.repository.UserRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignup: Button
    private lateinit var linearlayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        linearlayout = findViewById(R.id.linearlayout)
        val intent = intent.extras
        if (intent != null) {
            val err = intent.getString("msg")
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
        }
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        getSharedPref()
        binding()

        btnLogin.setOnClickListener {
//            login()
            saveSharedPref()


        }
        btnSignup.setOnClickListener {
            val it = Intent(this, SignupActivity::class.java)
            startActivity(it)
        }
    }

    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()
        }
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        CoroutineScope(Dispatchers.IO).launch{
//            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    // dashboard khola

                    ServiceBuilder.token = "Bearer ${response.token}"
                    startActivity(
                        Intent(
                            this@LoginActivity,
                            DashboardActivity::class.java
                        )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(
                                linearlayout,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                            )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }

//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        this@LoginActivity,
//                        ex.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//            }
        }
    }

    private fun binding() {
        etPassword = findViewById(R.id.etPassword)
        etUsername = findViewById(R.id.etUsername)
        btnSignup = findViewById(R.id.btnSignup)
        btnLogin = findViewById(R.id.btnLogin)


    }

    private fun saveSharedPref() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val sharedPref = getSharedPreferences(
            "LoginPreferences",
            MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("password", password)
//        editor.putString("token", token)
        editor.apply()
        editor.commit()
        Toast.makeText(
            this@LoginActivity,
            "Login Success !!",
            Toast.LENGTH_SHORT
        ).show()

    }

    private fun getSharedPref() {
        val sharedPref = getSharedPreferences("LoginPreferences", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        etUsername.setText("$username")
        etPassword.setText("$password")
    }


}