package com.jenish.week6assignment1.models

import android.os.Parcel
import android.os.Parcelable

data class Students (
        val imgUrl : String? = null,
        val studentName : String ? = null,
        val age : Int? = null,
        val address : String? = null,
        val gender : String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imgUrl)
        parcel.writeString(studentName)
        parcel.writeValue(age)
        parcel.writeString(address)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Students> {
        override fun createFromParcel(parcel: Parcel): Students {
            return Students(parcel)
        }

        override fun newArray(size: Int): Array<Students?> {
            return arrayOfNulls(size)
        }
    }
}
