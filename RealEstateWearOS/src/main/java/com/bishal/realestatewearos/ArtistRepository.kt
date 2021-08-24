package com.bishal.realestatewearos

import okhttp3.MultipartBody

class  ArtistRepository: MyApiRequest() {
    private val ArtistAPI= ServiceBuilder.buildService(EstateAPI::class.java)
    suspend fun insertArtist(estate: Estate): EstateResponse {
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