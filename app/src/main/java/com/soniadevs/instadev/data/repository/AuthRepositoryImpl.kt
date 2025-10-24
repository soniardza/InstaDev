package com.soniadevs.instadev.data.repository

import com.soniadevs.instadev.data.response.UserResponse
import com.soniadevs.instadev.data.response.toDomain
import com.soniadevs.instadev.domain.entity.UserEntity
import com.soniadevs.instadev.domain.repository.AuthRepository

class AuthRepositoryImpl() : AuthRepository {
    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse = UserResponse(
            "",
            "",
            "",
            10,
            listOf(""),
            0
        )

        return userResponse.toDomain()
    }
}
