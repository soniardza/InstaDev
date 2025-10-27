package com.soniadevs.instadev.domain.usecase

import com.soniadevs.instadev.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(user: String, password: String) {
        if (user.contains("@hotmail.com")) {
            return
        }

        val response = authRepository.doLogin(user, password)
    }
}
