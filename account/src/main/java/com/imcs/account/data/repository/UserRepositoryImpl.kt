package com.imcs.account.data.repository

import com.imcs.account.data.source.remote.UserAPI
import com.imcsrefactor.imcsmvvm.domain.repository.UserRepository
import com.imcsrefactor.imcsmvvm.data.mapper.UserMapperImpl
import com.imcsrefactor.imcsmvvm.domain.entity.User

class UserRepositoryImpl(
    private val userAPI: UserAPI,
    private val mapperUser: UserMapperImpl
    ) : UserRepository {

    override suspend fun fetchUser(): User {
        return userAPI.getUserCredentials().let { mapperUser.toDomain(it) }
    }

}