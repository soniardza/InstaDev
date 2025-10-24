package com.soniadevs.instadev.data.response

import com.soniadevs.instadev.domain.entity.UserEntity
import com.soniadevs.instadev.domain.entity.UserMode.COMPANY_USER
import com.soniadevs.instadev.domain.entity.UserMode.CONTENT_CREATOR_USER
import com.soniadevs.instadev.domain.entity.UserMode.REGULAR_USER

data class UserResponse(
    val userId: String,
    val name: String,
    val nickname: String,
    val followers: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {
    val userMode = when (userType) {
        REGULAR_USER.userType -> REGULAR_USER
        CONTENT_CREATOR_USER.userType -> CONTENT_CREATOR_USER
        COMPANY_USER.userType -> COMPANY_USER
        else -> REGULAR_USER
    }

    return UserEntity(
        userId = userId,
        name = name,
        nickname = nickname,
        followers = followers,
        following = following,
        userMode = userMode
    )
}
