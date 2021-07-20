package com.vti.bindingwithrecycleview.repo

import android.content.Context
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.vti.bindingwithrecycleview.model.Employee
import com.vti.bindingwithrecycleview.model.EmployeeResponse
import com.vti.bindingwithrecycleview.service.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class EmployeeRepo {
    private var employees = mutableListOf<Employee>()
    private var ldEmployees = MutableLiveData(mutableListOf<Employee>())

    fun getEmployeeService() : MutableLiveData<MutableList<Employee>>{
        val userDataService = RetrofitClient.getService()
        val call = userDataService?.getAllEmployee()
        call?.enqueue(object : retrofit2.Callback<EmployeeResponse> {
            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                response.body()?.let {
                    employees = response.body()?.employee as MutableList<Employee>
                    ldEmployees.value = employees
                }

            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                t.message?.let { Log.d("error", it) }
            }

        })
        return ldEmployees
    }

  fun suppressWarning(){
      val context: Context? = null
     val mCheckBox = CheckBox("fdsafjsa")
  }
}