package com.imcsrefactor.imcsmvvm.di

import com.imcs.account.presentation.feature.user.UserViewModel
import com.imcsrefactor.imcsmvvm.data.mapper.UserMapperImpl
import com.imcs.account.data.repository.UserRepositoryImpl
import com.imcs.account.data.source.remote.UserAPI
import com.imcsrefactor.imcsmvvm.domain.repository.UserRepository
import com.tool.base.retrofit.RetrofitServiceConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object BasicModules {

    private val apiInterfaces = module {
        single { RetrofitServiceConfig.createService(UserAPI::class.java) }
    }

    private val modules = module {
        single<UserRepository> { UserRepositoryImpl(get(), get()) }
        single { UserMapperImpl() }
    }

    private val viewModelModules = module {
        viewModel { UserViewModel(get()) }
    }

    internal val allModules = listOf(
        viewModelModules,
        apiInterfaces,
        modules
    )
}
