package com.bishal.realestatewearos

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {
   

    //Login

    @FormUrlEncoded
    @POST("user/login")
    suspend fun  checkUser(
        @Field("Username") username :String,
        @Field("Password") password :String

    ): Response<Loginresponse>


}