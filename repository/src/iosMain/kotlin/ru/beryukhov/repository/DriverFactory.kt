package ru.beryukhov.repository

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

internal actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CoffeeDb.Schema, "test.db")
    }
}
