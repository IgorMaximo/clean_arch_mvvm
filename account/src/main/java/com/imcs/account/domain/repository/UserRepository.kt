package com.imcsrefactor.imcsmvvm.domain.repository

import com.imcsrefactor.imcsmvvm.domain.entity.User

interface UserRepository {

    suspend fun fetchUser(): User

}