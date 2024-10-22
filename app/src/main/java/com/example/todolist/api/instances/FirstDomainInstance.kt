package com.example.todolist.api.instances

import com.example.todolist.api.services.Lisn2MeServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FirstDomainInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/") // Base URL of your local server
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: Lisn2MeServices by lazy {
        retrofit.create(Lisn2MeServices::class.java)
    }
}
