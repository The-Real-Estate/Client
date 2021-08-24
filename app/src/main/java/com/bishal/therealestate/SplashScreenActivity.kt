package com.bishal.therealestate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bishal.therealestate.api.ServiceBuilder
import com.bishal.therealestate.repository.UserRepository
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            login()
            finish()
        }
    }
    private suspend fun login(){
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username","")
        val password = sharedPref.getString("password","")
        if (username != "" && password !=""){
            withContext(Dispatchers.IO){
                try{
                    val repository= UserRepository()
                    val response=repository.checkUser(username!!,password!!)
                    if(response.success==true){
                        ServiceBuilder.token ="Bearer ${response.token}"
                        startActivity(Intent(
                            this@SplashScreenActivity,LoginActivity::class.java
                        ))
                    }else{
                        startActivity(Intent(
                            this@SplashScreenActivity,LoginActivity::class.java
                        ))
                    }
                }catch(ex : Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@SplashScreenActivity, ex.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }
        } else{
            startActivity(
                Intent(
                    this, LoginActivity::class.java
                )
            )
        }
    }

}