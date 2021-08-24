package com.bishal.therealestate.Entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    var fullName: String? = null,
    var age: Int? = null,
    var gender: String? = null,
    var address: String? = null,
    var phone: String? = null,
    var profession: String? = null,
    var Username: String? = null,
    var Password: String? = null,
    var image_url: String? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = false)
    var _id: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
        _id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeValue(age)
        parcel.writeString(gender)
        parcel.writeString(address)
        parcel.writeString(phone)
        parcel.writeString(profession)
        parcel.writeString(image_url)
        parcel.writeInt(_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}