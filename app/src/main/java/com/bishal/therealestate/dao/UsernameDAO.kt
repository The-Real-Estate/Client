package com.bishal.therealestate.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bishal.therealestate.Entity.User

@Dao
interface UsernameDAO {
    @Insert
    suspend fun registerUser(user: User)

    @Query("select * from User where Username=(:Username) and Password=(:Password)")
    suspend fun checkUser(Username: String, Password: String): User
}