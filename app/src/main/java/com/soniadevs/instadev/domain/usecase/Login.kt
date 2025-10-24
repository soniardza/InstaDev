package com.soniadevs.instadev.domain.usecase

import com.soniadevs.instadev.domain.repository.AuthRepository

class Login(
    private val authRepository: AuthRepository
) {
    operator fun invoke(user: String, password: String) {
        if (user.contains("@hotmail.com")) {
            return
        }

        val response = authRepository.doLogin(user, password)
    }
}
