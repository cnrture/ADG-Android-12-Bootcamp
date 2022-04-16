package com.canerture.ad12bootcampconnecttotheinternet.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterModel(
    val id: Int,
    val name: String,
    @Json(name = "image_url") val imageUrl: String,
    val house: String
): Parcelable