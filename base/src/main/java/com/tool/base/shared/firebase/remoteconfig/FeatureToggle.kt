package com.tool.base.shared.firebase.remoteconfig

interface FeatureToggle {
    fun getString(key: String): String
    fun getInt(key: String): Int
    fun getBoolean(key: String): Boolean
    fun getJson(key: String)
}
