package com.bishal.therealestate

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class HireArtist : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPrice: EditText
//    private lateinit var etTophone: EditText
    private lateinit var btnSend : Button
    private lateinit var btnCancel : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hire_artist)
        etName=findViewById(R.id.etName)
        etPhone=findViewById(R.id.etPhone)
        etPrice=findViewById(R.id.etPrice)
//        etTophone=findViewById(R.id.etTophone)
        btnSend=findViewById(R.id.btnSend)
        btnCancel=findViewById(R.id.btnCancel)
        btnSend.setOnClickListener{
            startActivity(Intent(this@HireArtist,DashboardActivity::class.java))
            Toast.makeText(this@HireArtist," Request Send to Owner!!", Toast.LENGTH_SHORT).show()
//            showLowPriotyNotification()
            showHighPriorityNotification()

        }

        btnCancel.setOnClickListener{
            startActivity(Intent(this@HireArtist,DashboardActivity::class.java))
        }
    }
    private fun showLowPriotyNotification() {
        val notificationManager= NotificationManagerCompat.from(this@HireArtist)

        val notificationChannels= Notification(this@HireArtist)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this@HireArtist, notificationChannels.CHANNEL_2)
                 .setContentTitle("Low Priority notification")
            .setContentText("This is my notification Body")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(2,notification)

    }

    private fun showHighPriorityNotification() {
        val notificationManager= NotificationManagerCompat.from(this)

        val notificationChannels= Notification(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.ic_notifications_black_24dp)
            .setContentTitle("Bishal Budha Wants To Offer Your Property")
            .setContentText("Bishal Budha Wants To Offer Your Property")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(1,notification)

    }
}