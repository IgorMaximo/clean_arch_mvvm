package com.tool.base.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tool.base.shared.firebase.remoteconfig.FeatureToggle
import com.tool.base.shared.firebase.remoteconfig.RemoteConfigKeys
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
abstract class BaseViewModel : ViewModel(), KoinComponent {

    protected val featureToggle: FeatureToggle by inject()

    val _apiError = MutableLiveData<Throwable>()

    val apiError: LiveData<Throwable>
        get() = _apiError

    fun isPushNotificationEnabled() =
        featureToggle.getBoolean(RemoteConfigKeys.PUSH_NOTIFICATION_ENABLED)
}