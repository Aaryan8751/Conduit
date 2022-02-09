package io.realworld.conduit.data

import android.util.Log
import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.entities.SignupData
import io.realworld.api.models.entities.User
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.responses.UserResponse

object UserRepo {
    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi


    suspend fun login(email:String,password:String): User? {
        val response = api.loginUser(LoginRequest(LoginData(email,password)))

        // TODO : Save it in sharedPreferences
        ConduitClient.authToken = response.body()?.user?.token
        Log.e("USER",ConduitClient.authToken.toString())
        return response.body()?.user
    }

    suspend fun signup(username:String,email:String,password: String) : User?{
        val response = api.signupUser(SignupRequest(SignupData(email,password,username)))

        // TODO : Save it in sharedPreferences
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user

    }

    suspend fun getUserProfile() = authApi.getCurrentUser().body()


}