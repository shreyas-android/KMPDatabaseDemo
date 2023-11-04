package com.example.mykmmlearningsapii.data.local

import android.content.Context
import com.example.mykmmlearnings.database.AccountDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AccountDatabase.Schema, context, "android_account.db")
    }
}