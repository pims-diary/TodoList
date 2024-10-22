package com.example.todolist.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.api.instances.FirstDomainInstance
import com.example.todolist.data.User
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserViewModel : ViewModel() {

    var users by mutableStateOf<List<User>>(emptyList())
    var errorMessage by mutableStateOf("")

    fun getUsers() {
        viewModelScope.launch {
            try {
                val response = FirstDomainInstance.api.getUsers()
                if (response.isSuccessful) {
                    users = response.body() ?: emptyList()
                } else {
                    errorMessage = "Error: ${response.code()}"
                }
            } catch (e: IOException) {
                errorMessage = "Network Error: ${e.message}"
            } catch (e: HttpException) {
                errorMessage = "HTTP Error: ${e.message}"
            }
        }
    }
}
