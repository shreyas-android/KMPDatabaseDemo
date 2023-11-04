package com.example.mykmmlearnings

import com.example.mykmmlearnings.database.AccountDatabase
import com.example.mykmmlearnings.database.UserEntity
import com.example.mykmmlearningsapii.data.local.datasource.UserDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class CommonDatabaseTest {

    lateinit var userDataSource: UserDataSource

    @BeforeTest
    fun setUp() =  runTest {
    val accountDatabase = AccountDatabase(testDBConnection())
        userDataSource = UserDataSource(accountDatabase)
    }

    @Test
    fun test_select_all_user() = runTest {
        userDataSource.insertUser(getDummyUserEntity(1L))
        userDataSource.insertUser(getDummyUserEntity(1L))

        assertEquals(1, userDataSource.getAllUsers().size)

        userDataSource.insertUser(getDummyUserEntity(2L))

        assertEquals(2, userDataSource.getAllUsers().size)
    }

    private fun getDummyUserEntity(localUserId:Long) = UserEntity(localUserId,"",
        "")
}