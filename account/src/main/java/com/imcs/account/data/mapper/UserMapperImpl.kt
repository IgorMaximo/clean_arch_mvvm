package com.imcsrefactor.imcsmvvm.data.mapper

import com.imcs.account.data.source.entity.UserResponse
import com.imcsrefactor.imcsmvvm.domain.entity.User

class UserMapperImpl : DomainMapper<UserResponse, User> {

    override fun toDomain(from: UserResponse) = User(
        enterprise = from.enterprise,
        isAdm = from.isAdm,
        user = from.user,
        pass = from.pass
    )
}
