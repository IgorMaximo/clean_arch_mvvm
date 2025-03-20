package com.imcsrefactor.imcsmvvm.di

import com.tool.base.module.ModuleInitialization
import org.koin.core.module.Module

class AppInitialization : ModuleInitialization() {
    override fun init(): List<Module> = BasicModules.allModules
}
