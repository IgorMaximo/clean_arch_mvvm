package com.tool.base.di

import com.tool.base.shared.login.BaseLogin
import com.tool.base.shared.login.LoginFragment
import com.tool.base.module.ModuleInitialization
import com.tool.base.shared.firebase.remoteconfig.FeatureToggle
import com.tool.base.shared.firebase.remoteconfig.FeatureToggleImpl
import com.tool.base.shared.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class BaseInitialization : ModuleInitialization() {

    override fun init() = listOf(
        module {

            viewModel { LoginViewModel() }

            single { FeatureToggleImpl() }
            single<FeatureToggle> { FeatureToggleImpl() }
            single { LoginFragment() }
            single<BaseLogin> { LoginFragment() }
        }
    )
}
