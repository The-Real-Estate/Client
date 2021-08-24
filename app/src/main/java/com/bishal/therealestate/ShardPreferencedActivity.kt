package com.bishal.therealestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ShardPreferencedActivity : AppCompatActivity() {
    private lateinit var btnPermission: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnGetValue: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shard_preferenced)


        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnPermission = findViewById(R.id.btnLogin)
        btnGetValue = findViewById(R.id.btnGetValue)

        btnPermission.setOnClickListener {
            saveSharedPref()

        }

        btnGetValue.setOnClickListener {
            getSharedPref()

        }
    }
    private fun saveSharedPref() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val sharedPref = getSharedPreferences("MyPref",
            MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
        Toast.makeText(
            this@ShardPreferencedActivity,
            "Username and password saved",
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun getSharedPref() {
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        Toast.makeText(this, "Username : $username and password : $password", Toast.LENGTH_SHORT)
            .show()
    }
}