package com.imcsrefactor.imcsmvvm.di

import androidx.lifecycle.LifecycleObserver
import com.tool.base.module.ModuleInitializer
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import androidx.multidex.MultiDexApplication

open class CustomApp: MultiDexApplication(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            // Android context
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@CustomApp)
            androidFileProperties()
            ModuleInitializer.add(BasicModules.allModules)
            // init modules
            modules(ModuleInitializer.modules)
        }
    }
}
