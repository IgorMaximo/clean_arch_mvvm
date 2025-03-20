package com.tool.base.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.tool.base.shared.login.LoginFragment
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity() {

    private val login: LoginFragment by inject()

    fun showLoginFragment(supportFragmentManager: FragmentManager) =
        login.showLoginFragment(supportFragmentManager)
}
