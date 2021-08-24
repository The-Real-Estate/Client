package com.bishal.realestatewearos

class UserRepository: MyApiRequest() {
    //Create retrofit instance of USERAPI
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //login uer
    suspend fun checkUser(username:String,password:String): Loginresponse {
        return apiRequest {
            userAPI.checkUser(username,password)
        }
    }



}