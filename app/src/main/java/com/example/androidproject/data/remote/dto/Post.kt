package com.example.androidproject.data.remote.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val image: String
): Parcelable

