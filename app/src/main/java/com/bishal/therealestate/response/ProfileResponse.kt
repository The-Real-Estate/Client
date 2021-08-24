package com.bishal.therealestate.response

import com.bishal.therealestate.model.User

data class ProfileResponse(
    val success : Boolean?=null,
    val user : User?=null,
    val token :String?=null
)