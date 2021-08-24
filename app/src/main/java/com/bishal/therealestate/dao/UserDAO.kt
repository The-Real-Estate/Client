package com.bishal.therealestate.dao

import androidx.room.*
import com.bishal.therealestate.Entity.User

@Dao

interface UserDAO {
    @Insert
    suspend fun insertStudent(student : User)

    @Query("SELECT * FROM User")
    suspend fun getAllStudents() : List<User>

    @Update
    suspend fun updateStudent(student : User)

    @Delete
    suspend fun DeleteStudent(student : User)
}