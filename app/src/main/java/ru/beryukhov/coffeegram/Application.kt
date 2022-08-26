package ru.beryukhov.coffeegram

import android.app.Application

@Suppress("unused")
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        initDbContext(this)
    }
}
