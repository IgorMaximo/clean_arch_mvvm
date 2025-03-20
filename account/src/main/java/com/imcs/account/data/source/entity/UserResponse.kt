package com.imcs.account.data.source.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    @Json(name = "enterprise") val enterprise: String,
    @Json(name = "is_adm") val isAdm: Boolean,
    @Json(name = "user") val user: String,
    @Json(name = "pass") val pass: String
): Parcelable
