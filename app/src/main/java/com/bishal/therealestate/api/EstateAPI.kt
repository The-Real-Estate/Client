package com.bishal.therealestate.api

import com.bishal.therealestate.model.Estate
import com.bishal.therealestate.response.EstateResponse
import com.bishal.therealestate.response.ImageResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface EstateAPI {
    @POST("estate/post")
    suspend fun insertEstate(
        @Header("Authorization") token:String,
        @Body estate: Estate
    ): Response<EstateResponse>

    @GET("estate/show")
    suspend fun getAllEstate(
        @Header("Authorization") token:String
    ): Response<EstateResponse>

    @Multipart
    @PUT("estate/{id}/photo")
    suspend fun uploadImage(
//        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: String,
        body: MultipartBody.Part
    ): Response<ImageResponse>

}



