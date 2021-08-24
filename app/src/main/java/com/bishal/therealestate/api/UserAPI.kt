package com.bishal.therealestate.api

import com.bishal.therealestate.model.User
import com.bishal.therealestate.response.Loginresponse
import com.bishal.therealestate.response.ProfileResponse
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {
    //register User
    @POST("user/post")
    suspend fun registerUser(
        @Body user: User
    ): Response<Loginresponse>

    //Login

    @FormUrlEncoded
    @POST("user/login")
    suspend fun  checkUser(
        @Field("Username") username :String,
        @Field("Password") password :String

    ): Response<Loginresponse>

    @GET("user/show")
    suspend fun getUserProfile(
        @Header("Authorization") token: String
    ): Response<ProfileResponse>

    @FormUrlEncoded
    @PUT("user/update/")
    suspend fun updateProfile(
        @Header("Authorization") token: String,
        @Field("_id") id: String,
        @Field("Fullname") Fullname: String,
        @Field("Address") Address: String,
        @Field("PhoneNo") PhoneNo: String,
        @Field("Username") Username: String,
        @Field("Password") Password: String
    ): Response<ProfileResponse>
}