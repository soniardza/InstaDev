package com.soniadevs.instadev.data.datasource.api

import com.soniadevs.instadev.data.response.UserResponse
import retrofit2.http.GET

interface ApiServices {

    @GET("doLogin/.json")
    suspend fun doLogin(): List<UserResponse>
}
