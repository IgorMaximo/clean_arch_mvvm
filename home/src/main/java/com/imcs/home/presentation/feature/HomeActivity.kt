package com.imcs.home.presentation.feature

import android.os.Bundle
import android.widget.Button
import com.imcs.account.presentation.feature.user.UserViewModel
import com.imcs.home.R
import com.tool.base.utils.BaseActivity
import org.koin.core.component.KoinApiExtension
import org.koin.androidx.viewmodel.ext.android.viewModel

@KoinApiExtension
class HomeActivity : BaseActivity() {

    private val viewModel: UserViewModel by viewModel()

    private val testebtn: Button by lazy { findViewById(R.id.testebtn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupViewModel()
    }

    private fun setupViewModel() {
        with(viewModel) {

            getAuthVM()

            listAuth.observe(this@HomeActivity) {
                println("=listAuth=================> " + it.enterprise.toString())
                println("=listAuth=================> " + it.isAdm.toString())
                println("=listAuth=================> " + it.user.toString())
                println("=listAuth=================> " + it.pass.toString())

            }
            apiError.observe(this@HomeActivity) {
                println("=apiError=================> " + it.toString())
            }
        }

        testebtn.setOnClickListener {
            showLoginFragment(supportFragmentManager)
        }
    }
}
