package com.bishal.therealestate

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class Notification(val context: Context) {
    val CHANNEL_1 :String ="Channel1"
    val CHANNEL_2 :String ="Channel2"

    fun createNotificationChannels(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val Channel1= NotificationChannel(
                CHANNEL_1,"Channel1",
                NotificationManager.IMPORTANCE_HIGH
            )
            Channel1.description= "This is channel 1"

            val Channel2= NotificationChannel(
                CHANNEL_2,"Channel2",
                NotificationManager.IMPORTANCE_LOW
            )
            Channel1.description= "This is channel 2"

            val notificationManager= context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(Channel1)
            notificationManager.createNotificationChannel(Channel2)


        }
    }
}