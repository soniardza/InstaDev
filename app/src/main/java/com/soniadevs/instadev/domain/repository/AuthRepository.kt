package com.soniadevs.instadev.domain.repository

import com.soniadevs.instadev.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user: String, password: String): UserEntity
}
