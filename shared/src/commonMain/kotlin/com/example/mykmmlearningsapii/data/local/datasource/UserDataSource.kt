package com.example.mykmmlearningsapii.data.local.datasource

import com.example.mykmmlearnings.database.AccountDatabase
import com.example.mykmmlearnings.database.UserDataEntity
import com.example.mykmmlearnings.database.UserEntity


class UserDataSource(db:AccountDatabase) {

    private val userQueries = db.userQueries
    private val userDataQueries = db.userDataQueries

    suspend fun insertUser(userEntity: UserEntity){
        userQueries.insertUser(userEntity.localUserId, userEntity.name, userEntity.description)
    }

   suspend fun getAllUsers(): List<UserEntity> {
        return userQueries.getAllUser().executeAsList()
    }

  suspend  fun insertUserData(userEntity: UserDataEntity){
        userDataQueries.insertUserData(userEntity.localUserId, userEntity.name)
    }

   suspend fun getAllUsersData(): List<UserDataEntity> {
        return userDataQueries.getAllUserData().executeAsList()
    }
}