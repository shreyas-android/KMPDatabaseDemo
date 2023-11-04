package kotlin.com.example.mykmmlearnings

import android.app.Application

internal actual fun testDBConnection(): SqlDriver {
    // Try to use the android driver (which only works if we're on robolectric).
    // Fall back to jdbc if that fails.
    return try {
        val app = ApplicationProvider.getApplicationContext<Application>()
        AndroidSqliteDriver(AccountDatabase.Schema, app, "personal")
    } catch (exception: IllegalStateException) {
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            .also { AccountDatabase.Schema.create(it) }
    }
}