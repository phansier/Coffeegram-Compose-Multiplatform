package ru.beryukhov.repository

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

lateinit var context: Context // todo fill it

internal actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CoffeeDb.Schema, context, "test.db")
    }
}
