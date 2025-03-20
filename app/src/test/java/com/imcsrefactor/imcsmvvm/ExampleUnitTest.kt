package com.imcs.prospekt

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.imcsrefactor.imcsmvvm.domain.repository.UserRepository
import com.imcsrefactor.imcsmvvm.presentation.main.BaseViewModel
import com.imcs.account.presentation.feature.user.UserViewModel
import io.mockk.*
import io.reactivex.Single
import org.junit.Test
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
@RunWith(JUnit4::class)
class ExampleUnitTest : BaseViewModel() {

    private val userRepository = mockk<UserRepository>()
    private lateinit var viewModel: UserViewModel

    private fun instantiateViewModel() = UserViewModel(userRepository)

    @Before
    fun setup() {
        viewModel = instantiateViewModel()
    }

    @Test
    fun testGetAuth_Successfully() {
        val auth = viewModel.listAuth.test()
        val apiError = viewModel.apiError.test()
        every { userRepository.fetchUser() } returns Single.just(authResponse)

        viewModel.getAuthVM()

        verify { auth.onChanged(authResponse) }
        confirmVerified(auth, apiError)
    }


}

inline fun <reified T : Any> LiveData<T>.test(): Observer<T> {
    Assert.assertFalse(hasObservers())
    val observer = mockk<Observer<T>> { every { onChanged(any()) } just Runs }
    observeForever(observer)
    return observer
}
