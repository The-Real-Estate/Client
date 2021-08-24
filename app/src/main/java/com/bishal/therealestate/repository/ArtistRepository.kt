package com.bishal.therealestate.repository

import com.bishal.therealestate.api.EstateAPI
import com.bishal.therealestate.api.MyApiRequest
import com.bishal.therealestate.api.ServiceBuilder
import com.bishal.therealestate.model.Estate
import com.bishal.therealestate.response.EstateResponse
import com.bishal.therealestate.response.ImageResponse
import okhttp3.MultipartBody

class  ArtistRepository: MyApiRequest() {
    private val ArtistAPI= ServiceBuilder.buildService(EstateAPI::class.java)
    suspend fun insertArtist(estate: Estate):EstateResponse{
        return apiRequest {
            ArtistAPI.insertEstate(ServiceBuilder.token!!, estate)
        }
    }

    suspend fun getAllArtist(): EstateResponse {
        return apiRequest {
            ArtistAPI.getAllEstate(ServiceBuilder.token!!)
        }
    }

    //    @DELETE("student/{id")
//    suspend fun deleteS
//
    suspend fun  uploadImage(id: String, body: MultipartBody.Part): ImageResponse {
        return apiRequest {
            ArtistAPI.uploadImage(ServiceBuilder.token!!,id,body)
        }
    }
}


