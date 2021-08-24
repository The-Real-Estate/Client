package com.bishal.therealestate.response

import com.bishal.therealestate.model.Estate

class AddUserResponse (
    val success :Boolean? =null,
    val data : MutableList<Estate>? =null
)