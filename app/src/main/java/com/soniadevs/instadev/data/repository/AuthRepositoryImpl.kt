package com.soniadevs.instadev.data.repository

import android.util.Log
import com.soniadevs.instadev.data.datasource.api.ApiServices
import com.soniadevs.instadev.data.response.toDomain
import com.soniadevs.instadev.domain.entity.UserEntity
import com.soniadevs.instadev.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(val api: ApiServices) : AuthRepository {
    override suspend fun doLogin(user: String, password: String): List<UserEntity> {
        val response = try {
            api.doLogin()
        } catch (e: Exception) {
            Log.i("DOLOGIN ERROR", "$e")
            listOf()
        }

        return response.map { it.toDomain() }
    }
}
