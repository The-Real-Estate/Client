package com.bishal.realestatewearos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var linearlayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        etPassword = findViewById(R.id.etPassword)
        etUsername = findViewById(R.id.etUsername)
        btnLogin = findViewById(R.id.btnLogin)
        linearlayout = findViewById(R.id.linearlayout)
        val intent = intent.extras
        if (intent != null) {
            val err = intent.getString("msg")
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
        }
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)


        btnLogin.setOnClickListener {
            login()

        }
    }
    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
//            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    // dashboard khola

                    ServiceBuilder.token ="Bearer ${response.token}"
                    startActivity(
                        Intent(
                            this@MainActivity2,
                            Login::class.java
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
//                        this@MainActivity2,
//                        ex.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//            }
        }
    }

}