package com.example.todolist.api.services

import com.example.todolist.data.User
import retrofit2.Response
import retrofit2.http.GET

interface Lisn2MeServices {
    @GET("/get-users")
    suspend fun getUsers(): Response<List<User>>
}
