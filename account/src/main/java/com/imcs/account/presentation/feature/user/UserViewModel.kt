package com.imcs.account.presentation.feature.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.imcsrefactor.imcsmvvm.domain.entity.User
import com.imcsrefactor.imcsmvvm.domain.repository.UserRepository
import com.tool.base.utils.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class UserViewModel(private val userRepository: UserRepository) : BaseViewModel() {

    private val _listAuth = MutableLiveData<User>()
    val listAuth: LiveData<User> = _listAuth

    fun getAuthVM() {
        GlobalScope.launch {
            _listAuth.postValue(userRepository.fetchUser())
        }
    }
}
