package io.realworld.conduit.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.responses.UserResponse

object UserRepo {
    val api = ConduitClient.publicApi

    suspend fun login(email:String,password:String): UserResponse? {
        val response = api.loginUser(LoginRequest(LoginData(email,password)))
        return response.body()
    }

}