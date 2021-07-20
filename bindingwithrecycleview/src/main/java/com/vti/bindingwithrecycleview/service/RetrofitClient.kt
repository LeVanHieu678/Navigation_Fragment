package com.vti.bindingwithrecycleview.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://reqres.in/api/"
    private var retrofit: Retrofit? = null
    fun getService(): EmployeeService? {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit?.create(EmployeeService::class.java)
    }


}