package com.bishal.therealestate.repository

import com.bishal.therealestate.model.User
import com.bishal.therealestate.api.MyApiRequest
import com.bishal.therealestate.api.ServiceBuilder
import com.bishal.therealestate.api.UserAPI
import com.bishal.therealestate.response.Loginresponse
import com.bishal.therealestate.response.ProfileResponse

class UserRepository: MyApiRequest() {
    //Create retrofit instance of USERAPI
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //register user
    suspend fun registerUser(user: User): Loginresponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }
    //login uer
    suspend fun checkUser(Username:String,Password:String):Loginresponse{
        return apiRequest {
            userAPI.checkUser(Username,Password)
        }
    }

    suspend fun updateProfile(token:String,id:String,Fullname:String,Address:String,PhoneNo:String,Username:String,Password:String):ProfileResponse{
        return apiRequest {
            userAPI.updateProfile(token,id,Fullname,Address,PhoneNo,Username,Password)
        }
    }
    suspend fun getProfile(token:String):ProfileResponse{
        return apiRequest {
            userAPI.getUserProfile(token)
        }
    }
}