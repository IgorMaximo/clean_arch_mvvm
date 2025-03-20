package com.imcsrefactor.imcsmvvm.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val enterprise: String,
    val isAdm: Boolean,
    val user: String,
    val pass: String
) : Parcelable
