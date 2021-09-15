package ru.beryukhov.repository

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory() {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): CoffeeDb  {
    val driver = driverFactory.createDriver()
    val database = CoffeeDb(driver)

    // Do more work with the database (see below).

    return database
}
