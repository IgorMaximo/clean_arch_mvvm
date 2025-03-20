package com.tool.base.shared.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.tool.base.R
import com.tool.base.utils.BaseBottomSheetDialogFragment
import org.koin.android.ext.android.inject

interface BaseLogin {
    fun showLoginFragment(fm: FragmentManager)
}

class LoginFragment : BaseBottomSheetDialogFragment(), BaseLogin {

    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.account_login_fragment, container, false)

    override fun showLoginFragment(fm: FragmentManager) = LoginFragment().show(fm, "showLoginFragment")
}
