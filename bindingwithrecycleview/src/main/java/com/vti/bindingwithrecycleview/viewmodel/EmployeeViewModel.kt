package com.vti.bindingwithrecycleview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vti.bindingwithrecycleview.model.Employee
import com.vti.bindingwithrecycleview.model.EmployeeResponse
import com.vti.bindingwithrecycleview.repo.EmployeeRepo

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: EmployeeRepo? = null
    init {
        repository = EmployeeRepo()
    }
    fun getData(): MutableLiveData<MutableList<Employee>>? {
        return repository?.let {
            it.getEmployeeService()
        }
    }

}