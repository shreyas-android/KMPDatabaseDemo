package com.notes.android.mypersonalcalendarkmm.data.local

import com.example.android.mypersonalcalendarkmm.database.CalendarDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AccountDatabase.Schema, "ios_account.db")
    }
}