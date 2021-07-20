package com.vti.bindingwithrecycleview.service

import com.vti.bindingwithrecycleview.model.EmployeeResponse
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService {
    @GET("users/?per_page=12&page=1")
    fun getAllEmployee() : Call<EmployeeResponse>
}