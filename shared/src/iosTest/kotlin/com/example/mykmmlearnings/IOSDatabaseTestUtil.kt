package kotlin.com.example.mykmmlearnings


internal actual fun testDBConnection(): SqlDriver {
    val schema = AccountDatabase.Schema
    return NativeSqlDriver(
        DatabaseConfiguration(
            name = "personal",
            version = schema.version,
            create = { connection ->
                wrapConnection(connection) { schema.create(it) }
            },
            upgrade = { connection, oldVersion, newVersion ->
                wrapConnection(connection) { schema.migrate(it, oldVersion, newVersion) }
            },
            inMemory = true
        )
    )
}