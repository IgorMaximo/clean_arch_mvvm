package com.imcs.account.data.source.remote

import com.imcs.account.data.source.entity.UserResponse
import retrofit2.http.GET

interface UserAPI {

    @GET("/Desenvolvimento/bff_systorm/")
     suspend fun getUserCredentials(): UserResponse

}