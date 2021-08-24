package com.bishal.therealestate.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ArtistDetail (
    var username: String? = null,
    var password: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var address: String? = null,
    var phone: String? = null,
    var profession: String? = null,
    var photo: String? = null
        ){
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}