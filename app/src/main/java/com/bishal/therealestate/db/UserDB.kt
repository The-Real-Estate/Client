package com.bishal.therealestate.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bishal.therealestate.Entity.Test
import com.bishal.therealestate.Entity.User
import com.bishal.therealestate.Entity.ArtistDetail
import com.bishal.therealestate.dao.UserDAO
import com.bishal.therealestate.dao.UsernameDAO

@Database(
    entities = [(User::class), (ArtistDetail::class),(Test::class)],
    version = 1,
    exportSchema = false
)
abstract class  UserDB : RoomDatabase() {
    abstract fun getStudentDAO(): UserDAO
    abstract fun getUserDAO(): UsernameDAO

    companion object {
        @Volatile
        private var instance: UserDB? = null

        fun getInstance(context: Context): UserDB {
            if (instance == null) {
                synchronized(UserDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "UserDB"
            ).build()
    }
}