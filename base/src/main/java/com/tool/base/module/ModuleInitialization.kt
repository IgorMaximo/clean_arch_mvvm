package com.tool.base.module

import android.content.ContentProvider
import android.content.ContentValues
import android.net.Uri
import org.koin.core.module.Module

abstract class ModuleInitialization : ContentProvider() {

    abstract fun init(): List<Module>
    
    override fun onCreate(): Boolean {
        ModuleInitializer.add(init())
        return true
    }

    override fun query(p0: Uri, p1: Array<out String>?, p2: String?, p3: Array<out String>?, p4: String?) = null

    override fun getType(p0: Uri) = null

    override fun insert(p0: Uri, p1: ContentValues?) = null

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?) = 0

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?) = 0
}
