package io.realworld.conduit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realworld.api.models.entities.User
import io.realworld.conduit.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel:ViewModel() {

    private val _user = MutableLiveData<User?>()

    val user : LiveData<User?> = _user


    fun login(email:String,password:String) = viewModelScope.launch {
        UserRepo.login(email,password)?.let {
            _user.postValue(it)
        }
    }

    fun signup(username:String,email:String,password: String) = viewModelScope.launch {
        UserRepo.signup(username,email,password)?.let {
            _user.postValue(it)
        }
    }
}