package com.bishal.therealestate

import com.bishal.therealestate.model.User
import com.bishal.therealestate.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MyTest {
    private lateinit var userRepository :UserRepository
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("bishal", "bishal")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun registerUser() = runBlocking {
        val user =
            User(FullName = "test", Address = "test",PhoneNo = "123456", Username = "testuser", Password = "testpassword")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }


}