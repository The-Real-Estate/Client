package com.bishal.therealestate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateProfile : AppCompatActivity() {
    private lateinit var etFullname: EditText
    private lateinit var etAddress: EditText
    private lateinit var etPhone: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnUpdate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        etFullname=findViewById(R.id.etFullname)
        etPhone=findViewById(R.id.etPhone)
        etAddress=findViewById(R.id.etAddress)
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        btnUpdate=findViewById(R.id.btnUpdate)

        btnUpdate.setOnClickListener{
            startActivity(Intent(this@UpdateProfile,DashboardActivity::class.java))
            Toast.makeText(
                this@UpdateProfile,
                "User Updated Successfully !!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}